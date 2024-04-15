import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }
    
    public int size(){
        return this.tasks.size();
    }
    
    public void addTask(String taskName) {
        Task newTask = new Task(taskName);
        tasks.add(newTask);
        System.out.println("Task added.");
    }

    public void removeTask(int taskNumber) {
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task '" + removedTask.getName() + "' removed.");
        } else {
            System.out.println("Invalid task number. No tasks removed.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to list.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).getName());
            }
        }
    }
}

public class TaskListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();

        while (true) {
            System.out.println("\nTask List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Quit");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("\nEnter task name: ");
                    String taskName = scanner.nextLine();
                    taskList.addTask(taskName);
                    break;
                case 2:
                    if(taskList.size() != 0){
                        taskList.listTasks();
                        System.out.print("\nEnter the task number to remove: ");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine();
                        taskList.removeTask(taskNumber);
                    }
                    else{
                        System.out.println("No tasks to remove.");
                    }
                    break;
                case 3:
                    taskList.listTasks();
                    break;
                case 4:
                    System.out.println("\nExiting Task List Application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.");
            }
        }
    }
}
