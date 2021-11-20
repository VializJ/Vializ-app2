/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */



package baseline;

public class Item {
    private String itemName;
    private String itemPrice;
    private String itemSerialNumber;

    public Item (String itemName, String itemPrice, String itemSerialNumber) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemSerialNumber = itemSerialNumber;
    }

    public void setItemName(String newItemName) {
        //manually set the new name
    }
    public void setItemPrice(String newItemPrice) {
        //manually set the new price
    }
    public void setItemSerialNumber(String newItemSerialNumber) {
        //manually set the new serial number
    }
    public String getItemName() {
        return this.itemName;
    }
    public String getItemPrice() {
        return this.itemPrice;
    }
    public String getItemSerialNumber() {
        return this.itemSerialNumber;
    }

}
