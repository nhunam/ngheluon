package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Library;
import saola.com.ngheluon.service.LibraryService;

import java.util.List;

import javax.annotation.Nullable;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "librarys")
@RequestMapping("/api/librarys")
public class LibraryController {
  @Autowired
  public LibraryService service;

  @GetMapping()
  public List<Library> findAll(@Nullable Pageable pageble) {
    return service.findAll(pageble);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Library> find(@PathVariable String id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping()
  public ResponseEntity<Library> add(@Valid @RequestBody Library entity) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Library> update(@PathVariable String id, @Valid @RequestBody Library entity) {
    return ResponseEntity.ok(service.update(id, entity));
  }
}