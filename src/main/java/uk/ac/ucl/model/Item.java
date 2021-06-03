package uk.ac.ucl.model;

public class Item {
    private String text, url, contactName, contactNumber, placeName, placeAddress, imageAddress, linkedItemsList;

    public Item(String linkedItemsList){
        this.linkedItemsList = linkedItemsList;
    }

    public void setText(String text){
        this.text = text.strip();
    }

    public String getText(){
        if (this.text != null) {
            return this.text;
        }
        return "No text has been stored";
    }

    public void setUrl(String url){
        this.url = url.strip();
    }

    public String getUrl(){
        if (this.url != null) {
            return this.url;
        }
        return "No URL has been stored";
    }

    public void setContact(String contactName, String contactNumber){
        this.contactName = contactName.strip();
        this.contactNumber = contactNumber.strip();
    }

    public String getContactName(){
        if (this.contactName != null && this.contactNumber != null) {
            return this.contactName;
        }
        return "None";
    }

    public String getContactNumber(){
        if (this.contactName != null && this.contactNumber != null) {
            return this.contactNumber;
        }
        return "None";
    }

    public void setAddress(String placeName, String placeAddress){
        this.placeName = placeName.strip();
        this.placeAddress = placeAddress.strip();
    }

    public String getAddressPlaceName(){
        if (this.placeName != null && this.placeAddress != null) {
            return this.placeName;
        }
        return "None";
    }

    public String getAddressPlaceAddress(){
        if (this.placeName != null && this.placeAddress != null) {
            return this.placeAddress;
        }
        return "None";
    }

    public void setImageAddress(String imageAddress){
        this.imageAddress = imageAddress.strip();
    }

    public String getImageAddress(){
        if (this.imageAddress != null) {
            return this.imageAddress;
        }
        return "No image has been stored";
    }

    public void setListLink(String linkedItemsList){
        this.linkedItemsList = linkedItemsList;
    }

    public String getListLink(){
        if (this.linkedItemsList != null) {
            if (this.linkedItemsList.compareToIgnoreCase("false") != 0) {
                return this.linkedItemsList;
            }
        }
        return "$$DNE$$";
    }

    public boolean isKeywordInItem(String keyword){
        return this.getText().toLowerCase().contains(keyword)
                || this.getUrl().toLowerCase().contains(keyword)
                || this.getContactName().toLowerCase().contains(keyword)
                || this.getContactNumber().toLowerCase().contains(keyword)
                || this.getAddressPlaceName().toLowerCase().contains(keyword)
                || this.getAddressPlaceAddress().toLowerCase().contains(keyword)
                || this.getImageAddress().toLowerCase().contains(keyword);
    }
}
