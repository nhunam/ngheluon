package saola.com.ngheluon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.Library;

public interface LibraryRepository extends JpaRepository<Author, String> {

}