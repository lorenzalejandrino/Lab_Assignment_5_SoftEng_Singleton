import java.util.Scanner;

public class QueueApp {
    public static void main(String[] args) {
        CentralizedQueue queue = CentralizedQueue.getInstance();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Pag-Ibig Queue ---\n");
            System.out.println("1. Get Next Queue Number");
            System.out.println("2. Reset Queue");
            System.out.println("3. Deactivate Queue System");
            System.out.println("4. Reactivate Queue System");
            System.out.println("5. View Current Queue Number");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int nextNumber = queue.getNextQueueNumber();
                    if (nextNumber != -1) {
                        System.out.println("Next Queue Number: " + nextNumber);
                    }
                    break;

                case 2:
                    System.out.print("Enter Reset Number: ");
                    int resetNumber = scanner.nextInt();
                    queue.resetQueue(resetNumber);
                    break;

                case 3:
                    queue.deactivateQueue();
                    break;

                case 4:
                    queue.reactiveQueue();
                    break;

                case 5:
                    System.out.println("Current Queue Number: " + queue.getCurrentQueueNumber());
                    break;

                case 6:
                    System.out.println("Shutting down.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
    }
}
