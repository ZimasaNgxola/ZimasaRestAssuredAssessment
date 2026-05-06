package requestBuilder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloadBuilder.UserPayload;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;

public class AdminRequestBuilder {

    public static String adminToken;

    static String userToken;

    public static Response loginUser(String email, String password) {

        String apiPath = "/APIDEV/login";
        Response response = given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(UserPayload.userLoginPayLoad(email, password))
                .post()
                .then()
                .extract().response();
        userToken = response.jsonPath().getString("data.token");
        return response;

    }

    public static Response adminLogin(){
        Response response = loginUser("admin@gmail.com", "@12345678");
        adminToken = response.jsonPath().getString("data.token");
        return response;
    }
}
