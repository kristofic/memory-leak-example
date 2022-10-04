package sk.softec.app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.softec.app.model.User;
import sk.softec.app.model.UserId;
import sk.softec.app.service.UserService;

/**
 * Created by Andrej Kristofic on 20.03.2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private UserService service = new UserService();

	@GetMapping("/{company}/{id}")
	public User get(@PathVariable("company") String company, @PathVariable("id") Long id) {
		return service.getUser(new UserId(company, id));
	}
}
