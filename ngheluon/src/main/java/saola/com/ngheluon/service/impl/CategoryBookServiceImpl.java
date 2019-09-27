package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.CategoryBook;
import saola.com.ngheluon.repository.CategoryBookRepository;
import saola.com.ngheluon.service.CategoryBookService;

@Service
public class CategoryBookServiceImpl implements CategoryBookService {
  @Autowired
  CategoryBookRepository repository;

  @Override
  public List<CategoryBook> findAll(Pageable pageRequest) {
    Page<CategoryBook> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public CategoryBook findById(String id) {
    return repository.findById(id).get();
  }

  public CategoryBook save(CategoryBook entity) {
    return repository.save(entity);
  }

  public CategoryBook update(String id, CategoryBook entity) {
    Optional<CategoryBook> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
