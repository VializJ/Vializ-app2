import org.junit.jupiter.api.Test;

public class testInventoryManagementApplication {


    @Test
    void testAddItem() {
        //create temp observable list and fill it
        //check if the lists items are there
    }
    @Test
    void testRemoveItem() {
        //create temp observable list and fill it
        //remove the first item
        //check to see if the item exists
    }
    @Test
    void testEditItem() {
        //create temp observable list and fill it
        //edit the item and check if the new description is filled
    }
    @Test
    void testValidateEditDescription() {
        //create temp observable list and fill it
        //create a sample new description that shouldn't work i.e. empty string
        //try to add it to the observable list
        //check to see if the item we chose to change the description of is actually changed
    }
    @Test
    void testValidateEditValue() {
        //create temp observable list and fill it
        //create a sample new value that shouldn't work i.e. -15
        //try to add it to the observable list
        //check to see if the item we chose to change the value of is actually changed
    }
    @Test
    void testValidateEditSerialNumber() {
        //create temp observable list and fill it
        //create a sample new serial number that shouldn't work i.e. one that's equal to an existing one
        //try to add it to the observable list
        //check to see if the item we chose to change the serial number of is actually changed
    }
}
