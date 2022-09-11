import java.util.Scanner;

public class List {
    private static Node[] list;
    static int start;

    public static void add(Integer num, int start, int whereToStore) {
        Node n = new Node();
        n.data = num;
        list[whereToStore] = n;
    }

    public static void main(String[] args) throws InterruptedException {
        list = new Node[100];
        start = 2;

        // Get user input
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            for (int i = 0; i < 100; i++) {
                sc = new Scanner(System.in);
                System.out.println("Do you want to input another number? y/n");
                String yesno = sc.nextLine();
                if (yesno.equals("n")) {
                    running = false;
                    break;
                }
                System.out.println("\nEnter the next number: ");
                int input = Integer.parseInt(sc.nextLine());

                if (i != 0) {
                    System.out.println("Index: ");
                    int whereToStore = Integer.parseInt(sc.nextLine());
                    add(input, start, whereToStore);
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