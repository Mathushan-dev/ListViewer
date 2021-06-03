package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The following methods must be implemented
 * when creating a model of another data structure
 * for the web app. The web app is reliant on these methods.
 *
 * @author mathushanmathiyalagan
 * @version 18-05-21
 */
public interface ModelInterface {

    /**
     * This method will update the data structure with
     * values that have been read of from a file.
     */
    void readFile();

    /**
     * This method will update the file with
     * values that have been updated in the data structure.
     */
    void saveToFile();

    /**
     * This method will return the names of all the lists
     * that should be displayed to the user in the view lists
     * page.
     * @return List Names
     */
    List<String> getListNames();

    /**
     * This method will update the data structure with
     * a new list that has the name inputted by the user
     * in the create a new list page.
     * @param listName Name of new list, inputted by user
     * @return True if list created without errors, false
     * otherwise
     */
    boolean addNewList(String listName);

    /**
     * This method will update the data structure by removing
     * the list that has the same name as inputted by the user
     * in the remove a list page.
     * @param listName Name of list to remove, inputted by user
     * @return True if list removed without errors, false
     * otherwise
     */
    boolean removeList(String listName);

    /**
     * This method will update the data structure by renaming
     * the list that has the same oldName as inputted by the user
     * in the rename a list page with the newName inputted by the
     * user.
     * @param oldName Name of list to rename, inputted by user
     * @param oldName Name to rename the list with, inputted by user
     * @return True if list renamed without errors, false
     * otherwise
     */
    boolean renameList(String oldName, String newName);

    /**
     * This method will update the data structure by adding a new
     * item to the list with name inputted by user and linked if
     * specified by the user.
     * @param listName Name of list to add item to, inputted by user
     * @param itemLink Name os list to link an item to, false otherwise
     * @param itemIndex Index position of item in list to insert the new
     *                  item to
     */
    void insertNewItemToList(String listName, String itemLink, String itemIndex);

    /**
     * This method will update the data structure by removing an
     * item in the list with name and item index inputted by user.
     * @param listName Name of list to remove an item from, inputted by user
     * @param itemNumber Index position of item in list to remove
     */
    void removeItemFromList(String listName, String itemNumber);

    /**
     * This method will return all lists with the same name as the
     * keyword inputted by the user in the search page.
     * @param keyword Name to return matching lists for
     * @return  Lists that have the same name as the keyword inputted
     * by the user
     */
    List<String> searchForList(String keyword);

    /**
     * This method will return all lists with items that contain the
     * keyword inputted by the user.
     * @param keyword keyword to search each item in all lists for
     * @return Lists that contain the keyword inputted by the user
     */
    List<String> searchForItem(String keyword);

    /**
     * This method will return all attributes that belong to the item
     * with name and item index as specified by the user.
     * @param listName Name of list to obtain attributes from
     * @param itemIndex Index of list to obtain attributes from
     * @return Attributes in the matched item
     */
    ArrayList<String> viewItemAttributes(String listName, String itemIndex);

    /**
     * This method will store all attributes to the item with name and
     * item index as specified by the user.
     * @param listName Name of list to obtain attributes from
     * @param itemIndex Index of list to obtain attributes from
     * @param itemText The text to save in the item
     * @param itemUrl The url to save in the item
     * @param itemContactName The contact name to save in the item
     * @param itemContactNumber The contact number to save in the item
     * @param itemAddressPlaceName The place name to save in the item
     * @param itemAddressPlaceAddress The place address to save in the item
     * @param itemImageAddress The image address to save in the item
     */
    void storeItemAttributes(String listName, String itemIndex, String itemText,
                             String itemUrl, String itemContactName, String itemContactNumber,
                             String itemAddressPlaceName, String itemAddressPlaceAddress,
                             String itemImageAddress);
}
