package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Topic;
import saola.com.ngheluon.repository.TopicRepository;
import saola.com.ngheluon.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
  @Autowired
  TopicRepository repository;

  @Override
  public List<Topic> findAll(Pageable pageRequest) {
    Page<Topic> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public Topic findById(String id) {
    return repository.findById(id).get();
  }

  public Topic save(Topic entity) {
    return repository.save(entity);
  }

  public Topic update(String id, Topic entity) {
    Optional<Topic> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
