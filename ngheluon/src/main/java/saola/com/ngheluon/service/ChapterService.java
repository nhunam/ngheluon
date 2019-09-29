package saola.com.ngheluon.service;

import java.util.List;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Chapter;

public interface ChapterService {
  List<Chapter> findByBook(Book book);
}