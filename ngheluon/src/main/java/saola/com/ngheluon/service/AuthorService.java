package saola.com.ngheluon.service;

import java.util.List;

import saola.com.ngheluon.dataset.Author;

public interface AuthorService {
  List<Author> findByName(String name);
}