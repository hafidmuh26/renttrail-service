package batchfour.teamtwo.renttrailservice.security.oauth2.user;

import java.util.Map;

public class FacebookOAuth2AccountInfo extends OAuth2AccountInfo {


    public FacebookOAuth2AccountInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }
}
