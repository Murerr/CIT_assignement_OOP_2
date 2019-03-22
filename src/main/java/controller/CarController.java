package controller;

import car.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a tab containing a TableView of all car
 */
public class CarController extends javafx.scene.control.Tab {

    TableView table;
    HBox hb;
    VBox vb;
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

    TableColumn storeTable;
    TableColumn modelTable;
    TableColumn registrationTable;
    TableColumn millageTable;
    TableColumn yearofManufactureTable;

    private ObservableList<TableColumn> listTables = FXCollections.observableArrayList(
            storeTable = new TableColumn("Store"),
            modelTable = new TableColumn("Model"),
            registrationTable = new TableColumn("Registration"),
            millageTable = new TableColumn("Millage"),
            yearofManufactureTable = new TableColumn("Year of Manufacture"));

    GridPane gp;

    /**
     * @param carList The car list
     *
     */
    public CarController(ObservableList<Car> carList)
    {
        this.setText("Car Panel");
        table = new TableView();
        vb = new VBox();
        table.setEditable(true);
        table.getColumns().addAll(listTables);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        vb.setSpacing(5);
        vb.setPadding(new Insets(10, 0, 0, 10));


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

        gp = new GridPane();
        gp.add(storeLabel,0,0);
        gp.add(modelLabel,1,0);
        gp.add(registrationLabel,2,0);
        gp.add(millageLabel,3,0);
        gp.add(yearOfManufactureLabel,4,0);
        gp.add(deleteButton,5,0);

        gp.add(store,0,1);
        gp.add(model,1,1);
        gp.add(registration,2,1);
        gp.add(millage,3,1);
        gp.add(yearOfManufacture,4,1);
        gp.add(addButton,5,1);

        hb.getChildren().add(gp);
        hb.setSpacing(3);

        storeTable.setCellValueFactory(new PropertyValueFactory<Car, String>("store"));
        modelTable.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
        registrationTable.setCellValueFactory(new PropertyValueFactory<Car, String>("registration"));
        millageTable.setCellValueFactory(new PropertyValueFactory<Car, String>("millage"));
        yearofManufactureTable.setCellValueFactory(new PropertyValueFactory<Car, String>("yearOfManufacture"));
        table.setItems(carList);


        addButton.setOnAction(event -> addCar(carList,getUserInput()));
        deleteButton.setOnAction(event -> deleteCar(carList,table.getSelectionModel().getSelectedIndex()));

        vb.getChildren().addAll(table,hb);
        cloneMyCars(carList);
        this.setContent(vb);

    }

    /**
     * @param carList The car list to be clone
     * Clone the first element of the list 1000 times
     * If the list is empty nothing happend
     */
    private void cloneMyCars(ObservableList<Car> carList) {
        if (!carList.isEmpty()){
             Car carToBeCloned = carList.get(0);
             ArrayList<Car> tempList = new ArrayList<Car>();
             for (int i=0;i<1000;i++){
                 try {
                     Car car = carToBeCloned.clone();
                     tempList.add(car);
                 } catch (CloneNotSupportedException e) {
                     e.printStackTrace();
                 }
             }
             carList.addAll(tempList);
        }
    }

    /**
     * @param carList The car list
     * @param carIndex The car index
     * delete the car at the list index
     */
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

    /**
     * @return Retrieve User input in a <String,String>Map
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

