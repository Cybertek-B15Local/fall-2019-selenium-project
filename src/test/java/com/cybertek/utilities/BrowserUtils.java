package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /*
    takes a list of web elements
    returns a list of strings
     */
    public static List<String> getElementsText(List<WebElement> listEl){
        // given a list web elements, extract the text of the elements into new list of strings
        List<String> listSt = new ArrayList<>();
        for (WebElement element : listEl) {
            listSt.add(element.getText());
        }
        return listSt;
    }
}
