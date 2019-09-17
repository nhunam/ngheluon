package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.BaseModel;
import saola.com.ngheluon.repository.BaseRepository;
import saola.com.ngheluon.service.BaseService;

@Service
public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {
  @Autowired
  private BaseRepository<T, String> repository;

  public List<T> findAll(Pageable pageRequest) {
    Page<T> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public T findById(String id) {
    return repository.findById(id).orElseThrow();
  }

  public T save(T entity) {
    return repository.save(entity);
  }

  public T update(String id, T entity) throws NotFoundException {
    Optional<T> existedOpt = repository.findById(id);
    if (null != existedOpt && !existedOpt.isEmpty() && !existedOpt.isEmpty()) {
      entity.setId(existedOpt.get().getId());
      entity.setCreated(existedOpt.get().getCreated());
      return repository.save(entity);
    }
    throw new NotFoundException();
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}