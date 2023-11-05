import java.util.Scanner;

public class CarLotMain {
    public static void main (String [] args){
        int choice = 0;
        Scanner input = new Scanner(System.in);
        CarLot inventory = new CarLot();
        
        System.out.println("[0] Exit");
        System.out.println("[1] Add a car to inventory");
        System.out.println("[2] Sell a car from inventory");
        System.out.println("[3] List Inventory by rder of acquisition");
        System.out.println("[4] List inventory from best MPG to Worst MPG");
        System.out.println("[5] Display car with best MPG");
        System.out.println("[6] Display car with highest mileage");
        System.out.println("[7] Display overall MPG for the entire inventory");
        System.out.println("[8] Display Profit for all sold cars");

        System.out.print("Enter a number from 0 to 8");
        choice = input.nextInt();

        while (choice != 0){
            if (choice == 1){
                System.out.println("Enter id of car");
                String id = input.nextLine();
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
            else if (choice == 1){
                
            }
            else if (choice == 2){
                
            }
            else if (choice == 3){
                
            }
            else if (choice == 4){
                
            }
            else if (choice == 5){
                
            }
            else if (choice == 6){
                
            }
            else if (choice == 7){
                
            }
            else if (choice == 8){
                
            }
        }
    }
}
