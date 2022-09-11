import java.util.Scanner;

public class List {
    private static Node[] list;
    static int start;
    private static int prevIndex;
    private static Node prevNode;
    private static int nextIndex;
    private static Node nextNode;

    public static void add(Integer num, int start, int whereToStore) {
        // Initialize Node, and previous index and node
        Node n = new Node();
        prevIndex = -1;
        prevNode = null;
        nextIndex = -1;
        nextNode = null;

        // Set the data of the node to number the user inputted
        n.data = num;

        // Loop through the Nodes in the list of Nodes
        for (int i = start; i < list.length; i++) {

            // If there is no value in the current node
            if (list[i] != null) {

                // Set the previous node and index
                // This value dynamically changes until it finds the node that is null and the
                // user inputted index
                prevNode = list[i];
                prevIndex = i;

                // If the node doesn't have a value set and is the index the user wants to store
                // it in
            } else if (list[i] == null && i == whereToStore) {

                // Set the node to the node with the value the user inputted
                list[whereToStore] = n;

                // If the currrent node isn't the first
                if (prevNode != null) {

                    // Link the previous nodes pointer to the current node's lcoation in the list
                    prevNode.nextLocation = i;
                    list[i].previousLocation = prevIndex;
                }
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        list = new Node[100];
        start = 0;

        // Get user input
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            for (int i = 0; i < 100; i++) {
                System.out.println("\nEnter the next number: ");
                int input = Integer.parseInt(sc.nextLine());

                if (i != 0) {
                    sc = new Scanner(System.in);
                    System.out.println("Do you want to input another number? y/n");
                    String yesno = sc.nextLine();
                    if (yesno.equals("n")) {
                        running = false;
                        break;
                    }
                    System.out.println("Index: ");
                    int whereToStore = Integer.parseInt(sc.nextLine());
                    add(input, start, whereToStore);
                    System.out.println("Previous index: " + prevIndex + ", Previous Value: " + prevNode.data);
                    System.out.println("Next index: " + prevNode.nextLocation);
                    if (nextNode != null) {
                        System.out.println("Previous index: " + nextNode.previousLocation);
                    }
                } else {
                    add(input, start, start);
                }
            }
        }
        sc.close();

        for (int i = 0; i < 100; i++) {
            System.out.println();
            Thread.sleep(5);
        }

        // Print all values in the list
        for (int j = start; j < list.length; j++) {
            if (list[j] != null) {
                System.out.println(j + ": " + list[j].data);
            }
        }
    }
}