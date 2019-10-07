package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Topic;
import saola.com.ngheluon.dto.ResponseDTO;
import saola.com.ngheluon.service.BookService;
import saola.com.ngheluon.service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@RestController(value = "topics")
@RequestMapping("/api/v1/topics")
public class TopicController extends BaseController<Topic, UUID> {
  @Autowired
  private TopicService service;
  @Autowired
  private BookService bookService;

  @PutMapping("/{topicId}/books/{bookId}")
  public ResponseEntity<ResponseDTO> assignBook(@PathVariable(value = "bookId") String bookId,
      @PathVariable(value = "topicId") String topicId) throws Exception {
    Optional<UUID> bId = validateId(bookId);
    Optional<UUID> tId = validateId(topicId);
    Topic topic = service.findById(tId.get());
    Book book = bookService.findById(bId.get());
    topic.getBooks().add(book);
    return update(topicId, topic);
  }

  @Override
  protected Optional<UUID> validateId(String id) throws IllegalArgumentException {
    try {
      return Optional.of(UUID.fromString(id));
    } catch (IllegalArgumentException ex) {
      throw new IllegalArgumentException("ID: " + id + " is empty or malformed!");
    }
  }

}