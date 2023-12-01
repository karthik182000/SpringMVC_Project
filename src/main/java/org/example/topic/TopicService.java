package org.example.topic;

import org.springframework.stereotype.Service;


import java.util.*;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics =new  ArrayList<>(Arrays.asList(
                new Topic ("math","statistics","ML related statistics"),
                new Topic ("eng","Coms","Comunication is the key"),
                new Topic ("java","CoreJava","Basics")
    ));
    public List<Topic> getAllTopics(){
        return topics;
    }
    public Topic getTopic(String id){
        return (Topic) topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
    }


    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        int i;
        for (i = 0; i < topics.size();i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
            }
        }
    }

    public Topic deleteTopic(String id) {
        topics.removeIf(t->t.getId().equals(id));
        return null;
    }
}

