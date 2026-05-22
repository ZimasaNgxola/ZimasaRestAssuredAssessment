package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import requestBuilder.CoursesRequestBuilder;

public class CoursesTests {

    @Test(priority = 5)
    public void getPublishedCourses(){
        Response response = CoursesRequestBuilder.getPublishedCourses();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
