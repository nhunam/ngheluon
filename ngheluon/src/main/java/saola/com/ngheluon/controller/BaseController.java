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
import saola.com.ngheluon.dto.ResponseDTO;
import saola.com.ngheluon.exception.ResourceNotFoundException;
import saola.com.ngheluon.service.BaseService;

abstract public class BaseController<T extends BaseModel<ID>, ID> {

  @Autowired
  private BaseService<T, ID> service;

  abstract protected Optional<ID> validateId(String id) throws IllegalArgumentException;

  @GetMapping()
  public ResponseEntity<ResponseDTO> getAll(@Nullable Pageable pageRequest) {
    List<T> paged = service.findAll(pageRequest);
    return ResponseEntity.ok(ResponseDTO.builder().body(paged).build());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseDTO> find(@PathVariable String id) throws IllegalArgumentException {
    ID validatedId = validateId(id).get();
    T entity = service.findById(validatedId);
    return ResponseEntity.ok(ResponseDTO.builder().body(entity).build());
  }

  @PostMapping()
  public ResponseEntity<ResponseDTO> add(@Valid @RequestBody T entity) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ResponseDTO.builder().status(HttpStatus.CREATED.value()).body(service.save(entity)).build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseDTO> update(@PathVariable String id, @Valid @RequestBody T entity) throws Exception {
    ID validatedId = validateId(id).get();
    return ResponseEntity.accepted().body(ResponseDTO.builder().body(service.update(validatedId, entity)).build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseDTO> delete(@PathVariable String id)
      throws IllegalArgumentException, ResourceNotFoundException {
    ID validatedId = validateId(id).get();
    service.delete(validatedId);
    return ResponseEntity.accepted().body(ResponseDTO.builder().message("Deleted!").build());
  }
}
