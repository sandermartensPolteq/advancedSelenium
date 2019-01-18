package common.pages;

import org.openqa.selenium.By;
import sun.management.BaseOperatingSystemImpl;

public class AuthenticationPage extends BasePage {

    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("passwd");
    private final By btnSignIn = By.id("SubmitLogin");

    public AuthenticationPage fillEmail(String email){
        fill(txtEmail, email);
        return this;
    }

    public AuthenticationPage fillPassword(String password){
        fill(txtPassword, password);
        return this;
    }

    public AuthenticationPage clickSignIn(){
        click(btnSignIn);
        return this;
    }
}
