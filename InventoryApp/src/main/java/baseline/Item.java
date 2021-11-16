/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */



package baseline;

public class Item {
    String itemName;
    String serialNumber;
    String itemPrice;

    public Item (String itemName, String itemPrice, String serialNumber) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.serialNumber = serialNumber;
    }

    public void setItemName(String newItemName) {
        //manually set the new name
    }
    public void setItemPrice(String newItemPrice) {
        //manually set the new price
    }
    public void setSerialNumber(String newSerialNumber) {
        //manually set the new serial number
    }
    public String getItemName() {
        return this.itemName;
    }
    public String getItemPrice() {
        return this.itemPrice;
    }
    public String getSerialNumber() {
        return this.serialNumber;
    }

}
