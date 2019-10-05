package saola.com.ngheluon.service;

import saola.com.ngheluon.dataset.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService extends BaseService<Book, UUID> {
  List<Book> findByAuthorId(Optional<UUID> authorId);
}