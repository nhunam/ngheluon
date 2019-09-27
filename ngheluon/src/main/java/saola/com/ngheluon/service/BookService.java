package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Book;

public interface BookService {
  List<Book> findAll(@Nullable Pageable pageRequest);

  Book findById(String id);

  Book save(Book entity);

  Book update(String id, Book entity);

  void delete(String id);
}