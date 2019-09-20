package saola.com.ngheluon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.User;
import saola.com.ngheluon.repository.UserRepository;
import saola.com.ngheluon.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository repository;

  @Override
  public List<User> findAll(Pageable pageRequest) {
    Page<User> pagedData = repository.findAll(pageRequest);
    return pagedData.getContent();
  }

  public User findById(String id) {
    return repository.findById(id).get();
  }

  public User save(User entity) {
    return repository.save(entity);
  }

  public User update(String id, User entity) {
    Optional<User> existed = repository.findById(id);
    if (!existed.isEmpty()) {

    }
    return repository.save(entity);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
