import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class broker {
    private Map<String, topic> topics;

    public broker() {
        this.topics = new HashMap<>();
        createTopic("Front-Com");
        createTopic("Com-RM");
        createTopic("Notif");
        createTopic("Notif-App");

    }

    public void createTopic(String topicName) {
        topics.put(topicName, new topic());
    }

    public void send(String topicName, String message) {
        if (topics.containsKey(topicName)) {
            topic topic = topics.get(topicName);
            topic.addMessage(message);
        } else {
            System.out.println("Topic '" + topicName + "' does not exist.");
        }
    }

    public String receive(String topicName) {
        if (topics.containsKey(topicName)) {
            topic topic = topics.get(topicName);
            List<String> msg = topic.getMessages();
            if (msg.size() > 0){
             String m = msg.get(0);
             topic.removeMessage(0);
                return m;
            }
             else return null;
        } else {
            System.out.println("Topic '" + topicName + "' does not exist.");
            return null;
        }
    }
}

