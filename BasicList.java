import java.util.Scanner;

public class BasicList {
    private static Integer[] list;
    static int start;

    public static void add(Integer num, int start) {
        boolean first = true;
        for (int i = start; i < list.length; i++) {
            if (list[i] == null && first) {
                list[i] = num;
                first = false;
            }
        }
    }

    public static void main(String[] args) {
        list = new Integer[10];
        start = 2;
        for (Integer num : list) {
            num = null;
        }

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter the next number: ");
            int input = Integer.parseInt(sc.nextLine());
            add(input, start);
            for (int j = start; j < list.length; j++) {
                if (j == list.length - 1) {
                    System.out.print(j + ":" + list[j]);
                } else {
                    System.out.print(j + ":" + list[j] + ", ");
                }
            }
        }
        sc.close();
    }
}