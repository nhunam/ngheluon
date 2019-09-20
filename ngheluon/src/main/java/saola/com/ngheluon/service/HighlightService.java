package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Highlight;

public interface HighlightService {
  List<Highlight> findAll(@Nullable Pageable pageRequest);

  Highlight findById(String id);

  Highlight save(Highlight entity);

  Highlight update(String id, Highlight entity);

  void delete(String id);
}