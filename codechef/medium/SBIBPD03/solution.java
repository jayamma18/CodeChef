import java.util.ArrayList;

class Codechef {
    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();

        // Add items
        todoList.add("Grocery Shopping");
        todoList.add("Laundry");
        todoList.add("Pay Bills");

        // Print initial list
        System.out.println("To-Do List:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + ": " + todoList.get(i));
        }

        // Remove item at index 1
        todoList.remove(1);

        // Print updated list
        System.out.println();
        System.out.println("Updated To-Do List:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + ": " + todoList.get(i));
        }
    }
}