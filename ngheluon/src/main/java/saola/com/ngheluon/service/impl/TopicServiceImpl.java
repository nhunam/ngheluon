package saola.com.ngheluon.service.impl;

import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Topic;
import saola.com.ngheluon.service.TopicService;

import java.util.UUID;

@Service
public class TopicServiceImpl extends BaseServiceImpl<Topic, UUID> implements TopicService {
}
