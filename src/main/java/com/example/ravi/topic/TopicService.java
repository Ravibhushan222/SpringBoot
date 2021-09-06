package com.example.ravi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;







@Service
public class TopicService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_INTO_TOPICS_QUERY="INSERT INTO TOPICS(id,name,description) values(?,?,?)";
	private static final String UPDATE_TOPICS_BY_ID_QUERY="UPDATE TOPICS SET name=? WHERE ID =?";
	private static final String GET_TOPIC_BY_ID_QUERY="SELECT * FROM TOPICS WHERE ID=?";
	private static final String DELETE_TOPICS_BY_ID="DELETE FROM TOPICS WHERE ID=?";
	private static final String GET_TOPICS_QUERY="SELECT * FROM TOPICS";
	

//	private List<Topic> topics=
//		new ArrayList<>( Arrays.asList(
//				new Topic("Spring","Spring Framework","Spring descriptipn"),
//				new Topic("c++","c++ no Framework","c++ descriptipn"),
//				new Topic("java","core java","java descriptipn")
//				
//				));
//	
	
	
	public void addTopic(Topic topic) {
		jdbcTemplate.update(INSERT_INTO_TOPICS_QUERY,topic.getId(),topic.getName(),topic.getDescription());
		//topics.add(topic);
		
	}
	
	public  List<Topic>getAlltopics(){
		
	return jdbcTemplate.query(GET_TOPICS_QUERY, (rs,rowNum) ->{
		return new Topic(rs.getString("id"),rs.getString("name"),rs.getString("description"));
		
		});
	
	}
	
	
	

	public Topic getTopic(String id) {
		
		return	jdbcTemplate.queryForObject(GET_TOPIC_BY_ID_QUERY,(rs,rowNum)->{
			
			return new Topic(rs.getString("id"),rs.getString("name"),rs.getString("description"));
		},id);
		
	}

 

	public Topic updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		 jdbcTemplate.update(UPDATE_TOPICS_BY_ID_QUERY,topic.getName(),topic.getId());
			
			return topic;
	}

   
	
	public void updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
		
		 jdbcTemplate.update(UPDATE_TOPICS_BY_ID_QUERY,topic.getName(),topic.getId());
//		for(int i=0;i<topics.size();i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//			}
//		}
	}
	
	
	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETE_TOPICS_BY_ID,id);
		
		//topics.removeIf(t->t.getId().equals(id));
	}
	
	
	




}
