package tests.com.teamtreehouse.vending;

import com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationException;
import com.teamtreehouse.vending.Bin;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BinTest {
    private Bin bin;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    @Test
    public void restock() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot restock chips with soda");

        bin.restock("chips", 5, 1, 2);
        bin.restock("soda", 5, 2, 3);

    }

    @Test
    public void whenEmptyPriceIsZero() throws Exception {
        assertEquals("no exception when bin is empty", 0, bin.getItemPrice());
    }

    @Test
    public void whenEmptyGetItemNameIsNull() throws Exception {
        assertNull(bin.getItemName());
    }

    @Test
    public void overStockNotAllowed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("There are only 10 spots left");
        bin.restock("beer", 11, 1, 2);
    }
}