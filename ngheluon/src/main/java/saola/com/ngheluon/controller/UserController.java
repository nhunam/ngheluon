package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.User;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@RestController(value = "users")
@RequestMapping("/api/v1/users")
public class UserController extends BaseController<User, UUID> {
  @Override
  protected Optional<UUID> validateId(String id) throws IllegalArgumentException {
    try {
      return Optional.of(UUID.fromString(id));
    } catch (IllegalArgumentException ex) {
      throw new IllegalArgumentException("ID: " + id + " is empty or malformed!");
    }
  }
}