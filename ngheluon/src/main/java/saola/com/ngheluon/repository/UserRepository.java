package saola.com.ngheluon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.User;

public interface UserRepository extends JpaRepository<Author, String> {

}