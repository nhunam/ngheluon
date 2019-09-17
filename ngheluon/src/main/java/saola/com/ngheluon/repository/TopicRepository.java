package saola.com.ngheluon.repository;
import org.springframework.data.repository.CrudRepository;

import saola.com.ngheluon.dataset.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
