package tests.com.teamtreehouse.vending;

import com.teamtreehouse.vending.AlphaNumericChooser;
import com.teamtreehouse.vending.InvalidLocationException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AlphaNumericChooserTest {

    private AlphaNumericChooser chooser;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() throws Exception{
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {
        AlphaNumericChooser.Location loc = chooser.locationFromInput("B4");

        assertEquals("row not right",1  , loc.getRow());
        System.out.println("not executing if above test fails");
        assertEquals("column not right",3, loc.getColumn());
    }

    @Test(expected = InvalidLocationException.class)
    public void invalidInputThrowsException() throws Exception{
        chooser.locationFromInput("wrong");
    }

    @Test(expected = InvalidLocationException.class)
    public void largerThanMaxThrowsException() throws Exception {
        chooser.locationFromInput("B52");
    }

    @Test
    public void construcingLargerThanMaxIsNotAllowed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Maximum rows supported is 26");

        new AlphaNumericChooser(30, 10);
    }
}