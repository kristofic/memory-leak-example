package sk.softec.app;

import static java.lang.Thread.sleep;

import org.junit.Test;
import sk.softec.app.model.UserId;
import sk.softec.app.service.UserService;

public class MemoryLeakDemonstration {
	
	private UserService userService = new UserService();

	@Test
	public void demonstrateMemoryLeak() throws InterruptedException {
		int counter = 0;
		try {
			while(true) {
				long randomId = Double.valueOf(Math.random() * 10).longValue();
				userService.getUser(new UserId("COMPANY", randomId));
				counter++;
				if (counter % 1000 == 0) {
					System.out.println("Successfully retrieved " + counter + " users.");
					sleep(50);
				}
			}
		} catch (OutOfMemoryError e) {
			System.err.println("Failed after " + counter + " users." );
			throw (e);
		}
	}
}
