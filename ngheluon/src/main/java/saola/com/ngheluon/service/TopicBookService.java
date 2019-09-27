package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.TopicBook;

public interface TopicBookService {
  List<TopicBook> findAll(@Nullable Pageable pageRequest);

  TopicBook findById(String id);

  TopicBook save(TopicBook entity);

  TopicBook update(String id, TopicBook entity);

  void delete(String id);
}