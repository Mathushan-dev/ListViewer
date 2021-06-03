package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class ItemViewer extends ItemController {
    public ItemViewer(ListFrame frame, String listName, String itemNumber){
        super(frame, listName, itemNumber);
    }

    private String viewItemText() {
        return getItem().getText();
    }

    private String viewItemUrl() {
        return getItem().getUrl();
    }

    private String viewItemContactName() {
        return getItem().getContactName();
    }

    private String viewItemContactNumber() {
        return getItem().getContactNumber();
    }

    private String viewItemAddressPlaceName() {
        return getItem().getAddressPlaceName();
    }

    private String viewItemAddressPlaceAddress() {
        return getItem().getAddressPlaceAddress();
    }

    private String viewItemImageAddress() {
        return getItem().getImageAddress();
    }

    private String viewItemLink() {
        return getItem().getListLink();
    }

    public ArrayList<String> viewAllAttributes() {
        if (getItem() == null){
            return new ArrayList<> (List.of("$$DNE$$", "$$DNE$$", "$$DNE$$", "$$DNE$$", "$$DNE$$", "$$DNE$$", "$$DNE$$", "$$DNE$$"));
        }

        ArrayList<String> attributes = new ArrayList<>();

        attributes.add(viewItemLink());
        attributes.add(viewItemText());
        attributes.add(viewItemUrl());
        attributes.add(viewItemContactName());
        attributes.add(viewItemContactNumber());
        attributes.add(viewItemAddressPlaceName());
        attributes.add(viewItemAddressPlaceAddress());
        attributes.add(viewItemImageAddress());

        return attributes;
    }
}
