# Etapa 1: constrói o jar dentro de um container Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Cria o diretório de trabalho
WORKDIR /build

# Copia arquivos do projeto
COPY pom.xml .
COPY src ./src

# Baixa as dependências e cria o jar (ignora os testes para agilizar)
RUN mvn clean package -DskipTests

# Etapa 2: imagem final, só com o jar já compilado
FROM eclipse-temurin:17-jdk-alpine

RUN apk add --no-cache curl

WORKDIR /app

# Copia o JAR gerado no build da etapa anterior
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]