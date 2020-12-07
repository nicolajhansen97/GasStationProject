import java.util.Scanner;

public class gasStation {

    static Scanner in = new Scanner(System.in);
    static int menuChoice = -1;
    static fuelPump fuelPump1 = new fuelPump();
    static fuelPump fuelPump2 = new fuelPump();

    public static void main(String[] args) {

        fuelPump1.setFuel(500);
        fuelPump2.setFuel(500);

        while (true) {
            System.out.println("*------------------------------------------------------------------------------*");
            System.out.println("|                           Welcome to the Gas Station                         |");
            System.out.println("*------------------------------------------------------------------------------*");
            System.out.println("|Press 1. to use the pumps to put gas on your vehicle                          |");
            System.out.println("|Press 2. to add gas to the Gas Stations tank                                  |");
            System.out.println("|Press 3. to see how much Gas that is left in the Gas Stations tank and pumps  |");
            System.out.println("|Press 0. to exit                                                              |");
            System.out.println("*------------------------------------------------------------------------------*");

            if (in.hasNextInt()) {
                menuChoice = in.nextInt();

                if (menuChoice == 1) {
                    usePumps();
                }

                if (menuChoice == 2) {
                    addGas();
                }

                if (menuChoice == 3) {
                    tankFuelCounter();
                }

                if (menuChoice == 0) {
                    System.exit(0);
                }
            } else {
                System.out.println("Invalid input, please try again");
                in.next();
                continue;
            }
        }
    }


    /**
     * The following method usePumps is the method that let you car or whatever from the two different pumps.
     * It uses the fuelPump class to "holde styr på" the different pumps and the tank, so you only can get how much gas that is possible.
     */
    public static void usePumps() {

        int currentGasPump2 = fuelPump2.getFuelCounter();
        int gasUsed = 0; //Is to count how much gas that is tanked
        int price = 10; //The price for the gas

        while (true) {
            System.out.println("Press 1. to use pump 1, or press 2. to use pump 2");

            if (in.hasNextInt()) {

                int pumpChoice = in.nextInt();

                if (pumpChoice == 1) {
                    System.out.println("Pump 1 are ready - how much gas was used?");
                    gasUsed = in.nextInt();

                    if (gasUsed <= fuelPump1.getFuelCounter()) {
                        fuelPump1.setFuel(fuelPump1.getFuelCounter() - gasUsed);
                        fuelPump1.fillUp(gasUsed);
                        System.out.println("Successfully filled up your car with " + gasUsed + " liter of gas with a price of " + fuelPump1.getTurnOver(price) + " DKK");
                        fuelPump1.setFuelUsed(0);
                    } else {
                        System.out.println("Error this pump do not have this much gas, try pump 2");
                    }
                } else if (pumpChoice == 2) {
                    System.out.println("Pump 2 are ready - how much gas was used?");
                    gasUsed = in.nextInt();

                    if (gasUsed <= fuelPump2.getFuelCounter()) {
                        fuelPump2.setFuel(fuelPump2.getFuelCounter() - gasUsed);
                        fuelPump2.fillUp(gasUsed);
                        System.out.println("Successfully filled up your car with " + gasUsed + " liter of gas with a price of " + fuelPump2.getTurnOver(price) + " DKK");
                        fuelPump2.setFuelUsed(0);
                    } else {
                        System.out.println("Error this pump do not have this much gas, try pump 1");
                    }
                }


                System.out.println("Press any key to continue.");
                in.next();
                break;


            } else {
                System.out.println("Invalid input, please try again");
                in.next();
                continue;
            }
        }
    }

    /**
     * The following method tankFuelCounter is the method that checks whats left in the two pumps and the main tank.
     * Again it uses the fuelPump class to check as it is coded there to have a counter of it.
     */
    public static void tankFuelCounter() {

        System.out.println("There is: " + fuelPump1.getFuelCounter() + " liter of Gas back in Pump 1");

        System.out.println("There is: " + fuelPump2.getFuelCounter() + " liter of Gas back in Pump 2");


        System.out.println("There is: " + fuelPump1.getFuelTank() + " liter of gas back in the main tank");

        System.out.println("Press any key to continue.");
        in.next();
    }

    /**
     * The following method addGas adds gas to the tank station, it is done by the addGas function in the fuelPump class.
     */
    public static void addGas() {

        int howMuchGasAdded;

        while (true) {

            System.out.println("Please enter how much gas you're about to add to the Gas Stations tank");

            if (in.hasNextInt()) {
                howMuchGasAdded = in.nextInt();

                fuelPump1.addGas(howMuchGasAdded);

            } else {
                System.out.println("Invalid input, please try again");
                in.next();
                continue;
            }
            System.out.println("Press any key to continue.");
            break;
        }
    }
}




