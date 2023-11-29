/**
 * CarLot Project : Step 3(CarLotMain Class)
 * @author Anthony Epps
 * 
 */
import java.util.Scanner;

public class CarLotMain {
    public static void main (String [] args) throws Exception{
        // Create and initialize choice variable and Scanner input, create CarLot Inventory
        int choice = 0;
        Scanner input = new Scanner(System.in);
        CarLot inventory = new CarLot();
        
        //Create do while loop to hold and control the logic
        do {
        System.out.println();
        System.out.println("[0] Exit");
        System.out.println("[1] Add a car to inventory");
        System.out.println("[2] Sell a car from inventory");
        System.out.println("[3] List Inventory by rder of acquisition");
        System.out.println("[4] List inventory from best MPG to Worst MPG");
        System.out.println("[5] Display car with best MPG");
        System.out.println("[6] Display car with highest mileage");
        System.out.println("[7] Display overall MPG for the entire inventory");
        System.out.println("[8] Display Profit for all sold cars");

        System.out.print("Enter a number from 0 to 8: ");
        choice = input.nextInt();

         if (choice == 1){  // Option 1: Add a Car
                System.out.println("Enter id of car");
                String id = input.next();
                System.out.println("Enter mileage of car");
                int mileage = input.nextInt();
                System.out.println("Enter mpg of car");
                int mpg = input.nextInt();
                System.out.println("Enter cost of car");
                double cost = input.nextDouble();
                System.out.println("Enter sales price of car");
                double price = input.nextDouble();
                inventory.addCar(id, mileage, mpg, cost, price);
            }
            else if (choice == 2){ // Option 2: Sell a Car
                System.out.println("Enter vehicle id");
                String identifier = input.next();
                System.out.println("Enter how much the vehicle sold for: ");
                double sellPrice = input.nextDouble();
                inventory.sellCar(identifier, sellPrice);             
            }
            else if (choice == 3){ // Option 3: List cars by order of aquisition!
                System.out.println("Inventory List by aquisition:" + inventory.getCarsInOrderOfEntry());
            }
            else if (choice == 4){ // Option 4: List cars from best MPG to worst MPG
                System.out.println(" Inventory List by MPG" + inventory.getCarsSortedByMPG());
            }
            else if (choice == 5){ // Option 5: Display the car with the best MPG
                System.out.println("The car with the best MPG is : " + inventory.getCarWithBestMPG());
            }
            else if (choice == 6){ // Option 6: Display the car with the highest mileage
                System.out.println("The car with the highest mileage is : " + inventory.getCarWithHighestMileage());
            }
            else if (choice == 7){ // Option 7: Display the average mpg of all cars in inventory
                System.out.println("The average MPG of all cars currently in inventory: " + inventory.getAverageMPG());
            }
            else if (choice == 8){ // Option 8: Display the total profit for all sold cars
                System.out.println("Total Profit for all sold cars: " + inventory.getTotalProfit());
            }
        } while (choice != 0);

        input.close();
            
    }
}
