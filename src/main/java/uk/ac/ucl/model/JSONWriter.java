package uk.ac.ucl.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JSONWriter {
    private final ListFrame listFrame;
    private final StringBuilder stringBuilder;

    public JSONWriter(ListFrame listFrame) {
        this.listFrame = listFrame;
        this.stringBuilder = new StringBuilder();
    }

    public void writeToFile(String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            if (stringBuilder.isEmpty()) {
                return;
            }

            bufferedWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void convertToJSON(){
        this.stringBuilder.append("[");
        for (ItemsList itemsList : this.listFrame.getItemsLists()){
            this.stringBuilder.append("\n\t{\n\t\t\"listName\": \"" + itemsList.getName().strip() + "\",");
            int itemNumber = 0;
            for (Item item : itemsList.getItems()){
                formatItem(item, itemNumber);
                itemNumber++;
            }
            removeComma();
            this.stringBuilder.append("\n\t},");
        }
        removeComma();
        this.stringBuilder.append("\n]");
    }

    private void formatItem(Item item, int itemNumber) {
        this.stringBuilder.append("\n\t\t\"item" + itemNumber + "\": [\n\t\t\t{\n\t\t\t\t\"linkedList\": \"");
        this.stringBuilder.append(item.getListLink() + "\",\n\t\t\t\t\"url\": \"" + item.getUrl() + "\",\n\t\t\t\t\"contactName\": \"");
        this.stringBuilder.append(item.getContactName() + "\",\n\t\t\t\t\"contactNumber\": \"" + item.getContactNumber());
        this.stringBuilder.append("\",\n\t\t\t\t\"placeName\": \"" + item.getAddressPlaceName() + "\",\n\t\t\t\t\"placeAddress\": \"");
        this.stringBuilder.append(item.getAddressPlaceAddress() + "\",\n\t\t\t\t\"imageAddress\": \"" + item.getImageAddress());
        this.stringBuilder.append("\",\n\t\t\t\t\"text\": \"" + item.getText() + "\"\n\t\t\t}\n\t\t],");
    }

    private void removeComma(){
        int removeIndex = stringBuilder.lastIndexOf(",");
        if (removeIndex != -1){
            this.stringBuilder.deleteCharAt(removeIndex);
        }
    }
}
