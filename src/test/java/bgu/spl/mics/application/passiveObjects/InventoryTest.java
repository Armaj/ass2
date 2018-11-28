package main.java.bgu.spl.mics.application.passiveObjects;

import org.junit.Test;

import static main.java.bgu.spl.mics.application.passiveObjects.OrderResult.NOT_IN_STOCK;
import static main.java.bgu.spl.mics.application.passiveObjects.OrderResult.SUCCESSFULLY_TAKEN;
import static org.junit.Assert.*;

public class InventoryTest {
    Inventory inv = Inventory.getInstance();
    BookInventoryInfo lotr=new BookInventoryInfo("lotr",1,10);

    @Test
    public void getInstance() {
    }

    @Test
    public void load() {
        BookInventoryInfo[] temp={lotr};
        inv.load(temp);
    }

    @Test
    public void take() {
        assertEquals(SUCCESSFULLY_TAKEN,inv.take("lotr"));
        assertEquals(NOT_IN_STOCK,inv.take("lotr"));
    }

    @Test
    public void checkAvailabiltyAndGetPrice() {
        assertEquals(10,inv.checkAvailabiltyAndGetPrice("lotr"));
        assertEquals(-1,inv.checkAvailabiltyAndGetPrice("123"));
    }

    @Test
    public void printInventoryToFile() {
    }
}