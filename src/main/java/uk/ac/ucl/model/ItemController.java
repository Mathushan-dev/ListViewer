package uk.ac.ucl.model;

public abstract class ItemController {
    private ListFrame frame;
    private String listName;
    private int itemNumber;

    public ItemController(ListFrame frame, String listName, String itemNumber){
        this.frame = frame;
        this.listName = listName;
        this.itemNumber = Integer.parseInt(itemNumber);
    }

    protected Item getItem(){
        return frame.getItemFromItemsList(listName, itemNumber);
    }
}
