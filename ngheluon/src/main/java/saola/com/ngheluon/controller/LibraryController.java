package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Library;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@RestController(value = "libraries")
@RequestMapping("/api/v1/libraries")
public class LibraryController extends BaseController<Library, UUID> {
  @Override
  protected Optional<UUID> validateId(String id) throws IllegalArgumentException {
    try {
      return Optional.of(UUID.fromString(id));
    } catch (IllegalArgumentException ex) {
      throw new IllegalArgumentException("ID: " + id + " is empty or malformed!");
    }
  }
}