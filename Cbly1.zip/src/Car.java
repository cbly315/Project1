/**
* <The car class makes a vehicle with make, year, and price. 
* Make is the brand of car.
* Year is the year the car was made.
* Price is the price of the vehicle.>
*
* CSC 1351 Programming Project No <1>
* 
* Section <1>
*
* @author <Cameron Bly>
* @since <March 17th, 2024>
*
*/
public class Car implements Comparable<Car> {
    String make;
    int year;
    private int price;

    /**
    * <initializes make, year, and price>
    *
    * CSC 1351 Programming Project No <enter project number here>
    * Section <1>
    *
    * @author <Cameron Bly>
    * @since <March 17th, 2024>
    *
    */
    public Car(String make, int year, int price) {
        this.make = make;
        this.year = year;
        this.price = price;
    }

    /**
     * <returns make (brand) of the car>
     *
     * CSC 1351 Programming Project No <enter project number here>
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    public String getMake() {
        return make;
    }

    /**
     * <returns year the car was made>
     *
     * CSC 1351 Programming Project No <enter project number here>
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    public int getYear() {
        return year;
    }

    /**
     * <returns price of the car>
     *
     * CSC 1351 Programming Project No <enter project number here>
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    public int getPrice() {
        return price;
    }

    /**
     * <allows comparison of make, year, and price of two cars>
     *
     * CSC 1351 Programming Project No <enter project number here>
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    @Override
    public int compareTo(Car other) {
        int makeComparison = this.make.compareTo(other.make);
        if (makeComparison != 0) {
            return makeComparison;
        }

        return Integer.compare(this.year, other.year);
    }

    /**
     * <creates string that prints out the make, year, and price of each car>
     *
     * CSC 1351 Programming Project No <enter project number here>
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    @Override
    public String toString() {
        return "Make: " + make + ", Year: " + year + ", Price: " + price + ";";
    }
    
}