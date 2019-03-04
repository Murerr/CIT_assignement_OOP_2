package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class CarController extends javafx.scene.control.Tab {

    private static ObservableList<Car> carList = FXCollections.observableArrayList(
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

    ListView<Car> carListView = new ListView<>(carList);
    Label allTheStarPrizeText;
    Label shoppingListText;
    Button addACarButton;
    ChoiceBox cb;
    GridPane gb;

    public CarController()
    {
        this.setText("Prize Panel");
        carList = getCarList();
        gb = new GridPane();
        Button pickButton = new Button();
        addACarButton = new Button("Add a car:\n");
        allTheStarPrizeText = new Label("Star Prize List : \n");
        shoppingListText = new Label("Shopping List : \n");
        pickButton.setText("Confirm");
        gb.add(carListView,1,1);
        gb.add(allTheStarPrizeText,2,1);
        gb.add(shoppingListText,2,2);
        gb.add(pickButton,1,2);
        gb.add(addACarButton,1,3);

        pickButton.setOnAction(event -> pickACar());
        addACarButton.setOnAction(event -> addACar(carList));

        gb.setAlignment(Pos.TOP_LEFT);
        this.setContent(gb);

    }


    private void pickACar(){

    }

    private ObservableList<Car> getCarList(){
        return FXCollections.observableArrayList(
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
                new Car("Renault","Clio","EYJ2WZEHXW",1004,1992)

        );
    }

    private void addACar(ObservableList<Car> carList){
        carList.add(new Car("Renault","Clio","EYJ2WZEHXW",1004,1992));
    }


}

