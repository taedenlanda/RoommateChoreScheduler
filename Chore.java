public class Chore {
    private String name;
    private boolean completed;
    private String difficulty;
    private int points;
    private String assignedTo;

    public Chore(String name, String difficulty) {
        this.name = name;
        this.completed = false;
        this.difficulty = difficulty.toLowerCase();

        if (this.difficulty.equals("easy")) {
            this.points = 1;
        } else if (this.difficulty.equals("medium")) {
            this.points = 2;
        } else if (this.difficulty.equals("hard")) {
            this.points = 3;
        } else {
            this.points = 1;
            this.difficulty = "easy";
        }
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markComplete() {
        completed = true;
    }

    public String getStatus() {
        return completed ? "✓ done" : "✗ not done";
    }

    public int getPoints() {
        return points;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setAssignedTo(String name) {
        this.assignedTo = name;
    }

    public String getAssignedTo() {
        return assignedTo;
    }
}