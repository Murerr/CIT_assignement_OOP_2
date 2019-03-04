package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    HBox hb;
    Button addButton;
    Button deleteButton;

    TextField store;
    TextField model;
    TextField registration;
    TextField millage;
    TextField yearOfManufacture;

    Label storeLabel;
    Label modelLabel;
    Label registrationLabel;
    Label millageLabel;
    Label yearOfManufactureLabel;

    GridPane gp;

    public CarController()
    {
        this.setText("Prize Panel");
        hb  = new HBox();
        addButton = new Button("Add\n");
        deleteButton = new Button("Delete\n");

        store = new TextField();
        model = new TextField();
        registration = new TextField();
        millage = new TextField();
        yearOfManufacture = new TextField();

        storeLabel = new Label("Store");
        modelLabel = new Label("Model");
        registrationLabel = new Label("Registration");
        millageLabel = new Label("Milleage");
        yearOfManufactureLabel = new Label("Year");

        carListView.setPrefWidth(800);
        carListView.setPrefHeight(100);
        addButton.setOnAction(event -> addCar(carList,getUserInput()));
        deleteButton.setOnAction(event -> deleteCar(carList,carListView.getSelectionModel().getSelectedIndex()));
        gp = new GridPane();
        gp.add(storeLabel,0,0);
        gp.add(modelLabel,0,1);
        gp.add(registrationLabel,0,2);
        gp.add(millageLabel,0,3);
        gp.add(yearOfManufactureLabel,0,4);

        gp.add(store,1,0);
        gp.add(model,1,1);
        gp.add(registration,1,2);
        gp.add(millage,1,3);
        gp.add(yearOfManufacture,1,4);

        hb.getChildren().addAll(carListView,deleteButton,addButton);
        hb.getChildren().add(gp);
        hb.setSpacing(3);

        this.setContent(hb);

    }



    private void deleteCar(ObservableList<Car> carList,int carIndex) {
        carList.remove(carIndex);
    }

    private void addCar(ObservableList<Car> carList, Map<String, String> userInput){
        carList.add(new Car(
                userInput.get("store"),
                userInput.get("model"),
                userInput.get("registration"),
                Integer.parseInt(userInput.get("millage")),
                Integer.parseInt(userInput.get("yearOfManufacture"))));
    }

    private Map<String, String> getUserInput(){

        Map<String, String> userInput = new HashMap<String, String>() {{
            put("store",store.getText());
            put("model",model.getText());
            put("registration",registration.getText());
            put("millage",millage.getText());
            put("yearOfManufacture",yearOfManufacture.getText());
        }};

        return userInput;
    }


}

