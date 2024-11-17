public class Cafe extends Building{
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructor; initializes all needed variables 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     * @param name
     * @param address
     * @param nFloors
     */
    public Cafe(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = nCoffeeOunces; 
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups; 
        this.name = name;
        this.address = address;
        this.nFloors = nFloors; 
    }

    /**
     * Sells a coffee and decreases the amount of supplies by the amount in the parameters
     * @param size
     * @param nSugar
     * @param nCream
     */
    public void sellCoffee(int size, int nSugar, int nCream) { //preventing double variables and adding all of the sugar packets and creams in stock to the coffee 
        if (nCoffeeOunces > 0 && nSugarPackets > 0 && nCreams > 0) {
            System.out.println("You have successfully sold a coffee!");
            nCoffeeOunces -= size; 
            nSugarPackets -= nSugar; 
            nCreams -= nCream; 
            nCups --;
            System.out.println("Remaining supplies:");
            System.out.println("Coffee Ounces: " + nCoffeeOunces + "\nSugar Packets: " + nSugarPackets + "\nCreams: " + nCreams + "\nCups: " + nCups);
        }
        else {
            throw new RuntimeException("This cafe is out of supplies, please restock.");
        }
    }

    /**
     * Restocks the coffee to its original capacity, or to what the parameters specify it to be 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      nCoffeeOunces += nCoffeeOunces; 
      nSugarPackets += nSugarPackets;
      nCreams += nCreams;
      nCups += nCups; 
      System.out.println("Supplies:");
      System.out.println("Coffee Ounces: " + nCoffeeOunces + "\nSugar Packets: " + nSugarPackets + "\nCreams: " + nCreams + "\nCups: " + nCups);
    }

   /**
    * Accessor to the building parameters
    */
    public void getBuilding() { //makes sure that the attributes of the building class are used 
        System.out.println("Building name: " + name + "\nBuilding Address: " + address + "\nNumber of Floors: " +nFloors);
    }

    public static void main(String[] args) {
        Cafe newCafe = new Cafe(100, 200, 200, 50, "Compass Cafe", "Address", 1);
        newCafe.sellCoffee(12, 2, 3);
        newCafe.restock(100, 200, 200, 50); 
    }
}
