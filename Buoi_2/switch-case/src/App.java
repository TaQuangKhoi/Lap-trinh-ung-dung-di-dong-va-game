import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        char c;
        String str = JOptionPane.showInputDialog(null, "Nhap vao ky tu");
        c = str.charAt(0);
        switch(c)
        {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                System.out.println("Nguyen am");
            default:
                System.out.println("Phu am");
        }
        System.exit(0);
    }
}
