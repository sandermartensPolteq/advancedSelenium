package tests;

import common.driverProvider.DriverProvider;
import common.pages.BasePage;
import org.testng.annotations.AfterMethod;

public class TestTemplate extends BasePage {

    @AfterMethod()
    public void after(){
        DriverProvider.close();
    }
}
