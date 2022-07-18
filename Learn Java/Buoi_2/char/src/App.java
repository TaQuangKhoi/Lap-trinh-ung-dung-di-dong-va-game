import java.lang.*; // to use Math.min()
import java.io.*;

public class App {
    static int x, y;
    public static void main(String[] args) throws Exception {
        x = 10;
        y = 20;
        int z = x + y;
        System.out.println("x =" + x);
        System.out.println("y =" + y);
        System.out.println("z = x + y =" + z);
        System.out.println("Số nhỏ hơn là số:" + Math.min(x,y));
        char c = 80;
        System.out.println("Ky tu c la: " + c);
    }
}