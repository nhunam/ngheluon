package saola.com.ngheluon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.repository.BookRepository;
import saola.com.ngheluon.service.BookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book, UUID> implements BookService {
  @Autowired
  BookRepository repository;

  @Override
  public List<Book> findByAuthorId(Optional<UUID> authorId) {
    return repository.findByAuthorId(authorId);
  }
}
