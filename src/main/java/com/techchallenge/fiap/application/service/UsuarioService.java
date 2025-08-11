package com.techchallenge.fiap.application.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.techchallenge.fiap.domain.model.Endereco;
import com.techchallenge.fiap.domain.model.Perfil;
import com.techchallenge.fiap.domain.model.Usuario;
import com.techchallenge.fiap.domain.repository.UsuarioRepository;
import com.techchallenge.fiap.dto.InserirUsuarioDTO;
import com.techchallenge.fiap.dto.TrocaSenhaDTO;
import com.techchallenge.fiap.dto.AlterarUsuarioDTO;
import com.techchallenge.fiap.dto.UsuarioDTO;
import com.techchallenge.fiap.exception.CredenciaisInvalidasException;
import com.techchallenge.fiap.exception.RecursoNaoEncontradoException;
import com.techchallenge.fiap.exception.UsuarioExistenteException;
import com.techchallenge.fiap.mapper.UsuarioMapper;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
    private final PerfilService perfilService;
    private final EnderecoService enderecoService;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          PerfilService perfilService,
                          EnderecoService enderecoService) {
        this.usuarioRepository = usuarioRepository;
        this.perfilService = perfilService;
        this.enderecoService = enderecoService;
    }

    @Transactional
    public UsuarioDTO cadastrarUsuario(String cep, String numero, InserirUsuarioDTO dto) {
    	validarUsuarioExixtenteCriacao(dto.getEmail(), dto.getLogin());
    	
        Perfil perfil = perfilService.buscarPorId(dto.getIdPerfil());

        Endereco endereco = enderecoService.criarEndereco(cep, numero);

        Usuario usuario = UsuarioMapper.toEntity(dto, perfil, endereco);
        usuario.setDataUltimaAlteracao(LocalDateTime.now());

        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.toDTO(usuario);
    }
    
    @Transactional
    public UsuarioDTO atualizarUsuario(String cep, String numero, AlterarUsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
            .orElseThrow(() -> 
            	new RecursoNaoEncontradoException("Não foi possível encontrar o usuário com o e-mail: " + dto.getEmail()));

        validarUsuarioExistenteAtualizacao(dto.getEmail(), usuario.getIdUsuario());
        
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setDataUltimaAlteracao(LocalDateTime.now());

        if (dto.getIdPerfil() != null) {
            Perfil perfil = perfilService.buscarPorId(dto.getIdPerfil());
            usuario.setPerfil(perfil);
        }

        Endereco novoEndereco = enderecoService.criarEndereco(cep, numero);
        usuario.setEndereco(novoEndereco);

        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.toDTO(usuario);
    }
    
    @Transactional
    public void trocarSenhaPorEmail(String email, TrocaSenhaDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Não foi possível encontrar o usuário com o e-mail: " + email));
        if (!usuario.getSenha().equals(dto.getSenhaAtual())) {
            throw new CredenciaisInvalidasException("Credenciais Inválidas");
        }
        usuario.setSenha(dto.getNovaSenha());
        usuario.setDataUltimaAlteracao(LocalDateTime.now());
        usuarioRepository.save(usuario);
    }

    
    @Transactional
    public void deletarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> 
            	new RecursoNaoEncontradoException("Não foi possível encontrar o usuário com o e-mail: " + email));
        usuarioRepository.delete(usuario);
    }
    
    public UsuarioDTO buscarUsuarioDTOPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
        		.orElseThrow(() -> 
        			new RecursoNaoEncontradoException("Nenhum usuário foi encontrado com o email: " + email));
        return UsuarioMapper.toDTO(usuario);
    }
    
    private Usuario buscarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email).get();
        return usuario;
    }
    
    private Usuario buscarUsuarioPorLogin(String login) {
        Usuario usuario = usuarioRepository.findByLogin(login).get();
        return usuario;
    }

    private void validarUsuarioExixtenteCriacao(String email, String login) {
    	Usuario usuario = buscarUsuarioPorEmail(email);
    	if(usuario != null)
    		throw new UsuarioExistenteException("Já existe um usuário com o email: " + email);
    	
    	usuario = buscarUsuarioPorLogin(login);
    	
    	if(usuario != null)
    		throw new UsuarioExistenteException("Já existe um usuário com o login: " + login);
    }
    
    private void validarUsuarioExistenteAtualizacao(String email, Long idUsuario) {
        Usuario usuario = buscarUsuarioPorEmail(email);
        
        if (usuario != null && !usuario.getIdUsuario().equals(idUsuario)) {
            throw new UsuarioExistenteException("Já existe um usuário com o email: " + email);
        }
    }

}