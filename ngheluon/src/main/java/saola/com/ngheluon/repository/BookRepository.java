package saola.com.ngheluon.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Book;

public interface BookRepository extends BaseRepository<Book, UUID> {
  Page<Book> findByAuthorId(Optional<UUID> authorId, Pageable pageable);
}