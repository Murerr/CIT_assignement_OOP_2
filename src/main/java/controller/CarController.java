package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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

    public CarController()
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
        this.setContent(vb);

    }

    private <T> TableColumn<T, ?> getTableColumnByName(TableView<T> tableView, String name) {
        for (TableColumn<T, ?> col : tableView.getColumns())
            if (col.getText().equals(name)) return col ;
        return null ;
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

