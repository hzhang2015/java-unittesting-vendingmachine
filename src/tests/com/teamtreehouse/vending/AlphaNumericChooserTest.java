package tests.com.teamtreehouse.vending;

import com.teamtreehouse.vending.AlphaNumericChooser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphaNumericChooserTest {

    private AlphaNumericChooser chooser;

    @Before
    public void setup() throws Exception{
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {
        AlphaNumericChooser.Location loc = chooser.locationFromInput("B4");

        assertEquals("row not right",2, loc.getRow());
        System.out.println("not executing if above test fails");
        assertEquals("column not right",3, loc.getColumn());
    }

}