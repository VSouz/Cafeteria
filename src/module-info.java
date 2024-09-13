module cafeteria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    // Exporta pacotes para outros módulos
    opens javaFx.org.telaInicial;
    exports javaFx.org.telaInicial;
    opens javaFx.org.loginCliente;
    exports  javaFx.org.loginCliente;
    opens javaFx.org.geralController;
    exports javaFx.org.geralController;
    opens javaFx.org.homeCliente;
    exports  javaFx.org.homeCliente;
    opens javaFx.org.cadastroCliente;
    exports  javaFx.org.cadastroCliente;
    opens javaFx.org.loginFuncionario;
    exports  javaFx.org.loginFuncionario;
    opens javaFx.org.homeFuncionario;
    exports javaFx.org.homeFuncionario;
    opens javaFx.org.produto;
    exports  javaFx.org.produto;
    opens javaFx.org.pedido;
    exports javaFx.org.pedido;
    opens javaFx.org.cadastroFuncionario;
    exports javaFx.org.cadastroFuncionario;

}