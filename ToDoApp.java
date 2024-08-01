import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the To-Do List Application!");
        System.out.println("Commands: add [task], remove [index], complete [index], list, exit");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (command.startsWith("add ")) {
                String taskName = command.substring(4);
                toDoList.addTask(taskName);
                System.out.println("Task added: " + taskName);
            } else if (command.startsWith("remove ")) {
                try {
                    int index = Integer.parseInt(command.substring(7));
                    toDoList.removeTask(index);
                    System.out.println("Task removed at index: " + index);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index.");
                }
            } else if (command.startsWith("complete ")) {
                try {
                    int index = Integer.parseInt(command.substring(9));
                    toDoList.completeTask(index);
                    System.out.println("Task marked as completed at index: " + index);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index.");
                }
            } else if (command.equalsIgnoreCase("list")) {
                toDoList.listTasks();
            } else {
                System.out.println("Unknown command.");
            }
        }

        scanner.close();
    }
}
