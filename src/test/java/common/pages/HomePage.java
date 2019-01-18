package common.pages;


import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private final By btnSignIn = By.className("login");

    public HomePage open(){
        getUrl("https://techblog.polteq.com/testshop/index.php");
        return this;
    }

    public AuthenticationPage clickSignIn(){
        click(btnSignIn);
        return new AuthenticationPage();
    }
}
