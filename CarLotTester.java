/**
 * CarLot Project : Step 3(CarLotMain Class)
 * @author Anthony Epps
 * 
 */
public class CarLotTester {
    public static void main (String [] args) throws Exception{
        CarLot Lot = new CarLot();

        Lot.addCar("2008 Toyota Camry", 5000, 25, 10900.00, 13900.00);
        Lot.addCar("2023 Toyota Camry", 0, 35, 32165.00, 34200.00);
        
        
        System.out.println("Lot Inventory: "+ Lot.getInventory() + "\n");
        System.out.println("Lot Inventory in order of entry" + Lot.getCarsInOrderOfEntry()+ "\n");
        System.out.println("Lot Inventory in order of of MPG" + Lot.getCarsSortedByMPG()+ "\n");
        System.out.println("Cars on lot have average MPG of: " + Lot.getAverageMPG()+ "\n");
        System.out.println("Looking for 2008 Toyota Camry, should find: " + Lot.findCarByIdentifier("2008 Toyota Camry")+ "\n");
        System.out.println("Looking for 2008 Honda Civic, should fail. ");
        if (Lot.findCarByIdentifier("08 Honda Civic") == null){
            System.err.println("Car not Found \n");
        };
        System.out.println("Car with the best MPG on the lot: " +Lot.getCarWithBestMPG()+ "\n");
        System.out.println("Car with the highest Mileage on the lot: " +Lot.getCarWithHighestMileage()+ "\n");
        Lot.sellCar("2023 Toyota Camry", 35000.00);
        System.out.println("The Lot sold the 2023 Camry");
        System.out.println(Lot.findCarByIdentifier("2023 Toyota Camry")+ "\n");
        System.out.println("We should have profit from selling the 2023 Camry: " + Lot.getTotalProfit()+ "\n");

       



    }
}
