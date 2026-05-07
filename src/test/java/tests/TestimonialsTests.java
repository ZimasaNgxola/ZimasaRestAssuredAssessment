package tests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import requestBuilder.AdminRequestBuilder;
import requestBuilder.TestimonialsRequestBuilder;

public class TestimonialsTests extends CoursesTests {

    static String title;
    static String content;
    static String rating;
    static String isPublic;
    static String adminEmail;
    static String adminPassword;
    static String updateTitle;
    static String updateContent;
    static String updateRating;

    static Faker faker = new Faker();


    @BeforeClass
    public static void setUpData() {
        title = faker.book().title();
        content = faker.lorem().sentence(6);
        rating = "4";
        isPublic = "true";
        adminEmail = "admin@gmail.com";
        adminPassword = "@12345678";
        updateTitle = faker.book().title();
        updateContent = faker.lorem().sentence(6);
        updateRating = "5";
    }

    @Test(priority = 1)
    public void adminLoginTest() {
        Response response = AdminRequestBuilder.adminLogin();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("data.token"));
        Assert.assertNotEquals(response.jsonPath().getString("data.role"), "user");
    }


    @Test(priority = 2)
    public void createTestimonialTest() {
        Response response = TestimonialsRequestBuilder.createTestimonial(title, content, rating, isPublic);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertNotEquals(response.jsonPath().getString("data.rating"), "0");

    }

    @Test(priority = 3)
    public void updateTestimonialTest() {
        Response response = TestimonialsRequestBuilder.updateTestimonial(updateTitle, updateContent, updateRating);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "Testimonial updated successfully");
    }

    @Test(priority = 4)
    public void deleteTestimonialTest() {
        Response response = TestimonialsRequestBuilder.deleteTestimonial();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "Testimonial deleted successfully");
    }

}