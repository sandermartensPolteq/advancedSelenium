package common.logging;

import com.aventstack.extentreports.Status;
import common.screenUtils.Shooter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
import java.util.Date;

public class TestListener implements ITestListener {


    public void onStart(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        Date date = new Date();
        String timeStamp = String.valueOf(date.getTime());
        Shooter.takeScreenshot(timeStamp);

        ExtentTestManager.getTest().getModel().getLogContext().getLast().setStatus(Status.FAIL);
        String description = ExtentTestManager.getTest().getModel().getLogContext().getLast().getDetails();
        ExtentTestManager.getTest().getModel().getLogContext().getLast().setDetails(description + "<br />" + String.valueOf(result.getThrowable()));
        try {
            ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir") + "/screenshots/" + timeStamp+".jpg" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}