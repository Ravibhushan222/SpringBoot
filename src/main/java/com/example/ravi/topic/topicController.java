package com.example.ravi.topic;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class topicController {
	
	
	
	@Autowired
	private TopicService topicservice;

	
	
	
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		
		return  topicservice.getAlltopics();
	}
	
	@RequestMapping("/topics/{fff}")
	public Topic getTopic(@PathVariable("fff") String id) {
		return topicservice.getTopic(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		
		topicservice.addTopic(topic);
	}
	
	
	
	
	@PutMapping("/topics")
	public Topic updateUser(@RequestBody Topic user) {
		
		return topicservice.updateTopic(user);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		
		topicservice.updateTopic(id,topic);
		
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		
		topicservice.deleteTopic(id);
		
		
	}
	
	
	
	
	
	
}
