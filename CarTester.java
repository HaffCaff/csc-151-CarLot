public class CarTester {
    public static void main (String [] args){
        Car a = new Car();
        Car b = new Car("08 Toyota Camry", 5000, 25, 10900.00, 13900.00);

        a.setId("2023 Toyota Camry");
        a.setMileage(0);
        a.setMpg(35);
        a.setCost(32165.00);
        a.setSalesPrice(34200.00);
        
        System.out.println("This comparison should return a postive number: " + a.compareMPG(b));
        
        System.out.println("This comparison should return a negative number: " + a.compareMileage(b));
       
        System.out.println("This comparison should return a postive number: " + a.compareSalesPrice(b));

        a.sellCar(35000.00);

        System.out.println("Car A should display true for is sold: " + a.isSold());
        System.out.println("Car A should have a profit of 35000-32165 = 2,835. Profit: " + a.getProfit());

    }
}
