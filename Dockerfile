FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copia todos os ficheiros do repositório
COPY . .

# Corrige a pasta no container se ela estiver como src/main
RUN if [ -d "src/main" ] && [ ! -d "src/main/java" ]; then \
      mkdir -p src && mv src/main src/main_temp && mv src/main_temp src/main ; \
    elif [ -d "src/main" ]; then \
      mkdir -p temp_src && mv src/main temp_src/main && mv temp_src src ; \
    fi

# Compila o projeto Spring Boot
RUN mvn clean package -DskipTests

# Estágio final para rodar a aplicação
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
