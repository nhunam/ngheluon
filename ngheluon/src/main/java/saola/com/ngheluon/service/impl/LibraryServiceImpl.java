package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Library;
import saola.com.ngheluon.repository.LibraryRepository;
import saola.com.ngheluon.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {
  @Autowired
  LibraryRepository repository;

  @Override
  public List<Library> findAll(Pageable pageRequest) {
    Page<Library> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public Library findById(String id) {
    return repository.findById(id).get();
  }

  public Library save(Library entity) {
    return repository.save(entity);
  }

  public Library update(String id, Library entity) {
    Optional<Library> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
