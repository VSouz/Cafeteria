module cafeteria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    // Exporta pacotes para outros módulos
    opens javaFx.org.telaInicial;
    exports javaFx.org.telaInicial;
    opens javaFx.org.loginCliente;
    exports  javaFx.org.loginCliente;
}