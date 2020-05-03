package batchfour.teamtwo.renttrailservice.security.oauth2.user;

import java.util.Map;

public class GoogleOAuth2AccountInfo extends OAuth2AccountInfo {

    public GoogleOAuth2AccountInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("sub");
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
