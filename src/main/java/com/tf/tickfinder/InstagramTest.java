package com.tf.tickfinder;

import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.oauth.InstagramService;

public class InstagramTest {

	public static void main(String[] args) {
		InstagramService service = new InstagramAuthService().apiKey("1abdf5508db24f6987fb3c7ffbee4d77").apiSecret("bc285abdcc5443f19f8df3693435112f").callback("").build();
		String authorizationUrl = service.getAuthorizationUrl();
		
	
	}

}
