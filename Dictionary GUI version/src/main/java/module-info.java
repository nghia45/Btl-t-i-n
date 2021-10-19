module com.example.telstar_dictionary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires freetts;

    opens com.example.telstar_dictionary to javafx.fxml;
    exports com.example.telstar_dictionary;
}