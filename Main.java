import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChoreScheduler scheduler = new ChoreScheduler();

        System.out.println("Enter roommate names (type 'done' when finished):");
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            scheduler.addRoommate(name);
        }

        System.out.println("Enter chore names and difficulty (type 'done' when finished):");
        while (true) {
            System.out.print("Enter chore name: ");
            String chore = scanner.nextLine();
            if (chore.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter difficulty (easy, medium, hard): ");
            String difficulty = scanner.nextLine();
            scheduler.addChore(chore, difficulty);
        }

        while (true) {
            System.out.println("\n--- Chore Scheduler Menu ---");
            System.out.println("1. Assign chores for the week");
            System.out.println("2. View all chores and status");
            System.out.println("3. Mark a chore as completed");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                scheduler.assignChores();
            } else if (choice == 2) {
                scheduler.viewChores();
            } else if (choice == 3) {
                scheduler.markChoreCompleted(scanner);
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                scanner.close();
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}