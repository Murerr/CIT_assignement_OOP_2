package list;

import car.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;




public class ListTest {


    private java.util.List emptyList;
    private static ObservableList<Car> carList = FXCollections.observableArrayList(
            new Car("WolkWagen","132S","XV32584F",378871,1999),
            new Car("Peugeot","RET-75","U1HHA0EDEC",108784,1990),
            new Car("Peugeot","TFW14","CF08YDUS2W",150000,1987));


    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
        emptyList = new java.util.ArrayList();
    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {
        emptyList = null;
    }

    @Test
    public void testSomeBehavior() {
        assertEquals("Empty list should have 0 elements", 0, emptyList.size());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testForException() {
        Object o = emptyList.get(0);
    }


    /**
     * @Before Start with a list of 3 cars
     * @After add a 4th car to list
     */
    @Test
    public void addACarTolist(){
        Car car = new Car("WolkWagen","132S","XV32584F",378871,1999);
        assertEquals(3,carList.size());
        carList.add(car);
        assertEquals(4,carList.size());
    }

    /**
     * @Before List of car is now 4
     * @After remove the first car list size is now 3
     */
    @Test
    public void removeCarToList(){
        assertEquals(4,carList.size());
        if (!carList.isEmpty()){
            carList.remove(0);
        }
        assertEquals(3,carList.size());
    }


}