package src.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import src.Launcher.Launcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuRight implements Initializable {

    private String login;

    @FXML private Text usernameLabel;

    BorderPane root = Launcher.getRoot();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameLabel.setText(Login.getUsername());
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void update() {
        this.usernameLabel.setText(login);
    }

    public void disconnection() throws IOException {
        root.setTop(null);

        URL login = getClass().getResource("/src/Views/login.fxml");
        AnchorPane login2 = FXMLLoader.load(login);
        root.setCenter(login2);
    }

}
