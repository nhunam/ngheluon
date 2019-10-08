package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.dto.ResponseDTO;
import saola.com.ngheluon.service.ChapterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@RestController(value = "chapters")
@RequestMapping("/api/v1/chapters")
public class ChapterController extends BaseController<Chapter, UUID> {
  @Autowired
  public ChapterService service;

  @Override
  protected Optional<UUID> validateId(String id) throws IllegalArgumentException {
    try {
      return Optional.of(UUID.fromString(id));
    } catch (IllegalArgumentException ex) {
      throw new IllegalArgumentException("ID: " + id + " is empty or malformed!");
    }
  }

  @GetMapping("/books/{bookId}")
  public ResponseEntity<ResponseDTO> findByBookId(@PathVariable String bookId, Pageable pageable) {
    Optional<UUID> bId = validateId(bookId);
    Page<Chapter> chapters = service.findByBookId(bId, pageable);
    return ResponseEntity.ok(ResponseDTO.builder().body(chapters).build());
  }
}