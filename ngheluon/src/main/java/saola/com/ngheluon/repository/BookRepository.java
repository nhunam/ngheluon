package saola.com.ngheluon.repository;

import saola.com.ngheluon.dataset.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends BaseRepository<Book, UUID> {
  List<Book> findByAuthorId(Optional<UUID> authorId);
}