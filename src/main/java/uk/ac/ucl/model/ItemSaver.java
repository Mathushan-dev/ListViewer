package uk.ac.ucl.model;

public class ItemSaver extends ItemController {
    public ItemSaver(ListFrame frame, String listName, String itemNumber){
        super(frame, listName, itemNumber);
    }

    private void storeItemText(String text) {
        getItem().setText(text);
    }

    private void storeItemUrl(String url) {
        getItem().setUrl(url);
    }

    private void storeItemContact(String contactName, String contactNumber) {
        getItem().setContact(contactName.strip(), contactNumber.strip());
    }

    private void storeItemAddress(String placeName, String placeAddress) {
        getItem().setAddress(placeName.strip(), placeAddress.strip());
    }

    private void storeItemImageAddress(String imageAddress) {
        getItem().setImageAddress(imageAddress);
    }

    public void saveAllAttributes(String itemText, String itemUrl, String itemContactName, String itemContactNumber, String itemAddressPlaceName, String itemAddressPlaceAddress, String itemImageAddress){
        if (getItem() == null){
            return;
        }
        storeItemText(itemText);
        storeItemUrl(itemUrl);
        storeItemContact(itemContactName, itemContactNumber);
        storeItemAddress(itemAddressPlaceName, itemAddressPlaceAddress);
        storeItemImageAddress(itemImageAddress);
    }
}
