package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.CategoryBook;

public interface CategoryBookService {
  List<CategoryBook> findAll(@Nullable Pageable pageRequest);

  CategoryBook findById(String id);

  CategoryBook save(CategoryBook entity);

  CategoryBook update(String id, CategoryBook entity);

  void delete(String id);
}