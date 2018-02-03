import java.util.Scanner;

public class AdvancedAr {

  public static void main(String[] args) {
    char quit = 'y';
    Scanner userIn = new Scanner(System.in);  //scanner variables for user input
    Scanner scanItem = new Scanner(System.in);
    Scanner scanChange = new Scanner(System.in);

    //a 2 dimensional array with 8 items and 8 quantities
    /*NOTE I would have preferred to use an Object[][] array set the quantities to integers
    but after I was unable to figure it out I went with this*/
    String [][] hotDogSupplies = {{"Relish", "Mustard", "Pickles",
        "Onions", "Sport Peppers", "Celery Salt", "Buns", "Hot Dogs"},
        {"10", "10", "15", "15", "10", "10", "5", "5"}};

    //allow the user to continue doing inventory until they are finished
    while (quit != 'n') {

      //method to more efficiently show the array in a menu format
      printAr(hotDogSupplies);

      //give the user the option of how many items to add or remove
      System.out.println("\nWhich item would you like to change the quantity of?");
      int item = scanItem.nextInt();

      switch (item) {
        case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case9:

        System.out.println("\nItem: " + hotDogSupplies[0][item-1] + " \nQuantity: " +
            hotDogSupplies[1][item-1]);

          //temp variable for swapping info
          String tempQuantity = hotDogSupplies[1][item-1];

          //temp variable to parse the string and convert to integer
          int tempIntQuantity = Integer.parseInt(tempQuantity);

          System.out.println("\nEnter the amount you added or removed from inventory.");
          int change = scanChange.nextInt();
          int newQuantity = tempIntQuantity + change;

          //to catch the error of a negative quantity
          if(newQuantity < 0) {
            System.out.println("\nInventory quantity cannot be negative.");
            System.out.println("\nEnter the amount you added or removed from inventory.");
            change = scanChange.nextInt();
            newQuantity = tempIntQuantity + change;
          }

          //bring the changes back to the array
          String qtyString = Integer.toString(newQuantity);

          //bring the changes back to the array
          hotDogSupplies[1][item-1] = qtyString;

      }

      //reprint the array with updated quantities
      printAr(hotDogSupplies);

      System.out.println("\nWould you like to continue doing inventory? Yy/Nn");
      String input = userIn.next().toLowerCase();
      quit = input.charAt(0);
    }
  }
  /*
Method: printAr

Use: Prints the hotDogSupplies array as menu options on screen

Arguments: none

Returns: none
*/
  public static void printAr(String[][] hotDogSupplies) {
    System.out.println("Hotdog Stand Inventory\n");
    for (int i = 0; i < hotDogSupplies[0].length; i++) {
      System.out.print((i + 1) + ")");
      System.out.print("\t");
      for (int j = 0; j < hotDogSupplies.length; j++) {

        System.out.printf("%-15s ", hotDogSupplies[j][i] + " ");
      }
      System.out.println();
    }
  }
}
