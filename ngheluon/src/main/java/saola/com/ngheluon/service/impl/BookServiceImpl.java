package saola.com.ngheluon.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.repository.BookRepository;
import saola.com.ngheluon.service.BookService;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book, UUID> implements BookService {
  @Autowired
  BookRepository repository;

  @Override
  public Page<Book> findByAuthorId(Optional<UUID> authorId, Pageable pageable) {
    return repository.findByAuthorId(authorId, pageable);
  }
}
