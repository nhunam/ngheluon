package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.TopicBook;
import saola.com.ngheluon.repository.TopicBookRepository;
import saola.com.ngheluon.service.TopicBookService;

@Service
public class TopicBookServiceImpl implements TopicBookService {
  @Autowired
  TopicBookRepository repository;

  @Override
  public List<TopicBook> findAll(Pageable pageRequest) {
    Page<TopicBook> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public TopicBook findById(String id) {
    return repository.findById(id).get();
  }

  public TopicBook save(TopicBook entity) {
    return repository.save(entity);
  }

  public TopicBook update(String id, TopicBook entity) {
    Optional<TopicBook> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
