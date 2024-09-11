# Use uma imagem base do OpenJDK 22
FROM openjdk:22-jdk

# Defina o diretório de trabalho no container
WORKDIR /app

# Copie o arquivo JAR para o diretório de trabalho no container
COPY out/artifacts/cafeteria.jar /app/cafeteria.jar

# Copie o SDK do JavaFX para o container
COPY javafx-sdk-17 /app/javafx-sdk

# Defina o caminho do JavaFX e configure as variáveis de ambiente
ENV PATH=$PATH:/app/javafx-sdk/bin
ENV JAVA_OPTS="--module-path /app/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml"

# Defina o comando para executar sua aplicação Java
ENTRYPOINT ["java", "$JAVA_OPTS", "-jar", "cafeteria.jar"]
