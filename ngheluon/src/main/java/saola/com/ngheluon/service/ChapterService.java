package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Chapter;

public interface ChapterService {
  List<Chapter> findAll(@Nullable Pageable pageRequest);

  Chapter findById(String id);

  Chapter save(Chapter entity);

  Chapter update(String id, Chapter entity);

  void delete(String id);
}