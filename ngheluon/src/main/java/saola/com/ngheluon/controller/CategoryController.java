package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Category;
import saola.com.ngheluon.dto.ResponseDTO;
import saola.com.ngheluon.service.BookService;
import saola.com.ngheluon.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@RestController(value = "categories")
@RequestMapping("/api/v1/categories")
public class CategoryController extends BaseController<Category, UUID> {
  @Autowired
  private CategoryService service;
  @Autowired
  private BookService bookService;

  @PutMapping("/{categoryId}/books/{bookId}")
  public ResponseEntity<ResponseDTO> assignBook(@PathVariable(value = "bookId") String bookId,
      @PathVariable(value = "categoryId") String categoryId) throws Exception {
    Optional<UUID> bId = validateId(bookId);
    Optional<UUID> cId = validateId(categoryId);
    Category category = service.findById(cId.get());
    Book book = bookService.findById(bId.get());
    category.getBooks().add(book);
    return update(categoryId, category);
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