package main.java.bgu.spl.mics.application.passiveObjects;


import java.util.Arrays;
import java.util.Vector;

import static main.java.bgu.spl.mics.application.passiveObjects.OrderResult.NOT_IN_STOCK;
import static main.java.bgu.spl.mics.application.passiveObjects.OrderResult.SUCCESSFULLY_TAKEN;

/**
 * Passive data-object representing the store bookInventory.
 * It holds a collection of {@link BookInventoryInfo} for all the
 * books in the store.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add ONLY private fields and methods to this class as you see fit.
 */
public class Inventory {

    private BookInventoryInfo[] bookInventory;
    private static Inventory inventory;

    /**
     * MoneyRegister constructor.
     */
    private Inventory() {
    }

    /**
     * Retrieves the single instance of this class.
     */
    public static synchronized Inventory getInstance() {
        if (inventory == null)
            inventory = new Inventory();
        return inventory;
    }

    /**
     * Initializes the store bookInventory. This method adds all the items given to the store
     * bookInventory.
     * <p>
     *
     * @param inventory Data structure containing all data necessary for initialization
     *                  of the bookInventory.
     */
    public void load(BookInventoryInfo[] inventory) {
        bookInventory = inventory.clone();
    }

    /**
     * Attempts to take one book from the store.
     * <p>
     *
     * @param book Name of the book to take from the store
     * @return an {@link Enum} with options NOT_IN_STOCK and SUCCESSFULLY_TAKEN.
     * The first should not change the state of the bookInventory while the
     * second should reduce by one the number of books of the desired type.
     */
    public OrderResult take(String book) {
        for (BookInventoryInfo books : bookInventory)
            if (books.getBookTitle().equals(book)) {
                if (books.getAmountInInventory() > 0) {
                    books.reduceAmount();
                    return SUCCESSFULLY_TAKEN;
                }
            }
        return NOT_IN_STOCK;
    }

    /**
     * Checks if a certain book is available in the bookInventory.
     * <p>
     *
     * @param book Name of the book.
     * @return the price of the book if it is available, -1 otherwise.
     */
    public int checkAvailabiltyAndGetPrice(String book) {
        for (BookInventoryInfo books : bookInventory)
            if (books.getBookTitle().equals(book))
                return books.getPrice();

        return -1;
    }

    /**
     * <p>
     * Prints to a file name @filename a serialized object HashMap<String,Integer> which is a Map of all the books in the bookInventory. The keys of the Map (type {@link String})
     * should be the titles of the books while the values (type {@link Integer}) should be
     * their respective available amount in the bookInventory.
     * This method is called by the main method in order to generate the output.
     */
    public void printInventoryToFile(String filename) {
        //TODO: Implement this
    }
}