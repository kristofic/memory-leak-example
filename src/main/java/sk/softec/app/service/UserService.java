package sk.softec.app.service;

import sk.softec.app.model.User;
import sk.softec.app.model.UserId;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserService {

	private Map<UserId, User> userCache = new HashMap<UserId, User>(500);

	public synchronized User getUser(UserId id) {
		if (userCache.containsKey(id)) {
			return userCache.get(id);
		} else {
			User user = loadUserData(id);
			userCache.put(user.getId(), user);
			return user;
		}
	}

	private User loadUserData(UserId id) {
		// expensive DB/LDAP operation here
		return new User(id, id.getCompanyCode() + " " + id.getId(), loadPublicKey(id));
	}

	private byte [] loadPublicKey(UserId id) {
		byte [] randomKey = new byte[4096];
		new Random().nextBytes(randomKey);
		return randomKey;
	}
}
