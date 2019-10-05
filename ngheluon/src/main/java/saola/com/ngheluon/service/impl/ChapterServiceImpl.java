package saola.com.ngheluon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.repository.ChapterRepository;
import saola.com.ngheluon.service.ChapterService;

import java.util.Optional;
import java.util.UUID;

@Service
public class ChapterServiceImpl extends BaseServiceImpl<Chapter, UUID> implements ChapterService {
  @Autowired
  ChapterRepository repository;

  @Override
  public Page<Chapter> findByBookId(Optional<UUID> bookId, Pageable pageable) {
    return repository.findByBookId(bookId, pageable);
  }

  @Override
  public Chapter findByBookIdAndOrder(String bookId, Integer order) {
    return repository.findByBookIdAndOrder(bookId, order);
  }
}
