public class notif {
    private broker broker;

    public notif(broker broker) {
        this.broker = broker;
    }

 public void receive(){


        Thread receiveThread = new Thread(() -> {
            String messages = null;
             String[] topicsToCheck = {"Notif", "Com-RM"};
            while (true) {
                for (String topicName : topicsToCheck) {
                    while ((messages = broker.receive(topicName)) == null) {
                    }
                    if (messages != "Done")
                    System.out.println("Notif: received message " + messages);
                    broker.send(topicName, messages);
                }
  

           
            }
        });

        receiveThread.start(); 
 }

}



