package payloadBuilder;

import org.json.simple.JSONObject;

public class UserPayload {

    public static JSONObject userLoginPayLoad(String email, String password){
        JSONObject userLogin = new JSONObject();
        userLogin.put("email", email);
        userLogin.put("password", password);

        return userLogin;

    }
}
