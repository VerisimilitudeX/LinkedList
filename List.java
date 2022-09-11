import java.util.Scanner;

public class List {
    private static Node[] list;
    static int start;

    public static void add(Integer num, int start) {
        Node n = new Node();
        n.data = num;
        boolean first = true;
        for (int i = start; i < list.length; i++) {
            if (list[i] == null && first) {
                list[i] = n;
                first = false;
            }
        }
    }

    public static void main(String[] args) {
        list = new Node[10];
        start = 2;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter the next number: ");
            int input = Integer.parseInt(sc.nextLine());
            add(input, start);
            for (int j = start; j < list.length; j++) {
                if (list[j] != null) {
                    System.out.println(j + ":" + list[j].data);
                }
            }
        }
        sc.close();
    }
}