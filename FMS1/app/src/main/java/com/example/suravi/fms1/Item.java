package com.example.suravi.fms1;

/**
 * Created by suravi on 9/11/2018.
 */
public class Item {
    private String Code ;
    private String Name;
    private int Price;
    private int Amount;
    private String Unit;
    private int Discount;
    private String Type;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
