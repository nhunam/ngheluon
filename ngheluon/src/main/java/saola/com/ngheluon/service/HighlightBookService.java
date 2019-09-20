package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.HighlightBook;

public interface HighlightBookService {
  List<HighlightBook> findAll(@Nullable Pageable pageRequest);

  HighlightBook findById(String id);

  HighlightBook save(HighlightBook entity);

  HighlightBook update(String id, HighlightBook entity);

  void delete(String id);
}