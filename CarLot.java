import java.util.ArrayList;
import java.util.ListIterator;

/**
 * CarLot class represents a car dealership's inventory of cars.
 * It allows adding cars, selling cars, and retrieving information about the cars.
 * @author Samip Khanal
 */
public class CarLot {
    private ArrayList<Car> inventory = new ArrayList<>();


    /**
     * Default Constructor
     */
    public CarLot() {};
    /**
     * Gets the list of cars in the inventory.
     * @return The list of cars in the inventory.
     */
    public ArrayList<Car> getInventory() {
        return this.inventory;
    }

    /**
     * Adds a new car to the inventory.
     * @param id The unique identifier of the car.
     * @param mileage The mileage of the car.
     * @param mpg The miles per gallon of the car.
     * @param cost The cost of the car.
     * @param salesPrice The selling price of the car.
     */
    public void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
        Car c = new Car(id, mileage, mpg, cost, salesPrice);
        inventory.add(c);
    }

    /**
     * Attempts to sell a car with the given identifier and records the selling price.
     * @param identifier The unique identifier of the car to be sold.
     * @param priceSold The price at which the car is sold.
     * @throws Exception If the car cannot be found or if it has already been sold.
     */
    public void sellCar(String identifier, double priceSold) throws IllegalArgumentException {
        Car c = null;
        boolean sold = false;
        ListIterator<Car> it = inventory.listIterator();
        while (it.hasNext()) {
            c = it.next();
            if (!c.isSold() && identifier.equalsIgnoreCase(c.getId())) {
                c.sellCar(priceSold);
                sold = true;
                break;
            }
        }
        if (!sold) {
            throw new IllegalArgumentException("Car cannot be sold or was not found.");
        }
    }

    /**
     * Finds a car in the inventory by its unique identifier.
     * @param identifier The unique identifier of the car to be found.
     * @return The car object if found, or null if not found.
     */
    public Car findCarByIdentifier(String identifier) {
        Car foundCar = null;
        ListIterator<Car> it = inventory.listIterator();
        while (it.hasNext()) {
            Car c = it.next();
            if (identifier.equalsIgnoreCase(c.getId())) {
                foundCar = c;
                break;
            }
        }
        return foundCar;
    }

    /**
     * Returns a copy of the inventory, preserving the order of entry.
     * @return A copy of the inventory.
     */
    public ArrayList<Car> getCarsInOrderOfEntry() {
        ArrayList<Car> inventoryCopy = new ArrayList<>(inventory);
        return inventoryCopy;
    }

    /**
     * Returns the car with the best miles per gallon (MPG).
     * @return The car with the best MPG.
     * @throws Exception If there are no cars in the inventory.
     */
    public Car getCarWithBestMPG() throws Exception {
        if (inventory.isEmpty()) {
            throw new Exception("No cars in inventory.");
        }
        
        Car bestMPGCar = inventory.get(0);
        for (Car c : inventory) {
            if (c.compareMPG(bestMPGCar) > 0) {
                bestMPGCar = c;
            }
        }
        return bestMPGCar;
    }

    /**
     * Returns the car with the highest mileage.
     * @return The car with the highest mileage.
     * @throws Exception If there are no cars in the inventory.
     */
    public Car getCarWithHighestMileage() throws Exception {
        if (inventory.isEmpty()) {
            throw new Exception("No cars in inventory.");
        }
        
        Car highestMileageCar = inventory.get(0);
        for (Car c : inventory) {
            if (c.compareMileage(highestMileageCar) > 0) {
                highestMileageCar = c;
            }
        }
        return highestMileageCar;
    }

    /**
     * Calculates and returns the average MPG of all cars in the inventory.
     * @return The average MPG of all cars.
     * @throws Exception If there are no cars in the inventory.
     */
    public double getAverageMPG() throws Exception {
        if (inventory.isEmpty()) {
            throw new Exception("No cars in inventory.");
        }
        
        double totalMPG = 0;
        for (Car c : inventory) {
            totalMPG += c.getMpg();
        }
        return totalMPG / inventory.size();
    }

    /**
     * Calculates and returns the total profit earned from selling cars in the inventory.
     * @return The total profit from sold cars.
     * @throws Exception If there are no cars in the inventory.
     */
    public double getTotalProfit() throws Exception {
        if (inventory.isEmpty()) {
            throw new Exception("No cars in inventory.");
        }
        
        double totalProfit = 0;
        for (Car c : inventory) {
            if (c.isSold()) {
                totalProfit += c.getProfit();
            }
        }
        return totalProfit;
    }
}
