package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Category;
import saola.com.ngheluon.repository.CategoryRepository;
import saola.com.ngheluon.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  CategoryRepository repository;

  @Override
  public List<Category> findAll(Pageable pageRequest) {
    Page<Category> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public Category findById(String id) {
    return repository.findById(id).get();
  }

  public Category save(Category entity) {
    return repository.save(entity);
  }

  public Category update(String id, Category entity) {
    Optional<Category> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
