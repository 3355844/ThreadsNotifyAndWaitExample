public class Main {
    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        Customer customer = new Customer(producer);
        customer.start();
    }
}
