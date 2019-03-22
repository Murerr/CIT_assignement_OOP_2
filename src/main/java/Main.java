import car.Car;
import controller.CarController;
import controller.ControllerBasicListing;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Comparator;


/**
 * Create the GUI
 */
public class Main extends Application {
    private static ObservableList<Car>carList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane mainPane = new BorderPane();
            Group root = new Group();
            Scene scene = new Scene(root,1200,800);

            TabPane tp = new TabPane();
            tp.getTabs().add (new CarController(getCarList()));
            tp.getTabs().add (new ControllerBasicListing("Car Sorted by Store",getCarComparatorOrderedbyStore(),getCarList()));
            tp.getTabs().add (new ControllerBasicListing("Car Sorted by Milleage",getCarComparatorOrderedbyMilleage(), getCarList()));
            tp.getTabs().add (new ControllerBasicListing("Car Sorted by Year of Manufacture",getCarComparatorOrderedbyYearOfManufacture(), getCarList()));

            mainPane.setCenter(tp);
            mainPane.prefHeightProperty().bind(scene.heightProperty());
            mainPane.prefWidthProperty().bind(scene.widthProperty());

            root.getChildren().add(mainPane);
            primaryStage.setTitle("Assignement 2 Rudy MURER R00171701");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return a comparator on year of manufacture
     */
    private Comparator<Car> getCarComparatorOrderedbyYearOfManufacture() {
        Comparator<Car> carComparator
                = Comparator.comparing(
                Car::getYearOfManufacture, Comparator.reverseOrder());
        return carComparator;
    }

    /**
     * @return a comparator on Milleage
     */
    private Comparator<Car> getCarComparatorOrderedbyMilleage() {
        Comparator<Car> carComparator
                = Comparator.comparing(
                Car::getMillage, Comparator.reverseOrder());
        return carComparator;
    }

    /**
     * @return a comparator on store name
     */
    private Comparator<Car> getCarComparatorOrderedbyStore() {
        Comparator<Car> carComparator
                = Comparator.comparing(
                Car::getStore, Comparator.reverseOrder());
        return carComparator;
    }


    /**
     * @return an Observable list of Car
     */
    private ObservableList<Car >getCarList(){
        return carList = FXCollections.observableArrayList(
                new Car("WolkWagen","132S","XV32584F",378871,1999),
                new Car("Peugeot","RET-75","U1HHA0EDEC",108784,1990),
                new Car("Peugeot","TFW14","CF08YDUS2W",150000,1987),
                new Car("Subaru","5G","GY2P76F0DF",173929,1957),
                new Car("Ferrari","FAST-89","478UHWS70N",264433,2004),
                new Car("WolkWagen","AR-F14","BT3L86J3V0",185858,2007),
                new Car("Subaru","125F","0AJ79Y6DVT",94029,2001),
                new Car("Ferrari","9F","XRO29EIQ57",527773,2008),
                new Car("Peugeot","Lion2A","Y1F65DXI3Q",14520,2014),
                new Car("Renault","Twingo","GSJCCY0AYT",125,1995),
                new Car("Renault","Clio","EYJ2WZEHXW",1004,1992));
    }
}
