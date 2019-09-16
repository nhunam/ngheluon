package saola.com.ngheluon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.Author;

public interface AuthorRepository extends JpaRepository<Author, String> {

}