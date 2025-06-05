import java.util.ArrayList;
import java.util.Scanner;

public class ChoreScheduler {
    private ArrayList<Roommate> roommates;
    private ArrayList<Chore> chores;
    private int weekCounter;

    public ChoreScheduler() {
        roommates = new ArrayList<Roommate>();
        chores = new ArrayList<Chore>();
        weekCounter = 0;
    }

    public void addRoommate(String name) {
        roommates.add(new Roommate(name));
    }

    public void addChore(String name, String difficulty) {
        chores.add(new Chore(name, difficulty));
    }

    public void assignChores() {
        int[] workloads = new int[roommates.size()];

        System.out.println("\nChore assignments for Week " + (weekCounter + 1) + ":");

        for (Chore chore : chores) {
            int minIndex = 0;
            for (int i = 1; i < workloads.length; i++) {
                if (workloads[i] < workloads[minIndex]) {
                    minIndex = i;
                }
            }

            Roommate assigned = roommates.get(minIndex);
            chore.setAssignedTo(assigned.getName());
            workloads[minIndex] += chore.getPoints();

            System.out.println(assigned.getName() + " → " + chore.getName() + " (" + chore.getDifficulty() + ")");
        }

        weekCounter++;
    }

    public void viewChores() {
        System.out.println("\nCurrent Chore Status:");
        for (int i = 0; i < chores.size(); i++) {
            Chore c = chores.get(i);
            System.out.println((i + 1) + ". " + c.getName() + " (" + c.getDifficulty() + ") - " + c.getStatus() +
                    (c.getAssignedTo() != null ? " [Assigned to: " + c.getAssignedTo() + "]" : ""));
        }
    }

    public void markChoreCompleted(Scanner scanner) {
        while (true) {
            viewChores();
            System.out.print("Enter the number of a chore to mark as completed (or type 'done' to finish): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            boolean isNumber = true;
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) {
                    isNumber = false;
                }
            }

            if (isNumber) {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= chores.size()) {
                    Chore selected = chores.get(choice - 1);
                    if (!selected.isCompleted()) {
                        selected.markComplete();
                        System.out.println("Marked as complete: " + selected.getName());
                    } else {
                        System.out.println("That chore is already marked as complete.");
                    }
                } else {
                    System.out.println("Invalid number. Try again.");
                }
            } else {
                System.out.println("Please enter a valid number or 'done'.");
            }
        }
    }
}