package uk.ac.ucl.model;

import java.io.*;

public class JSONReader {
    private ListFrame listFrame;
    private int itemCount = -1, listCount = -1;
    private String key, value, contactNameBuffer, placeNameBuffer;

    public JSONReader() {
        this.listFrame = new ListFrame();
    }

    public ListFrame getListFrame(){
        return this.listFrame;
    }

    public void readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();

            while (line != null) {
                if (line.contains(":")) {
                    fillList(line);
                }
                line = bufferedReader.readLine();
            }
        } catch(IOException e){
            return;
        }
    }

    private void fillList(String line) {
        initialiseKeyValue(line);
        if (initialiseItemList()){
            return;
        }
        initialiseParameters();
    }

    private boolean initialiseItemList() {
        if (adjustIndexes()){
            return true;
        }

        if (itemCount != 0 && key.compareTo("linkedList") == 0) {
            if (value.compareTo("$$DNE$$") == 0){
                this.listFrame.getItemsLists().get(listCount).addItem(new Item("false"));
            }
            else {
                this.listFrame.getItemsLists().get(listCount).addItem(new Item(value));
            }
        }
        return false;
    }

    private boolean adjustIndexes() {
        if (key.compareTo("listName") == 0) {
            this.listFrame.addList(value);
            listCount++;
            itemCount = -1;
            return true;
        }

        if (key.contains("item")) {
            itemCount++;
            return true;
        }
        return false;
    }

    private void initialiseKeyValue(String line) {
        String[] cleanString = line.replaceAll("[\",]", "").strip().split(":");

        try {
            key = cleanString[0].strip();
            value = cleanString[1].strip();
        } catch(IndexOutOfBoundsException iobe){
            return;
        }
    }

    private void initialiseParameters(){
        if (key.compareTo("text") == 0) {
            this.listFrame.getItemsLists().get(listCount).getItems().get(itemCount).setText(value);
        } else if (key.compareTo("url") == 0) {
            this.listFrame.getItemsLists().get(listCount).getItems().get(itemCount).setUrl(value);
        } else if (key.compareTo("contactName") == 0) {
            contactNameBuffer = value;
        } else if (key.compareTo("contactNumber") == 0) {
            this.listFrame.getItemsLists().get(listCount).getItems().get(itemCount).setContact(contactNameBuffer, value);
        } else if (key.compareTo("placeName") == 0) {
            placeNameBuffer = value;
        } else if (key.compareTo("placeAddress") == 0) {
            this.listFrame.getItemsLists().get(listCount).getItems().get(itemCount).setContact(placeNameBuffer, value);
        } else if (key.compareTo("imageAddress") == 0) {
            this.listFrame.getItemsLists().get(listCount).getItems().get(itemCount).setImageAddress(value);
        }
    }
}
