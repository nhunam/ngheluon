package saola.com.ngheluon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.HighlightBook;

public interface HighlightBookRepository extends JpaRepository<HighlightBook, String> {

}