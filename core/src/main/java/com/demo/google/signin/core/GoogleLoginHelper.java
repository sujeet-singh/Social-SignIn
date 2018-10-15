package com.demo.google.signin.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.google.signin.core.gson.UserProfile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

public final class GoogleLoginHelper {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleLoginHelper.class);
	
	public static String getProfileDetails(SlingHttpServletRequest request, String authCode) {
		// (Receive authCode via HTTPS POST)


		if (request.getHeader("X-Requested-With") == null) {
			// Without the `X-Requested-With` header, this request could be forged. Aborts.
		}

		// Set path to the Web application client_secret_*.json file you downloaded from the
		// Google API Console: https://console.developers.google.com/apis/credentials
		// You can also find your Web application client ID and client secret from the
		// console and specify them directly when you create the GoogleAuthorizationCodeTokenRequest
		// object.
		String CLIENT_SECRET_FILE = "D:\\AEM\\6.1.0-SP2\\author\\credendials.json";
		try {
			// Exchange auth code for access token
			File file = new File(CLIENT_SECRET_FILE);
			LOGGER.info(file.getAbsolutePath());
			GoogleClientSecrets clientSecrets =
					GoogleClientSecrets.load(
							JacksonFactory.getDefaultInstance(), new FileReader(file));
			GoogleTokenResponse tokenResponse;

			tokenResponse = new GoogleAuthorizationCodeTokenRequest(
					new NetHttpTransport(),
					JacksonFactory.getDefaultInstance(),
					"https://www.googleapis.com/oauth2/v4/token",
					clientSecrets.getDetails().getClientId(),
					clientSecrets.getDetails().getClientSecret(),
					authCode,
					"http://localhost:4502")
					.execute();
			GoogleIdToken idToken = tokenResponse.parseIdToken();
			GoogleIdToken.Payload payload = idToken.getPayload();
			String userId = payload.getSubject();  // Use this value as a key to identify a user.
			String email = payload.getEmail();
			boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			String name = (String) payload.get("name");
			String pictureUrl = (String) payload.get("picture");
			String locale = (String) payload.get("locale");
			String familyName = (String) payload.get("family_name");
			String givenName = (String) payload.get("given_name");
			UserProfile userProfile = new UserProfile();
			userProfile.setEmail(email);
			userProfile.setFamilyName(familyName);
			userProfile.setGivenName(givenName);
			userProfile.setLocale(locale);
			userProfile.setName(name);
			userProfile.setPictureUrl(pictureUrl);
			userProfile.setVerfiedEmailAdd(emailVerified);
			userProfile.setUserid(userId);
			return new ObjectMapper().writeValueAsString(userProfile);
		} catch (IOException e) {
			LOGGER.error("IOException *** ", e);
		}
		return "{'error': 'something went wrong'}";
	}
}
