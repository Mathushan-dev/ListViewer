package uk.ac.ucl.model;

import java.util.ArrayList;

public class ItemsList {
    private String name;
    private ArrayList<Item> items;

    public ItemsList(String name){
        this.name = name.strip();
        this.items = new ArrayList<>();
        this.items.add(new Item("false"));
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void insertItem(Item item, String itemIndex){
        int index;
        try {
            index = Integer.parseInt(itemIndex);
        }catch (NumberFormatException nfe){
            this.items.add(item);
            return;
        }
        this.items.add(index, item);
    }

    public void removeItem(String itemIndex){
        int index;
        try {
            index = Integer.parseInt(itemIndex) + 1;
        }catch (NumberFormatException nfe){
            return;
        }
        this.items.remove(index);
    }
}
