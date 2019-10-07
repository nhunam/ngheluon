package saola.com.ngheluon.service;

import java.util.List;
import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.BaseModel;
import saola.com.ngheluon.exception.ResourceNotFoundException;

public interface BaseService<T extends BaseModel<ID>, ID> {
  List<T> findAll(Pageable pageRequest);

  T findById(ID id) throws ResourceNotFoundException;

  T save(T entity);

  T update(ID id, T entity) throws Exception;

  void delete(ID id) throws ResourceNotFoundException;
}