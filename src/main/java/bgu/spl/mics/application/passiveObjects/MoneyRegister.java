package main.java.bgu.spl.mics.application.passiveObjects;


import java.util.Vector;

/**
 * Passive object representing the store finance management.
 * It should hold a list of receipts issued by the store.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add ONLY private fields and methods to this class as you see fit.
 */
public class MoneyRegister {

    public static void main(String[] args) {
        MoneyRegister register=MoneyRegister.getInstance();

    }

    private Vector<OrderReceipt> receipts = new Vector();
    private static MoneyRegister moneyRegister = null;

    /**
     * MoneyRegister constructor.
     */
    private MoneyRegister() {
    }

    /**
     * Retrieves the single instance of this class.
     */
    public static MoneyRegister getInstance() {
        if (moneyRegister == null)
            moneyRegister = new MoneyRegister();
        return moneyRegister;
    }

    /**
     * Saves an order receipt in the money register.
     * <p>
     *
     * @param r The receipt to save in the money register.
     */
    public void file(OrderReceipt r) {
        this.receipts.add(r);
      //  moneyRegister.file(r);
    }

    /**
     * Retrieves the current total earnings of the store.
     */
    public int getTotalEarnings() {
        int sum = 0;
        for (OrderReceipt receipt : receipts) sum += receipt.getPrice();
        return sum;
    }

    /**
     * Charges the credit card of the customer a certain amount of money.
     * <p>
     *
     * @param amount amount to charge
     */
    public void chargeCreditCard(Customer c, int amount) {
        c.reduceMoney(amount);
    }

    /**
     * Returns all the order receipts in the system.
     */
    public Vector<OrderReceipt> getOrderReceipts() {
        return receipts;
    }

    /**
     * Prints to a file named @filename a serialized object List<OrderReceipt> which holds all the order receipts
     * currently in the MoneyRegister
     * This method is called by the main method in order to generate the output..
     */
    public void printOrderReceipts(String filename) {
        //TODO: Implement this
    }
}
