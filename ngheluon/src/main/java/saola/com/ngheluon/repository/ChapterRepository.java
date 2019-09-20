package saola.com.ngheluon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.ChapterCategory;

public interface ChapterRepository extends JpaRepository<Author, String> {

}