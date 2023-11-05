import java.util.Scanner;

public class CarLotMain {
    public static void main (String [] args) throws Exception{
        int choice = 0;
        Scanner input = new Scanner(System.in);
        CarLot inventory = new CarLot();
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

         if (choice == 1){
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
            else if (choice == 2){
                System.out.println("Enter vehicle id");
                String identifier = input.next();
                System.out.println("Enter how much the vehicle sold for: ");
                double sellPrice = input.nextDouble();
                inventory.sellCar(identifier, sellPrice);             
            }
            else if (choice == 3){
                System.out.println("Inventory List by aquisition:" + inventory.getCarsInOrderOfEntry());
            }
            else if (choice == 4){
                System.out.println(" Work in Progress");
            }
            else if (choice == 5){
                System.out.println("The car with the best MPG is : " + inventory.getCarWithBestMPG());
            }
            else if (choice == 6){
                System.out.println("The car with the highest mileage is : " + inventory.getCarWithHighestMileage());
            }
            else if (choice == 7){
                System.out.println("The average MPG of all cars currently in inventory: " + inventory.getAverageMPG());
            }
            else if (choice == 8){
                System.out.println("Total Profit for all sold cars: " + inventory.getTotalProfit());
            }
        } while (choice != 0);
            
    }
}
