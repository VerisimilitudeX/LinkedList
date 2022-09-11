import java.util.Scanner;

public class List {
    private static Node[] list;
    static int start;
    private static int prevIndex;
    private static Node prevNode;

    public static void add(Integer num, int start, int whereToStore) {
        Node n = new Node();
        prevIndex = -1;
        prevNode = null;

        n.data = num;
        for (int i = start; i < list.length; i++) {
            if (list[i] != null) {
                prevNode = list[i];
                prevIndex = i;
            } else if (list[i] == null && i == whereToStore) {
                list[whereToStore] = n;
            } /*
               * else {
               * System.out.println("Previous Element" + );
               * }
               */
        }
    }

    public static void main(String[] args) throws InterruptedException {
        list = new Node[100];
        start = 2;

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