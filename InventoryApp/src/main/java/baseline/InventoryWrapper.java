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

        public static String deleteItemFromList(Item itemToDelete) {
            int i = 0;
            String itemToDeleteName = "";
            if (itemList.get(i).equals(itemToDelete)) {
                //delete
                itemToDeleteName = itemList.get(i).getItemName();
                itemList.remove(i);
            }else {
                i++;
            }
            return itemToDeleteName;
        }

        public static void setObservableList(ObservableList<Item> newList) {
            itemList.clear();
            itemList = newList;
        }

        public int selectListItem(String itemName) {
            int i = 0;
            if (itemList.get(i).equals(itemName)) {
                currentSelectedItem = itemList.get(i);
            }
            return i;
            //prompt user to select item using checkbox control
            //return the selected list

        }
    }
