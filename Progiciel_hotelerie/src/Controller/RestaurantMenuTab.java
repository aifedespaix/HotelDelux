package src.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;
import src.Metier.Menu;
import src.Metier.Plat;

/**
 * Created by ledze on 21/06/2017.
 */
public class RestaurantMenuTab {

    @FXML private JFXButton btnEnregistrer;
    @FXML private JFXButton btnDelete;
    @FXML private JFXButton btnNewMenu;
    @FXML private JFXTreeTableView<Plat> ttvPlat;
    @FXML private JFXTreeTableView<Plat> ttventree;
    @FXML private JFXTreeTableView<Plat> lvDessert;
    @FXML private JFXListView<Menu> lvMenu;



}
