import java.util.Scanner;

/**
 * The fuelPump class
 */

public class fuelPump {

    private static Scanner in = new Scanner(System.in);
    private static int fuelTank = 1000; //The tank counter.
    private int fuelCounter = 0; //The fuel counter, used for both pumps.
    private int fuelUsed = 0; //Used to calculate the price


    /**
     * Gets the fuel tank.
     *
     * @return the current amount of fuel in the tank
     */

    public int getFuelTank() {

        return fuelTank;
    }

    /**
     * Gets fuel counter.
     *
     * @return the fuel counter
     */

    public int getFuelCounter() {
        return fuelCounter;
    }

    /**
     * Sets fuel counter
     *
     * @param Fuel
     */
    public void setFuel(int Fuel) {
        this.fuelCounter = Fuel;
    }

    /**
     * Get turnover int.
     *
     * @param price the price for each liter of gas
     * @return price*fuelcounter
     */

    public int getTurnOver(int price) {
        return price * fuelUsed;
    }

    /**
     * Adds gas to the fuelTank.
     *
     * @param gas
     */

    public void addGas(int gas) {


        if (gas + fuelTank <= 1000) {
            fuelTank += gas;
            System.out.println("You successfully added " + gas + " liter of gas, the total is now " + fuelTank + " liter of gas");
        } else {
            System.out.println("You cant add more gas, the limit is reached.");
        }
        System.out.println("Press any key to continue.");
        in.next();
    }


    /**
     * Fills up the customers car with amount of gas
     * *
     *
     * @param gas the gas
     */

    public void fillUp(int gas) {

        if (fuelTank - gas > 0) {
            fuelTank -= gas;
            fuelUsed += gas;
        } else {
            System.out.println("Sorry - we are out of gas.");
        }


    }

    /**
     * Is used to restart the fuelUsed, so its possible to calculate a price.
     *
     * @param fuelUsed the fuel used
     */
    public void setFuelUsed(int fuelUsed) {
        this.fuelUsed = fuelUsed;
    }
}

