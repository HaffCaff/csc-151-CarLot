import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * CarLot class represents a car dealership's inventory of cars.
 * It allows adding cars, selling cars, and retrieving information about the cars.
 * @author Samip Khanal
 * @author Anthony Epps
 */
public class CarLot {
    public static final String CARLOT_INVENTORY_LOCATION="carlot.csv";
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

    public ArrayList<Car> getCarsSortedByMPG() {
        ArrayList<Car> inventoryCopy = new ArrayList<>(inventory);
        //Basic Selection sort, convert from Array to ArrayList
        for (int i = 0; i < inventoryCopy.size() - 1; i++) {
            
            int maxIndex = i;
            for (int j = i + 1; j < inventoryCopy.size(); j++) {
                if (inventoryCopy.get(j).compareMPG(inventoryCopy.get(maxIndex)) == 1){
                    maxIndex = j;
                }
            }

            Car temp = inventoryCopy.get(maxIndex);
            inventoryCopy.set(maxIndex, inventoryCopy.get(i));
            //This....I spent an EGREGEIOUS amount of time trying to figure out why this broke noy only this test, but other test
            // on the CarLotTester (It was doubling price of profit, or breaking Sold....BECAUSE I WAS CHANGING INVENTORY, NOT THE COPY....)
            //inventory.set(i, temp);
            // - Anthony Epps
            inventoryCopy.set(i,temp);
        }

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

    public void saveToDisk() throws FileNotFoundException{
        File file = new File(CARLOT_INVENTORY_LOCATION);
        // Probably could have made this more efficient
        // but since its a CSV, write each seperate var, using PRINTS, NOT PRINTLN
        // and then at the end add the new line char to start next one.
        // I did it this way so it would be easier to read back in when loading!
        // as parsing the ToString value of each car seems hard
        try {
            try (PrintWriter writer = new PrintWriter(file)) {
                for (int i=0;i<inventory.size();i++){
                    writer.print(inventory.get(i).getId() + ",");
                    writer.print(inventory.get(i).getMileage() + ",");
                    writer.print(inventory.get(i).getMpg() + ",");
                    writer.print(inventory.get(i).getCost() + ",");
                    writer.print(inventory.get(i).getSalesPrice());
                    writer.print("\n");
                }
            }

        } 
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
  

    }

    public void loadFromDisk() throws FileNotFoundException{
        File file = new File(CARLOT_INVENTORY_LOCATION);
        // this method only grabbed the last item line of csv? Apparently Next and NextLine get weird?
        // try (Scanner reader = new Scanner(file)) {
        //     reader.useDelimiter(",");
        //     while (reader.hasNextLine()){
        //         String line = reader.nextLine().trim(); //white space was causing errors
        //         if (!line.isEmpty()){ // if line has text, do the things
        //         String id = reader.next();
        //         int mile = Integer.parseInt(reader.next());
        //         int mpg = Integer.parseInt(reader.next());
        //         double cost = Double.parseDouble(reader.next());
        //         double sale = Double.parseDouble(reader.next());
        //         Car c = new Car(id, mile, mpg, cost, sale);
        //         inventory.add(c);
        //     }
        // }
            // so I am treating this like the midterm code part, where I took text in and saved into a list to manipulate that way
            try (Scanner reader = new Scanner(file)) {
            reader.useDelimiter(",");
            while (reader.hasNextLine()){
                String line = reader.nextLine().trim(); //white space was causing errors
                if (!line.isEmpty()){ // if line has text, do the things
                    String[] values =  line.split(",");
                    if (values.length == 5) {  //This only works because I know how many values are in the csv
                        String id = values[0];
                        int mile = Integer.parseInt(values[1]);
                        int mpg = Integer.parseInt(values[2]);
                        double cost = Double.parseDouble(values[3]);
                        double sale = Double.parseDouble(values[4]);
                        Car c = new Car(id, mile, mpg, cost, sale);
                        inventory.add(c);
                }
            }
        }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      
    }

    public void setInventory(){
        try {
            loadFromDisk();
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
    }
}
