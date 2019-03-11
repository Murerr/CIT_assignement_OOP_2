package Controller;

public class Car {

    private String store;
    private String model;
    private String registration;
    private int millage;
    private int yearOfManufacture;

    public Car(String store, String model, String registration, int millage, int yearOfManufacture) {
        this.store = store;
        this.model = model;
        this.registration = registration;
        this.millage = millage;
        this.yearOfManufacture = yearOfManufacture;
    }


    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String toString() {
        return "Car{" +
                "store='" + store + '\'' +
                ", model='" + model + '\'' +
                ", registration='" + registration + '\'' +
                ", millage=" + millage +
                ", yearOfManufacture=" + yearOfManufacture +
                '}';
    }
}
