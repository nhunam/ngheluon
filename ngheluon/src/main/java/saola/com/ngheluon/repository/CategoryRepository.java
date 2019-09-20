package saola.com.ngheluon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.Category;

public interface CategoryRepository extends JpaRepository<Author, String> {

}