package controller;

import car.Car;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create a tab that contqin a listView of car
 */
public class ControllerBasicListing extends javafx.scene.control.Tab {


    ListView<Car> carListView;

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

    /**
     * @param panelTitle The Title of the pqnel
     * @param carComparator The comparator of the list how the list should be sorted
     * @param carList The list to be displayed and sorted within the the tab
     */
    public ControllerBasicListing(String panelTitle, Comparator<Car> carComparator, ObservableList<Car> carList)
    {
        this.setText(panelTitle);

        carList.sort(carComparator);
        carListView = new ListView<>(carList);

        hb = new HBox();
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
        gp.add(deleteButton,1,5);


        hb.getChildren().addAll(carListView,deleteButton,addButton);
        hb.getChildren().add(gp);
        hb.setSpacing(3);



        addButton.setOnAction(event -> addCar(carList,getUserInput()));
        deleteButton.setOnAction(event -> deleteCar(carList,carListView.getSelectionModel().getSelectedIndex()));

        this.setContent(hb);


    }

    /**
     * @param carList The car list
     * @param carIndex The index of the car list
     */
    private void deleteCar(List<Car> carList, int carIndex) {
        carList.remove(carIndex);
    }

    /**
     * @param carList The car list
     * @param userInput The Field key in by the user
     */
    private void addCar(List<Car> carList, Map<String, String> userInput){
        carList.add(new Car(
                userInput.get("store"),
                userInput.get("model"),
                userInput.get("registration"),
                Integer.parseInt(userInput.get("millage")),
                Integer.parseInt(userInput.get("yearOfManufacture"))));
    }

    /**
     * @return Return a String map of the user input key in in the TextField
     */
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


