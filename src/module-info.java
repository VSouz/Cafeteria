module org.telaInicial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

//    requires org.kordamp.bootstrapfx.core;

    opens org.telaInicial.telaInicial to javafx.fxml;
    exports org.telaInicial.telaInicial;
}