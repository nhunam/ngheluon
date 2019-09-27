package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Topic;

public interface TopicService {
  List<Topic> findAll(@Nullable Pageable pageRequest);

  Topic findById(String id);

  Topic save(Topic entity);

  Topic update(String id, Topic entity);

  void delete(String id);
}