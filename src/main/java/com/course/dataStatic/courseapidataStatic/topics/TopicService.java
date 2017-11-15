package com.course.dataStatic.courseapidataStatic.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.dataStatic.courseapidataStatic.topics.Topic;

@Service
public class TopicService {
	
	//Arrays.asList creates immutable array.
	private List<Topic> topics = new ArrayList<>( Arrays.asList(new Topic("spring","spring boot", "spring boot description"),
			new Topic("java","java 8", "java description"),
			new Topic("javascript","javascript", "javascript description")));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id){
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
	}
	
	public void addTopic(Topic topic){
		topics.add(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i<topics.size();i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void removeTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		/*for (int i = 0; i<topics.size();i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.remove(i);
				return;
			}
		}*/
		
	}
	
	
}
