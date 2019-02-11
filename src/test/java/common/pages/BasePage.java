package common.pages;

import com.aventstack.extentreports.Status;
import common.driverProvider.DriverProvider;
import common.logging.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Parameters;

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

    public void clearAndType(By element, String text){
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    public void click(By element){
        driver.findElement(element).click();
    }

    public String getText(By element){
        return driver.findElement(element).getText();
    }

    public void addLogging(String text){
        ExtentTestManager.getTest().log(Status.PASS, text);
    }

    public <ReturnPage extends BasePage> ReturnPage navigate(Class<ReturnPage>pageClass){
        return PageFactory.initElements(driver,pageClass);
    }


}
