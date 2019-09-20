package saola.com.ngheluon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.Highlight;

public interface HighlightRepository extends JpaRepository<Author, String> {

}