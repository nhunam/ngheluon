package saola.com.ngheluon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.service.TopicService;

@RestController
@RequestMapping("")
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	/* get list topic */
	@RequestMapping(path = "/topic", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> getTopicList() {
		return new ResponseEntity<>(topicService.getList(), HttpStatus.OK);
	}

}
