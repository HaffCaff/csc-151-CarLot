/**
 * CarLot Project : Step 2 (CarLot Class)
 * @author Anthony Epps
 * 
 */
import java.util.ArrayList;

public class CarLot {

    ArrayList<Car> inventory;

    // Mutator Methods

    /**
     * Add car to Car Lot inventory
     * 
     * @param id
     * @param mileage
     * @param mpg
     * @param cost
     * @param salesPrice
     */
    public void addCar(String id, int mileage, int mpg, double cost, double salesPrice){
        Car car = new Car(id, mileage, mpg, cost, salesPrice);
        inventory.add(car);

    }

    public void sellCar(String identifier, double priceSold) throws IllegalArgumentException{

       

    }

    //Accessor Methods
    public Car findCarByIdentifier(String identifier){
        String id = identifier;
        for (int i=0; i<inventory.size();i++){
            Car search = inventory.get(i);
            if (search.getId().equals(id)){
                return inventory.get(i);
            }
            else {
                return null;
            }
        }
    }

    
}
