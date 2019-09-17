package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Author;
import saola.com.ngheluon.repository.AuthorRepository;
import saola.com.ngheluon.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
  @Autowired
  AuthorRepository repository;

  @Override
  public List<Author> findAll(Pageable pageRequest) {
    Page<Author> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public Author findById(String id) {
    return repository.findById(id).get();
  }

  public Author save(Author entity) {
    return repository.save(entity);
  }

  public Author update(String id, Author entity) {
    Optional<Author> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
