import java.io.*;
public class InputChar {
    public static void main(String[] args) {
        char ch = ' ';
        try{
            ch = (char) System.in.read();
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Ky tu vau nhap: " + ch);
        }
    }
}
