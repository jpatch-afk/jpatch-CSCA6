import java.util.Hashtable;

public class Library extends Building {
  private Hashtable<String, Boolean> collection = new Hashtable<String, Boolean>();
  private String name; 
  private String address; 
  private int nFloors; 
    /**
     * Constructor
     * @param name
     * @param address
     * @param nFloors
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      System.out.println("You have built a library: 📖");
      collection.put("War and Peace", true); //initializing a book in the collection, returns null otherwise
    }

    /**
     * Adds a title to the collection
     * @param title
     */
    public void addTitle(String title) {
      if (!collection.containsKey(title)) {
        collection.put(title, true); 
        System.out.println(title + " placed successfully!");
      }
      else {
        System.out.println(title + " is already in the collection!");
      }
    }

    /**
     * Removes a title from the collection
     * @param title
     * @return
     */
    public String removeTitle(String title) {
      if (collection.containsKey(title)){
        collection.remove(title); 
        System.out.println(title + " successfully removed!");
        return title; 
      }
      else {
        System.out.println(title + " does not exist in the collection, please try again.");
        return title;
      }
    }

    /**
     * Checks out a book from the collection
     * @param title
     */
    public void checkOut(String title) {
      if (collection.containsKey(title)) {
        collection.put(title, false); 
        System.out.println(title + " successfully checked out!");
      }
      else {
        System.out.println(title + " doesn't exist in the collection, please try again.");
      }
    }

    /**
     * Returns a books to the collection; checks whether the book has been checked out and belongs to the collection
     * @param title
     */
    public void returnBook(String title) {
      if (collection.containsKey(title) && collection.containsValue(false)) {
        collection.put(title, true); 
        System.out.println(title + " returned successfully!");
      }
      else if (collection.containsKey(title) && collection.containsValue(true)) {
        System.out.println(title + " hasn't been checked out, please try again.");
      }
      else {
        System.out.println(title + " does not exist in the collection, please try again.");
      }
  }

  /**
   * Checks whether a book is included within the collection
   * @param title
   * @return true or false depending on whether the title lives in the collection or not
   */
  public boolean containsTitle(String title) {
    if (collection.containsKey(title)) {
      System.out.println(title +" is in the collection!");
      return true; 
    }
    else {
      System.out.println(title + " does not exist in the collection.");
      return false; 
    }
  }

  /**
   * Prints the title and checked-out status of the titles in the collection 
   */
  public void printCollection() {
    for(String i: collection.keySet()) {
      System.out.println(i);
      if (collection.get(i).equals(true)) {
        System.out.println("Checked in.");
      }
      else {
        System.out.println("Checked out.");
      }
    }
  }
  public static void main(String[] args) {
    Library newLibrary = new Library("Neilson Library", "Address", 4);
    newLibrary.addTitle("Pride & Prejudice");
    newLibrary.printCollection();
  }
}