package common.flows;


import common.models.User;
import common.pages.AuthenticationPage;
import common.pages.HomePage;

public class LoginFlow {

    public static void login(String baseUrl, User user){
        AuthenticationPage authenticationPage = new HomePage()
                .open(baseUrl)
                .clickSignIn();
        authenticationPage
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickSignIn();
    }
}
