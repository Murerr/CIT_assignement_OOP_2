package car;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    /**
     * @throws CloneNotSupportedException
     * Is the car cloned equal to the car
     */
    @Test
    public void isClonedCarKeepingTheSameFields() throws CloneNotSupportedException {
        Car car = new Car("WolkWagen","132S","XV32584F",378871,1999);
        Car carCloned = car.clone();

        assertEquals(car.getStore(),carCloned.getStore());
        assertEquals(car.getModel(),carCloned.getModel());
        assertEquals(car.getRegistration(),carCloned.getRegistration());
        assertEquals(car.getMillage(),carCloned.getMillage());
        assertEquals(car.getYearOfManufacture(),carCloned.getYearOfManufacture());
    }


    /**
     * @throws CloneNotSupportedException
     * Test if the cloned car is equal to yearofmanufacture +1;
     */
    @Test
    public void addOneYearOfManufactureToClonedCar() throws CloneNotSupportedException {
        Car car = new Car("WolkWagen","132S","XV32584F",378871,1999);
        Car carCloned = car.clone();
        carCloned.setYearOfManufacture(car.getYearOfManufacture()+1);

        assertEquals(car.getYearOfManufacture(),1999);
        assertEquals(carCloned.getYearOfManufacture(),2000);
        assertEquals(car.getYearOfManufacture()+1,carCloned.getYearOfManufacture());
    }


}