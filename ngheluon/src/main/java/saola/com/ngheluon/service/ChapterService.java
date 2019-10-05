package saola.com.ngheluon.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Chapter;

import java.util.Optional;
import java.util.UUID;

public interface ChapterService extends BaseService<Chapter, UUID> {
  Page<Chapter> findByBookId(Optional<UUID> bId, Pageable pageable);
  Chapter findByBookIdAndOrder(String bookId, Integer order);
}