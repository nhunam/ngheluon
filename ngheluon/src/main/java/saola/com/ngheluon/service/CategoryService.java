package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Category;

public interface CategoryService {
  List<Category> findAll(@Nullable Pageable pageRequest);

  Category findById(String id);

  Category save(Category entity);

  Category update(String id, Category entity);

  void delete(String id);
}