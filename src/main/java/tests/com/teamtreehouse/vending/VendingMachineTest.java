package tests.com.teamtreehouse.vending;

import com.teamtreehouse.vending.Item;
import com.teamtreehouse.vending.Notifier;
import com.teamtreehouse.vending.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    private VendingMachine vm;

    public class NotifierSub implements Notifier{

        @Override
        public void onSale(Item item) {
            return;
        }
    }

    @Before
    public void setUp() throws Exception {
        NotifierSub notifierSub = new NotifierSub();
        vm = new VendingMachine(notifierSub, 10, 10, 20);
        vm.restock("A1", "beer", 10, 5, 10);
    }

    @Test
    public void vendingWhenStockedReturnsItem() throws Exception {
        vm.addMoney(10);

        Item item = vm.vend("A1");

        assertEquals("beer", item.getName());
    }

    @Test
    public void runningSalesTotalIncrementsAfterSuccessVend() throws Exception{
        int runningSalesTotalBeforeVend = vm.getRunningSalesTotal();
        vm.addMoney(10);

        vm.vend("A1");

        int runningSalesTotalAfterVend = vm.getRunningSalesTotal();

        assertEquals(runningSalesTotalBeforeVend+10, runningSalesTotalAfterVend);
    }

}