import java.util.ArrayList;

public class House extends Building{
  private ArrayList<String> residents = new ArrayList<String>();
  private boolean hasDiningRoom;
  private String name; 
  private String address; 
  private int nFloors; 

  /**
   * Constructor 
   * @param hasDiningRoom
   * @param name
   * @param address
   * @param nFloors
   */
  public House(boolean hasDiningRoom, String name, String address, int nFloors) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    this.hasDiningRoom = hasDiningRoom;
    residents.add("Sophia Smith"); //the ArrayList is null otherwise and returns an error 
  }

  /**
   * Returns whether the house has a dining room 
   * @return boolean; has a dining room or not
   */
  public boolean hasADiningRoom(){
    if (this.hasDiningRoom) {
      System.out.println("This house has a dining hall!");
      return true; 
    }
    else {
      System.out.println("This house does not have a dining hall.");
      return false; 
    }
  }

  /**
   * Returns the number of residents in the house 
   * @return int; number of residents 
   */
  public int nResidents() {
    if (residents.size() > 0) {
      System.out.println("This house has " + residents.size()+ " resident(s) living in it.");
      return residents.size(); 
    }
    else {
      System.out.println("There are no residents in this house.");
      return residents.size(); 
    }
  }

  /**
   * Adds a resident to the house 
   * @param name
   */
  public void moveIn(String name) {
    if (!residents.contains(name)) {
      residents.add(name);
      System.out.println( name + "has sucessfully moved in!");
    }
    else {
      System.out.println(name + " already lives here, please try again.");
    }
  }

  /**
   * Removes a resident from the house 
   * @param name
   * @return the name of the person that moved out
   */
  public String moveOut(String name) {
    if (residents.contains(name)) {
      residents.remove(name); 
      System.out.println(name + " has successfully moved out!");
      return name; 
    }
    else {
      System.out.println(name + " does not live here, please try another house.");
      return name; 
    }
  }

  /**
   * Checks whether a person lives in the house or not 
   * @param person
   * @return boolean; whether the person lives in the house or not 
   */
  public boolean isResident(String person) {
    if (residents.contains(person)) {
      System.out.println(person + " does live here!");
      return true; 
    }
    else {
      System.out.println(person + " does not live here!");
      return false; 
    }
  }

  /**
    * Accessor to the building parameters
    */
    public void getBuilding() { //makes sure that the attributes of the building class are used 
      System.out.println("Building name: " + name + "\nBuilding Address: " + address + "\nNumber of Floors: " +nFloors);
  }

  public static void main(String[] args) {
    House myHouse = new House(false,"Haven", "110 Elm Street", 3);
    myHouse.moveIn("Taylor Swift");
  }
}
