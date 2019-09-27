package saola.com.ngheluon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, String> {

}