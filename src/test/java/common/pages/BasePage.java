package common.pages;

import common.driverProvider.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {

    protected WebDriver driver = DriverProvider.getActiveDriver();

    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    public void getUrl(String url){
        driver.get(url);
    }

    public void fill(By element, String text){
        driver.findElement(element).sendKeys(text);
    }

    public void click(By element){
        driver.findElement(element).click();
    }
}
