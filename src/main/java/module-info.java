module com.example.rgzlinux {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rgzlinux to javafx.fxml;
    exports com.example.rgzlinux;
}