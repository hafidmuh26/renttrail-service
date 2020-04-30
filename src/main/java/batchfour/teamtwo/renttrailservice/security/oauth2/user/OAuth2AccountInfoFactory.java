package batchfour.teamtwo.renttrailservice.security.oauth2.user;

import batchfour.teamtwo.renttrailservice.exceptions.OAuth2AuthenticationProcessingException;
import batchfour.teamtwo.renttrailservice.entities.AuthProvider;

import java.util.Map;

public class OAuth2AccountInfoFactory {

    public static OAuth2AccountInfo getOAuth2AccountInfo(String registrationId, Map<String, Object> attributes)  {
        if (registrationId.equalsIgnoreCase(AuthProvider.google.toString())){
            return new GoogleOAuth2AccountInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2AccountInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
