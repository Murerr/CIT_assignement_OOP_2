package car;
/**
 * A car Object
 */
public class Car extends CarBasic implements Cloneable {

    private String store;
    private String model;
    private String registration;
    private int millage;
    private int yearOfManufacture;

    /**
     * @param store The store where the car was created
     * @param model The model of the car
     * @param registration The registration sign of the car
     * @param millage The number of kilometers the car travelled
     * @param yearOfManufacture The year the car was created
     */
    public Car(String store, String model, String registration, int millage, int yearOfManufacture) {
        super(store, model, registration);
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

    public Car clone() throws CloneNotSupportedException { return (Car)super.clone(); }

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
