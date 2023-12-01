package org.example.topic;
import java.util.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/vtopics")
    public String getAllVTopics(Model model) {
        List<Topic> topics = topicService.getAllTopics();
        model.addAttribute("topics", topics);
        return "vtopics";
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }
    @RequestMapping(method= RequestMethod.POST,value="/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }
    @RequestMapping(method= RequestMethod.PUT,value="/topics/{id}")
    public void update(@RequestBody Topic topic,@PathVariable String id) {
        topicService.updateTopic(id,topic);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
    public   Topic deleteTopic(@PathVariable String id){
         return topicService.deleteTopic(id);
    }
}
