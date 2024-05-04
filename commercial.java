public class commercial {
    private broker broker;

    public commercial(broker broker) {
        this.broker = broker;
    }


    public void treatRequest() {
        Thread receiveThread = new Thread(() -> {
        String messages;
    while ((messages = broker.receive("Front-Com")) == null) {
        // Wait until messages are available
    }  
    System.out.println("Commercial : Received " + messages + "from Loan app. Starting processing...");      
    
    System.out.println("OCR: trating document...");
    String msg = "Commercial Response : Borrower is eligible, score : 8";

    broker.send("Com-RM", msg);
    broker.send("Notif", "Borrower is eligible");
    });
    receiveThread.start();
}}
