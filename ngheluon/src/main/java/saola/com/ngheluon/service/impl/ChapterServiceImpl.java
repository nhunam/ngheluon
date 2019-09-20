package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.repository.ChapterRepository;
import saola.com.ngheluon.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {
  @Autowired
  ChapterRepository repository;

  @Override
  public List<Chapter> findAll(Pageable pageRequest) {
    Page<Chapter> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public Chapter findById(String id) {
    return repository.findById(id).get();
  }

  public Chapter save(Chapter entity) {
    return repository.save(entity);
  }

  public Chapter update(String id, Chapter entity) {
    Optional<Chapter> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
