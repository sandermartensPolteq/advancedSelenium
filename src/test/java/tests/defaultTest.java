package tests;

import common.fixtures.UserFixture;
import common.flows.LoginFlow;
import common.models.User;
import common.pages.HomePage;
import common.screenUtils.Shooter;
import org.testng.annotations.Test;


public class defaultTest extends TestTemplate{

    private User USER = UserFixture.defaultUser();

    @Test
    public void testWithoutFlow(){
        new HomePage()
                .open()
                .clickSignIn()
                .fillEmail("sander.martens+webshop1@polteq.com")
                .fillPassword("fqdfq!")
                .clickSignIn();
        Shooter.takeScreenshot();
    }

    @Test
    public void testWithFlow(){
        LoginFlow.login(USER);
        Shooter.takeScreenshot();
    }
}
