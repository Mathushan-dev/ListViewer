package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class ListFrame {
    private ArrayList<ItemsList> itemsLists;

    public ListFrame(){
        this.itemsLists = new ArrayList<>();
    }

    public ArrayList<ItemsList> getItemsLists(){
        return this.itemsLists;
    }

    public Item getItemFromItemsList(String listName, int itemIndex){
        for (ItemsList itemsList : this.itemsLists){
            if (itemsList.getName().compareToIgnoreCase(listName.strip()) == 0){
                if (itemIndex < 0 || itemIndex >=itemsList.getItems().size()){
                    return null;
                }
                return itemsList.getItems().get(itemIndex);
            }
        }
        return null;
    }

    public ItemsList getItemList(String listName){
        for (ItemsList itemsList : this.itemsLists){
            if (itemsList.getName().compareToIgnoreCase(listName) == 0){
                return itemsList;
            }
        }
        return null;
    }

    public ArrayList<String> getListNames(){
        ArrayList<String> names = new ArrayList<>();
        for (ItemsList itemsList : this.itemsLists){
            names.add(itemsList.getName());
        }
        return names;
    }

    public boolean addList(String listName){
        try {
            this.itemsLists.add(new ItemsList(listName));
            return true;
        } catch (NullPointerException npe){
            return false;
        }
    }

    public void insertItemToList(String listName, String itemLink, String itemIndex){
        if (this.getItemFromItemsList(itemLink, Integer.parseInt("0")) == null && itemLink.strip().compareToIgnoreCase("false") != 0) {
            this.addList(itemLink);
        }
        this.getItemList(listName).insertItem(new Item(itemLink), itemIndex);
    }

    public boolean removeList(String listName){
        removeItemsLinked(listName);

        for (ItemsList itemsList : this.itemsLists){
            if (itemsList.getName().strip().compareToIgnoreCase(listName) == 0){
                this.itemsLists.remove(itemsList);
                return true;
            }
        }
        return false;
    }

    private void removeItemsLinked(String listName){
        for (ItemsList itemsList : this.getItemsLists()){
            ArrayList<Integer> indexesToRemove = new ArrayList<>();
            int i = -1;

            for (Item item : itemsList.getItems()){
                if (item.getListLink().compareToIgnoreCase(listName) == 0){
                    indexesToRemove.add(i);
                }
                i++;
            }

            for (Integer indexToRemove : indexesToRemove){
                itemsList.removeItem(String.valueOf(indexToRemove));
            }
        }
    }

    public boolean renameList(String oldName, String newName){
        boolean changeList = renameMatchingLists(oldName, newName);
        boolean changeLink = renameMatchingLinks(oldName, newName);
        return changeList || changeLink;
    }

    private boolean renameMatchingLists(String oldName, String newName){
        boolean change = false;
        for (ItemsList itemsList : this.itemsLists){
            if (itemsList.getName().strip().compareToIgnoreCase(oldName) == 0){
                itemsList.setName(newName);
                change = true;
            }
        }
        return change;
    }

    private boolean renameMatchingLinks(String oldName, String newName){
        boolean change = false;
        for (ItemsList itemsList : this.itemsLists){
            for (Item item : itemsList.getItems()){
                if (item.getListLink().strip().compareToIgnoreCase(oldName.strip()) == 0){
                    item.setListLink(newName);
                    change = true;
                }
            }
        }
        return change;
    }

    public List<String> searchForList(String keyword) {
        ArrayList<String> matchingList = new ArrayList<>();
        for (String listName : this.getListNames()){
            if (listName.toLowerCase().contains(keyword.toLowerCase())){
                matchingList.add(listName);
                matchingList.add("0");
            }
        }
        return matchingList;
    }

    public List<String> searchForItem(String keyword) {
        ArrayList<String> matchingList = new ArrayList<>();
        for (ItemsList itemsList : this.getItemsLists()){
            int i = 0;
            for (Item item : itemsList.getItems()){
                if (item.isKeywordInItem(keyword)){
                    matchingList.add(itemsList.getName());
                    matchingList.add(String.valueOf(i));
                }
                i++;
            }
        }
        return matchingList;
    }
}
