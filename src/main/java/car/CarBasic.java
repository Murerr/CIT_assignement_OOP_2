package car;

public class CarBasic {

    private String store;
    private String model;
    private String registration;

    public CarBasic(String store, String model, String registration) {
        this.store = store;
        this.model = model;
        this.registration = registration;
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


    @Override
    public String toString() {
        return "Car{" +
                "store='" + store + '\'' +
                ", model='" + model + '\'' +
                ", registration='" + registration + '\'' +
                '}';
    }
}
