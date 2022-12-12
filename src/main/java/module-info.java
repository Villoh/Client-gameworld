module com.mj.cliente {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;

    opens com.mj.cliente to javafx.fxml;
    exports com.mj.cliente;
    exports com.mj.cliente.controller;
    opens com.mj.cliente.controller to javafx.fxml;
}
