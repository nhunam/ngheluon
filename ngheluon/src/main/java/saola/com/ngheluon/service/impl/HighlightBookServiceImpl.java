package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.HighlightBook;
import saola.com.ngheluon.repository.HighlightBookRepository;
import saola.com.ngheluon.service.HighlightBookService;

@Service
public class HighlightBookServiceImpl implements HighlightBookService {
  @Autowired
  HighlightBookRepository repository;

  @Override
  public List<HighlightBook> findAll(Pageable pageRequest) {
    Page<HighlightBook> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public HighlightBook findById(String id) {
    return repository.findById(id).get();
  }

  public HighlightBook save(HighlightBook entity) {
    return repository.save(entity);
  }

  public HighlightBook update(String id, HighlightBook entity) {
    Optional<HighlightBook> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
