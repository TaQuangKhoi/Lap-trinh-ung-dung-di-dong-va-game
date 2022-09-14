import java.io.*;
public class TestInput
{
    public static void main(String[] args) throws Exception{
        BufferedReader inStream
        = new BufferedReader(
            new InputStreamReader(System.in)
        );
        System.out.print("Nhap so nguyen:");
        String siNumber = inStream.readLine();
        int iNumber = Integer.parseInt(siNumber);

        System.out.print("Nhap so thuc:");
        String sfNumber = inStream.readLine();
        float fNumber = Float.parseFloat(sfNumber);

        System.out.println("So nguyen: " + iNumber);
        System.out.println("So thuc: " + fNumber);

    }
}