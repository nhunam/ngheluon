package saola.com.ngheluon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Chapter;

import java.util.Optional;
import java.util.UUID;

public interface ChapterRepository extends BaseRepository<Chapter, UUID> {
  Page<Chapter> findByBookId(Optional<UUID> bookId, Pageable pageable);
  Chapter findByBookIdAndOrder(Optional<UUID> bookId, Integer order);
}