package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.service.ChapterService;

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

@RestController(value = "chapters")
@RequestMapping("/api/chapters")
public class ChapterController {
  @Autowired
  public ChapterService service;

  @GetMapping()
  public List<Chapter> findAll(@Nullable Pageable pageble) {
    return service.findAll(pageble);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Chapter> find(@PathVariable String id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping()
  public ResponseEntity<Chapter> add(@Valid @RequestBody Chapter entity) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Chapter> update(@PathVariable String id, @Valid @RequestBody Chapter entity) {
    return ResponseEntity.ok(service.update(id, entity));
  }
}