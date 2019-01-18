package common.driverProvider;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class DriverProvider {

    private static final List<WebDriver> drivers = new ArrayList<>();
    private static int ACTIVE_BROWSER_INDEX = 0;

    private DriverProvider() {}

    private static void newInstance() {
        WebDriver newDriver = chromeDriver();
        drivers.add(newDriver);
    }

    private static WebDriver chromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--enable-logging --v");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private static WebDriver getBrowserDriver(int index) {
        for (; drivers.size() <= index; ) {
            newInstance();
        }

        return drivers.get(index);
    }

    public static WebDriver getActiveDriver() {
        return getBrowserDriver(ACTIVE_BROWSER_INDEX);
    }

    public static WebDriver switchActiveWindow(int index) {
        ACTIVE_BROWSER_INDEX = index;
        return getActiveDriver();
    }

    public static void close() {
        for (WebDriver webDriver : drivers) {
            if (webDriver != null) {
                try {
                    String path = System.getenv("PATH");
                    System.out.println(path);
                    webDriver.quit();
                } catch (UnsatisfiedLinkError | NoClassDefFoundError | NullPointerException e) {

                }
            }
        }
        drivers.clear();
        ACTIVE_BROWSER_INDEX = 0;
    }
}
