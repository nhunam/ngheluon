package saola.com.ngheluon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.TopicBook;

public interface TopicBookRepository extends JpaRepository<Author, String> {

}