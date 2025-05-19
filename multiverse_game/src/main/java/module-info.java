module com.multiverse_adventure {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens com.multiverse_adventure to javafx.fxml;
    exports com.multiverse_adventure;
    opens com.multiverse_adventure.controller to javafx.fxml;
    exports com.multiverse_adventure.controller;
}
