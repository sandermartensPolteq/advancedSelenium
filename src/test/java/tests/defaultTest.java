package tests;

import common.fixtures.UserFixture;
import common.mockUtils.MockClient;
import common.models.User;
import common.pages.AuthenticationPage;
import common.pages.HomePage;
import common.pages.Toptoolbar;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;


public class defaultTest extends TestTemplate{

    private static User DEFAULT_USER = UserFixture.defaultUser();
    private ClientAndServer mockServer;
    AuthenticationPage authenticationPage;

    @Test
    public void standardTestcase(){
        authenticationPage = new HomePage()
                .open("https://techblog.polteq.com/testshop/index.php")
                .clickSignIn();
        authenticationPage
                .fillEmail(DEFAULT_USER.getEmail())
                .fillPassword(DEFAULT_USER.getPassword())
                .clickSignIn();

        new Toptoolbar().verifyUsername("Firstname lastNameee");
    }

    @Parameters({"baseUrl"})
    @Test
    public void makeUseOfParameters(String baseUrl){
        AuthenticationPage authenticationPage = new HomePage()
                                                    .open(baseUrl)
                                                    .clickSignIn();
        authenticationPage
                .fillEmail(DEFAULT_USER.getEmail())
                .fillPassword(DEFAULT_USER.getPassword())
                .clickSignIn();

        new Toptoolbar().verifyUsername("Firstname lastName");
    }

    @Test
    public void ApiCallToMockServer(){
        /* Starting the mockserver */
        mockServer = ClientAndServer.startClientAndServer(1080);

        /* Create an expectation (API) */
        MockClient.GET("/login", "{\"result\": \"123\"}");

        /* Execute the call to the mockAPI, baseURI should be the same as the host & port from the MockClient.GET */
        RestAssured.baseURI = "http://127.0.0.1:1080";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/login");

        JsonPath body = response.jsonPath();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(body.get("result"), "123");

        /* Stop the mockServer */
        mockServer.stop();
    }
}