package common.pages;

import common.assertions.Assertions;
import org.openqa.selenium.By;

public class Toptoolbar extends BasePage {

    private static final By lblName = By.xpath("//nav/div[@class='header_user_info']/a[@class='account']");

    public String getUsernameOfloggedInUser(){
        return getText(lblName);
    }

    public void verifyUsername(String username){
        addLogging("Verify that username of logged in user is correct ("+username+")");
        Assertions.assertEquals(getUsernameOfloggedInUser(), username);
    }
}
