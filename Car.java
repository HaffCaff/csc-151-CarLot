/**
 * CarLot Project : Step1(Car Class)
 * @author Samip Khanal
 * 
 */
public class Car {

    private String id;
    private int mileage;
    private int mpg;
    private double cost;
    private double salesPrice;
    private boolean sold;
    private double priceSold;
    private double profit;

    /**
     * Default empty conctructor
     */
    public Car() {
    }

    /**
     * 
     * Constructor for adding a new car to the inventory
     */
    
    public Car(String id, int mileage, int mpg, double cost, double salesPrice) {
        this.id = id;
        this.mileage = mileage;
        this.mpg = mpg;
        this.cost = cost;
        this.salesPrice = salesPrice;
        this.sold = false;
        this.priceSold = 0;
        this.profit = 0;
    }

    // Accessors and mutators

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }
    /**
     * 
     * @param id
     * setter method to set id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return milage 
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * 
     * @param mileage
     * setter method to set mileage
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**
     * 
     * @return  mpg 
     */
    public int getMpg() {
        return mpg;
    }

    /**
     * 
     * @param mpg
     * setter method for mpg
     */
    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    /**
     * 
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * 
     * @param cost
     * setter method for cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * 
     * @return sales price
     */
    public double getSalesPrice() {
        return salesPrice;
    }

    /**
     * 
     * @param salesPrice
     * setter method of sales price
     */
    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    /**
     * 
     * @return wheter a car is sold or not
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * 
     * @param sold
     * setter method to setSold boolean
     */
    public void setSold(boolean sold) {
        this.sold = sold;
    }

    /**
     * 
     * @return  pricesold 
     */
    public double getPriceSold() {
        return priceSold;
    }

    /**
     * 
     * @param priceSold
     * setter methoid for price sold
     */
    public void setPriceSold(double priceSold) {
        this.priceSold = priceSold;
    }

    /**
     * 
     * @return profit
     */
    public double getProfit() {
        return profit;
    }

    /**
     * 
     * @param profit
     * setter method for profit
     */
    public void setProfit(double profit) {
        this.profit = profit;
    }

    // Comparison methods
    /**
     * 
     * @param otherCar
     * @return comparsison for cars
     */
    public int compareMPG(Car otherCar) {
        if (this.mpg < otherCar.mpg) {
            return -1;
        } else if (this.mpg > otherCar.mpg) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 
     * @param otherCar
     * @return returns an integer value that indicates whether the current car has fewer, more, 
     * or the same number of miles as the other car that is passed in as a parameter.
     */
    public int compareMiles(Car otherCar) {
        if (this.mileage < otherCar.mileage) {
            return -1;
        } else if (this.mileage > otherCar.mileage) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 
     * @param otherCar
     * @return an integer value that indicates whether the current car's sales price is less than, 
     * more than, or the same as the sales price of the other car that is passed in as a parameter.
     */
    public int comparePrice(Car otherCar) {
        if (this.salesPrice < otherCar.salesPrice) {
            return -1;
        } else if (this.salesPrice > otherCar.salesPrice) {
            return 1;
        } else {
            return 0;
        }
    }


    /**
     * 
     * @param priceSold
     * sell car method
     */
    public void sellCar(double priceSold) {
        this.sold = true;
        this.priceSold = priceSold;
        this.profit = priceSold - cost;
    }

    /**
     * toString() method
     */
    @Override
    public String toString() {
        return "Car: " + id + ", Mileage: " + mileage + ", MPG: " + mpg + ", Sold: " + sold
                + ", Cost: $" + cost + ", Selling price: $" + salesPrice + ", Sold For: $" + priceSold
                + ", Profit: $" + profit;
    }
}
