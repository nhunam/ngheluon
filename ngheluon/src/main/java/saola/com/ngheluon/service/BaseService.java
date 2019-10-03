package saola.com.ngheluon.service;

import java.util.List;
import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.BaseModel;

public interface BaseService<T extends BaseModel<ID>, ID> {
  List<T> findAll(Pageable pageRequest);

  T findById(String id);

  T save(T entity);

  T update(String id, T entity) throws Exception;

  void delete(String id);
}