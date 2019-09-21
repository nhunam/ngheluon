package saola.com.ngheluon.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import saola.com.ngheluon.dataset.Topic;

public interface TopicRepository extends JpaRepository<Topic, String> {

}
