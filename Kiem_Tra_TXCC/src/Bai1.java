import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class Bai1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap xau: ");
		String bien_nhap_vao = sc.nextLine();
		
		System.out.println("So ky tu cua xau: " + bien_nhap_vao.length());
		System.out.println("So ky tu chu so cua xau: " + DemCacSo(bien_nhap_vao));
		
		sc.close();
	}
	
	
	
	static int DemCacSo(String xau) {
		int dem = 0;
		for(int i=0; i < xau.length(); i++) {
			Boolean dung_khong = Character.isDigit(xau.charAt(i));
	         if(dung_khong) {
	            dem++;
	         }
		}
		return dem;
	}
}
