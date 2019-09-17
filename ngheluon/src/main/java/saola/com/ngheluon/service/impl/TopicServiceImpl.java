package saola.com.ngheluon.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Topic;
import saola.com.ngheluon.repository.TopicRepository;
import saola.com.ngheluon.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicRepository topicRepo;
	
	@Override
	public List<Topic> getList(){
		List<Topic> ls = new ArrayList<>();
		Iterator<Topic> it = topicRepo.findAll().iterator();
		while(it.hasNext()) {
			Topic tp = it.next();
			ls.add(tp);
		}
		
		return ls;
	}

}
