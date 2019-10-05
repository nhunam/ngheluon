package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Highlight;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@RestController(value = "highlights")
@RequestMapping("/api/v1/highlights")
public class HighlightController extends BaseController<Highlight, UUID> {
    @Override
    protected Optional<UUID> validateId(String id) {
        try {
            return Optional.of(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}