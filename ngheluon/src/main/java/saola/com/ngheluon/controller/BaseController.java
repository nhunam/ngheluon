package saola.com.ngheluon.controller;

import java.util.List;
import java.util.Optional;

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

abstract public class BaseController<T extends BaseModel<ID>, ID> {

  @Autowired
  private BaseService<T, ID> service;

  abstract protected Optional<ID> validateId(String id);

  @GetMapping()
  public ResponseEntity<List<T>> getAll(@Nullable Pageable pageRequest) {
    List<T> paged = service.findAll(pageRequest);
    return ResponseEntity.ok(paged);
  }

  @GetMapping("/{id}")
  public ResponseEntity<T> find(@PathVariable String id) {
    var validatedId = validateId(id);
    if (validatedId.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return ResponseEntity.ok(service.findById(validatedId.get()));
    }

  }

  @PostMapping()
  public ResponseEntity<T> add(@Valid @RequestBody T entity) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
  }

  @PutMapping("/{id}")
  public ResponseEntity<T> update(@PathVariable String id, @Valid @RequestBody T entity) throws Exception {
    var validatedId = validateId(id);
    if (validatedId.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return ResponseEntity.ok(service.update(validatedId.get(), entity));
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<T> delete(@PathVariable String id) {
    var validatedId = validateId(id);
    if (validatedId.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      service.delete(validatedId.get());
      return ResponseEntity.ok().build();
    }
  }
}
