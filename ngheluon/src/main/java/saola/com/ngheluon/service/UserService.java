package saola.com.ngheluon.service;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.data.domain.Pageable;

import saola.com.ngheluon.dataset.User;

public interface UserService {
  List<User> findAll(@Nullable Pageable pageRequest);

  User findById(String id);

  User save(User entity);

  User update(String id, User entity);

  void delete(String id);
}