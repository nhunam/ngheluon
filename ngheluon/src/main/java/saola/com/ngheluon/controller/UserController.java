package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.User;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "users")
@RequestMapping("/api/v1/users")
public class UserController extends BaseController<User, String> {
}