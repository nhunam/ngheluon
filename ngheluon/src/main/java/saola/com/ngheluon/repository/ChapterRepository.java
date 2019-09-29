package saola.com.ngheluon.repository;

import java.util.List;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Chapter;

public interface ChapterRepository extends BaseRepository<Chapter, String> {
  List<Chapter> findByBook(Book book);
}