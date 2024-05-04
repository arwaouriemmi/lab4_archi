
public class riskManagement {
        private broker broker;

    public riskManagement(broker broker) {
        this.broker = broker;
    }

    public void treatRequest() {
        Thread receiveThread = new Thread(() -> {
            while (true) {
                String messages = broker.receive("Com-RM");
                if (messages != null) {
                    System.out.println("Risk Management: Received " + messages + " from Loan app. Starting processing...");
                    System.out.println("Risk Management: Requesting data from central bank...");
                    System.out.println("Risk Management: Calling OCR...");
                    System.out.println("OCR: Treating document...");
    
                    String msg = "RM Response: Ratio insufficient";
                    broker.send("Notif", msg);
                    broker.send("Notif", "Done");
    
                    break; 
                } else {
                    try {
                        Thread.sleep(3000); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    
        receiveThread.start();
    }
    }
