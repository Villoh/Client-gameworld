import static javafx.application.Application.launch;
module com.mj.cliente {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.xml.bind;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;
    requires org.apache.commons.io;
    requires java.base;
    

    opens com.mj.cliente to javafx.fxml;
    exports com.mj.cliente;
    //exports com.mj.cliente.controller;
    opens com.mj.cliente.controller to javafx.fxml;
}
