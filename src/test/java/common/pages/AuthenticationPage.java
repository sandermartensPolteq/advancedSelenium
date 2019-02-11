package common.pages;

import org.openqa.selenium.By;

public class AuthenticationPage extends BasePage {

    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("passwd");
    private final By btnSignIn = By.id("SubmitLogin");

    public AuthenticationPage fillEmail(String email){
        addLogging("Fill email address");
        fill(txtEmail, email);
        return this;
    }

    public AuthenticationPage fillPassword(String password){
        addLogging("Fill password");
        fill(txtPassword, password);
        return this;
    }

    public AuthenticationPage clickSignIn(){
        addLogging("Click 'Sign in'");
        click(btnSignIn);
        return this;
    }
}
