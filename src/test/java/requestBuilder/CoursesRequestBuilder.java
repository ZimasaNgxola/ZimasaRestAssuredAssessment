package requestBuilder;

import io.restassured.response.Response;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;
import static requestBuilder.AdminRequestBuilder.adminToken;

public class CoursesRequestBuilder {

    public static Response getPublishedCourses(){
        String apiPath = "/APIDEV/courses?";
        Response response = given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + adminToken)
                .basePath(apiPath)
                .queryParam("category","automation")
                .queryParam("level","beginner")
                .when()
                .get()
                .then()
                .extract().response();
        return response;

    }
}
