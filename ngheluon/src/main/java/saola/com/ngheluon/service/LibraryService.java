package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Library;

public interface LibraryService {
  List<Library> findAll(@Nullable Pageable pageRequest);

  Library findById(String id);

  Library save(Library entity);

  Library update(String id, Library entity);

  void delete(String id);
}