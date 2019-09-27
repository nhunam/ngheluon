package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Highlight;
import saola.com.ngheluon.repository.HighlightRepository;
import saola.com.ngheluon.service.HighlightService;

@Service
public class HighlightServiceImpl implements HighlightService {
  @Autowired
  HighlightRepository repository;

  @Override
  public List<Highlight> findAll(Pageable pageRequest) {
    Page<Highlight> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public Highlight findById(String id) {
    return repository.findById(id).get();
  }

  public Highlight save(Highlight entity) {
    return repository.save(entity);
  }

  public Highlight update(String id, Highlight entity) {
    Optional<Highlight> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
