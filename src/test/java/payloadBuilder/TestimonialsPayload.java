package payloadBuilder;

import org.json.simple.JSONObject;

public class TestimonialsPayload {

    public static JSONObject createTestimonialPayLoad(String title, String content, String rating, String isPublic){
        JSONObject createTestimonial = new JSONObject();
        createTestimonial.put("title", title);
        createTestimonial.put("content",content);
        createTestimonial.put("rating", rating);
        createTestimonial.put("isPublic", isPublic);

        return createTestimonial;
    }

    public static JSONObject updateTestimonialPayLoad(String title, String content, String rating){
        JSONObject updateTestimonial = new JSONObject();
        updateTestimonial.put("title", title);
        updateTestimonial.put("content", content);
        updateTestimonial.put("rating", rating);

        return updateTestimonial;
    }
}
