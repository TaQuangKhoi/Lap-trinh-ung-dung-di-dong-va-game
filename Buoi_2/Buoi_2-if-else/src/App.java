import java.util.Date;
public class App {
    public static void main(String[] args) {
        Date today = new Date();
        if (today.getDay() == 0)
        // CHu nhay = 0, Mon 1, Tue 2
        {
            System.out.println("Hom nay la chu nhat:" );
        } else
            System.out.println("Hello, World!");
    }
}
