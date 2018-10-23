import java.util.ArrayList;
import java.util.Date;

public class Producer extends Thread {
    ArrayList<String> messages = new ArrayList<>();

    @Override
    public void run() {
        try {
            while (true) {
                putMessage();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void putMessage() throws InterruptedException {
        while (messages.size() == 5) {
            wait(500);
            System.out.println("wait put");
        }
        messages.add(new Date().toString());
        System.out.println("put Message");
        notify();
    }

    public synchronized String getMessages() throws InterruptedException {
        notify(); // wake up thread
        while (messages.size()== 0){
            wait(500); // sleep....
            System.out.println("Wait get");
        }
        String message = messages.get(0);
        messages.remove(message);
        return message;
    }

}
