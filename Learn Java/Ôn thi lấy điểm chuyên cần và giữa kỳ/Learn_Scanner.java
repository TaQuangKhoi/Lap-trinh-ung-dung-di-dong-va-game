import java.util.Scanner;

public class Learn_Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scInt;
        String scStr;

        System.out.print("Nhập số");
        scInt = sc.nextInt();sc.nextLine();
        System.out.print("Nhập chữ");
        scStr = sc.nextLine();

        System.out.print(scInt);
        System.out.print(scStr);
        sc.close();
    }
}
