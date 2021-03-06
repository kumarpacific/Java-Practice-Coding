package com.course.dataStatic.courseapidataStatic.topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.dataStatic.courseapidataStatic.topics.Topic;

@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id){
		return topicService.getTopic(id);
	}
	
/*	Another way to map the variable
 * @RequestMapping("/topics/{foo}")
	public Topic getTopic(@PathVariable("foo") String id){
		return topicService.getTopic(id);
	}*/
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void getTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
		topicService.updateTopic(topic,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void removeTopic(@PathVariable String id){
		topicService.removeTopic(id);
	}
	
	
}
