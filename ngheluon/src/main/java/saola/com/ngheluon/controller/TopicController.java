package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Topic;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "topics")
@RequestMapping("/api/v1/topics")
public class TopicController extends BaseController<Topic, String> {
}