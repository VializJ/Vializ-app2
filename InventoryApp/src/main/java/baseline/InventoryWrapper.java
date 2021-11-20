package baseline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

    public class InventoryWrapper {
        private static ObservableList<Item> itemList = FXCollections.observableArrayList();
        private static Item currentSelectedItem;


        public static ObservableList<Item> getObservableList() {
            return itemList;
        }



        public static Item addItemToList(String name, String value, String serialNumber) {

                Item cell = new Item(name, value, serialNumber);
                itemList.add(cell);
                return cell;
            //create new text field
            //prompt user to enter the text in field
        }

}
