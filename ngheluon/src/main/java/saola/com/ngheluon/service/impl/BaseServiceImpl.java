package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.BaseModel;
import saola.com.ngheluon.exception.ResourceNotFoundException;
import saola.com.ngheluon.repository.BaseRepository;
import saola.com.ngheluon.service.BaseService;

@Service
public abstract class BaseServiceImpl<T extends BaseModel<ID>, ID> implements BaseService<T, ID> {
  @Autowired
  private BaseRepository<T, ID> repository;

  public List<T> findAll(Pageable pageRequest) {
    Page<T> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public T findById(ID id) throws ResourceNotFoundException {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource with id " + id + " not found!"));
  }

  public T save(T entity) {
    return repository.save(entity);
  }

  public T update(ID id, T entity) throws ResourceNotFoundException {
    Optional<T> existedOpt = repository.findById(id);
    if (null != existedOpt && !existedOpt.isEmpty() && !existedOpt.isEmpty()) {
      entity.setId(existedOpt.get().getId());
      entity.setCreatedAt(existedOpt.get().getCreatedAt());
      return repository.save(entity);
    }
    throw new ResourceNotFoundException("Resource with id " + id + " not found!");
  }

  public void delete(ID id) throws ResourceNotFoundException {
    try {
      repository.deleteById(id);  
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException("Resource with id " + id + " not found!", e);
    }
  }
}