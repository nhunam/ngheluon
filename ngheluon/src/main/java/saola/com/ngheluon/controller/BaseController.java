package saola.com.ngheluon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import saola.com.ngheluon.dataset.BaseModel;
import saola.com.ngheluon.service.BaseService;

public class BaseController<T extends BaseModel> {

  @Autowired
  private BaseService<T> service;

  @GetMapping()
  public ResponseEntity<List<T>> getAll(@Nullable Pageable pageRequest) {
    List<T> paged = service.findAll(pageRequest);
    return ResponseEntity.ok(paged);
  }

  @GetMapping("/{id}")
  public ResponseEntity<T> find(@PathVariable String id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping()
  public ResponseEntity<T> add(@Valid @RequestBody T entity) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
  }

  @PutMapping("/{id}")
  public ResponseEntity<T> update(@PathVariable String id, @Valid @RequestBody T entity) throws Exception {
    return ResponseEntity.ok(service.update(id, entity));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<T> delete(@PathVariable String id) {
    service.delete(id);
    return ResponseEntity.ok().build();
  }
}
