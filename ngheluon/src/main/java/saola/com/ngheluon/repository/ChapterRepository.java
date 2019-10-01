package saola.com.ngheluon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.Chapter;

public interface ChapterRepository extends BaseRepository<Chapter, String> {
  Page<Chapter> findByBookId(String bookId, Pageable pageable);
  Chapter findByBookIdAndOrder(String bookId, Integer order);
}