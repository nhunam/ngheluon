package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Author;

public interface AuthorService {
  List<Author> findAll(@Nullable Pageable pageRequest);

  Author findById(String id);

  Author save(Author entity);

  Author update(String id, Author entity);

  void delete(String id);
}