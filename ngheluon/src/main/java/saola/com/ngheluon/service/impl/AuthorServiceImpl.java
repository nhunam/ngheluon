package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Author;
import saola.com.ngheluon.service.AuthorService;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author, UUID> implements AuthorService {

  @Override
  public List<Author> findByName(String name) {
    System.out.println("Find by name");
    return null;
  }
}
