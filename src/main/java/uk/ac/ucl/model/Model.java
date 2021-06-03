package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class Model implements ModelInterface{
  private final String FILENAME = "data/listdata.json";
  private JSONWriter jsonWriter;
  private JSONReader jsonReader;
  private ListFrame frame = new ListFrame();

  public void readFile() {
    jsonReader = new JSONReader();
    jsonReader.readFromFile(FILENAME);
    this.frame = jsonReader.getListFrame();
  }

  public void saveToFile(){
    jsonWriter = new JSONWriter(this.frame);
    jsonWriter.convertToJSON();
    jsonWriter.writeToFile(FILENAME);
  }

  public List<String> getListNames() {
    return frame.getListNames();
  }

  public boolean addNewList(String listName) {
    return frame.addList(listName);
  }

  public boolean removeList(String listName) {
    return frame.removeList(listName);
  }

  public boolean renameList(String oldName, String newName) {
    return frame.renameList(oldName, newName);
  }

  public void insertNewItemToList(String listName, String itemLink, String itemIndex){
    frame.insertItemToList(listName, itemLink, itemIndex);
  }

  public void removeItemFromList(String listName, String itemNumber){
    frame.getItemList(listName).removeItem(itemNumber);
  }

  public List<String> searchForList(String keyword) {
    return this.frame.searchForList(keyword);
  }

  public List<String> searchForItem(String keyword) {
    return this.frame.searchForItem(keyword);
  }

  public ArrayList<String> viewItemAttributes(String listName, String itemIndex) {
    ItemViewer itemViewer = new ItemViewer(this.frame, listName, itemIndex);
    return itemViewer.viewAllAttributes();
  }

  public void storeItemAttributes(String listName, String itemIndex, String itemText, String itemUrl, String itemContactName, String itemContactNumber, String itemAddressPlaceName, String itemAddressPlaceAddress, String itemImageAddress) {
    ItemSaver itemSaver = new ItemSaver(this.frame, listName, itemIndex);
    itemSaver.saveAllAttributes(itemText, itemUrl, itemContactName, itemContactNumber, itemAddressPlaceName, itemAddressPlaceAddress, itemImageAddress);
  }
}
