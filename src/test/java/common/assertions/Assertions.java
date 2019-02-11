package common.assertions;

import com.aventstack.extentreports.Status;
import common.logging.ExtentTestManager;
import org.testng.Assert;

public class Assertions {

    public static void assertEquals(String element1, String element2){
        //ExtentTestManager.getTest().log(Status.PASS, text);
        Assert.assertEquals(element1, element2);
    }
}
