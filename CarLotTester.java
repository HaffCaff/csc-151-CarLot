public class CarLotTester {
    public static void main (String [] args) throws Exception{
        CarLot Lot = new CarLot();

        Lot.addCar("08 Toyota Camry", 5000, 25, 10900.00, 13900.00);
        Lot.addCar("2023 Toyota Camry", 0, 35, 32165.00, 34200.00);
        
        System.out.println("Lot Inventory: "+ Lot.getInventory());
        System.out.println("Lot Inventory in order of entry" + Lot.getCarsInOrderOfEntry());
        System.out.println("Cars on lot have average MPG of: " + Lot.getAverageMPG());
        System.out.println("Looking for 08 Toyota Camry, should find: " + Lot.findCarByIdentifier("08 Toyota Camry"));
        System.out.println("Looking for 08 Honda Civic, should fail. ");
        if (Lot.findCarByIdentifier("08 Honda Civic") == null){
            System.err.println("Car not Found");
        };
        System.out.println("Car with the best MPG on the lot: " +Lot.getCarWithBestMPG());
        System.out.println("Car with the highest Mileage on the lot: " +Lot.getCarWithHighestMileage());
        Lot.sellCar("2023 Toyota Camry", 35000.00);
        System.out.println("The Lot sold the 2023 Camry");
        System.out.println(Lot.findCarByIdentifier("2023 Toyota Camry"));
        System.out.println("We should have profit from selling the 2023 Camry: " + Lot.getTotalProfit());

       



    }
}
