package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Highlight;
import saola.com.ngheluon.service.BookService;
import saola.com.ngheluon.service.HighlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@RestController(value = "highlights")
@RequestMapping("/api/v1/highlights")
public class HighlightController extends BaseController<Highlight, UUID> {
    @Autowired
    private HighlightService service;
    @Autowired
    private BookService bookService;

    @PutMapping("/{highlightId}/books/{bookId}")
    public ResponseEntity<Highlight> assignBook(@PathVariable(value = "bookId") String bookId,
            @PathVariable(value = "highlightId") String highlightId) throws Exception {
      Optional<UUID> bId = validateId(bookId);
      Optional<UUID> tId = validateId(highlightId);
      Highlight highlight = service.findById(tId.get());
      Book book = bookService.findById(bId.get());
      highlight.getBooks().add(book);
      return update(highlightId, highlight);
    }

    @Override
    protected Optional<UUID> validateId(String id) {
        try {
            return Optional.of(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}