import java.util.ArrayList;
import java.util.List;

public class topic {
       private List<String> messages;
      

    public topic() {
        this.messages = new ArrayList<>();
   
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void removeMessage(int index) {
        if (index >= 0 && index < messages.size()) {
            messages.remove(index);
        } else {
            System.out.println("Invalid index. No message removed.");
        }
    }
}
