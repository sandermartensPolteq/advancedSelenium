package common.pages;


import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private final By btnSignIn = By.className("login");

    public HomePage open(String url){
        addLogging("Navigate to homepage");
        getUrl(url);
        return new HomePage();
    }

    public AuthenticationPage clickSignIn(){
        addLogging("Click signin at the top toolbar");
        click(btnSignIn);
        return new AuthenticationPage();
    }
}
