package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Author;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@RestController(value = "authors")
@RequestMapping("/api/v1/authors")
public class AuthorController extends BaseController<Author, UUID> {
    @Override
    protected Optional<UUID> validateId(String id) {
        try {
            return Optional.of(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}