package saola.com.ngheluon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.Book;

public interface BookRepository extends JpaRepository<Book, String> {

}