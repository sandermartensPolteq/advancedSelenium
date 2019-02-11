package common.mockUtils;

import org.mockserver.client.MockServerClient;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class MockClient {

    public static void GET(String path, String body){
        new MockServerClient("localhost", 1080)
                .when(
                        request()
                                .withMethod("GET")
                                .withPath(path)
                )
                .respond(
                        response()
                                .withStatusCode(200)
                                .withBody(body)
                );
    }
}
