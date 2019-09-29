package saola.com.ngheluon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.repository.ChapterRepository;
import saola.com.ngheluon.service.ChapterService;

@Service
public class ChapterServiceImpl extends BaseServiceImpl<Chapter> implements ChapterService {
  @Autowired
  ChapterRepository repository;

  @Override
  public List<Chapter> findByBook(Book book) {
    return repository.findByBook(book);
  }
}
