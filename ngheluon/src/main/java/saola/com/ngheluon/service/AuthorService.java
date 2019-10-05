package saola.com.ngheluon.service;

import java.util.List;
import java.util.UUID;

import saola.com.ngheluon.dataset.Author;

public interface AuthorService extends BaseService<Author, UUID> {
  List<Author> findByName(String name);
}