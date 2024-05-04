public class front{
    private broker broker;

    public front(broker broker) {
        this.broker = broker;
    }

 public void receive(String msgs){
        System.out.println("Loan application is receiving your documents");
        this.broker.send("Front-Com", msgs);
        System.out.println("Loan application is processing your request ...");

        Thread receiveThread = new Thread(() -> {
            String messages;
            while (true) {
                while ((messages = broker.receive("Notif-App")) == null) {
                }

                if (!messages.equals("Done")) {
                    System.out.println("Loan Application: Received  a Notif: " + messages);
                } else {
                    break;
                }
            }
        });

        receiveThread.start(); 
 }

public static void main(String[] args) {
    broker broker =  new broker();

    new front(broker).receive("{Client Documents}"); 
    new commercial(broker).treatRequest();
    new riskManagement(broker).treatRequest();
    new notif(broker).receive();
}
}