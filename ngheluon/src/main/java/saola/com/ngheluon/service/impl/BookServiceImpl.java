package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.repository.BookRepository;
import saola.com.ngheluon.service.BookService;

@Service
public class BookServiceImpl implements BookService {
  @Autowired
  BookRepository repository;

  @Override
  public List<Book> findAll(Pageable pageRequest) {
    Page<Book> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public Book findById(String id) {
    return repository.findById(id).get();
  }

  public Book save(Book entity) {
    return repository.save(entity);
  }

  public Book update(String id, Book entity) {
    Optional<Book> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
