package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.TopicBook;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "topicbooks")
@RequestMapping("/api/v1/topicbooks")
public class TopicBookController extends BaseController<TopicBook> {
}