package common.flows;

import common.models.User;
import common.pages.AuthenticationPage;
import common.pages.HomePage;

public class LoginFlow {

    public static AuthenticationPage login(User user){
        new HomePage()
                .open()
                .clickSignIn()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickSignIn();
        return new AuthenticationPage();
    }
}
