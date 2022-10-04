package sk.softec.app.model;

public class User {

	private UserId id;
	private String name;
	private byte [] publicKey;
	
	public User(UserId id, String name, byte [] publicKey) {
		this.id = id;
		this.name = name;
		this.publicKey = publicKey;
	}

	public UserId getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public byte[] getPublicKey() {
		return publicKey;
	}
}
