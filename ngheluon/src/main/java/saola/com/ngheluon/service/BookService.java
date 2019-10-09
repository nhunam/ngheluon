package saola.com.ngheluon.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Book;

public interface BookService extends BaseService<Book, UUID> {
  Page<Book> findByAuthorId(Optional<UUID> authorId, Pageable pageable);
}