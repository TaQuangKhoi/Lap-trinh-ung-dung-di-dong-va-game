import java.util.Scanner;

public class Bai2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinhVien sv1 = new SinhVien();
		sv1.NhapThongTin();
		sv1.XuatThongTin();
	}

}

class SinhVien{
	String ma_sinh_vien;
	String ho_ten;
	float diem_ly_thuyet;
	float diem_thuc_hanh;
	
	void NhapThongTin()
	{
		Scanner nhap_thong_tin = new Scanner(System.in);
		
		System.out.println("Nhap mã sinh vien: ");
		this.ma_sinh_vien = nhap_thong_tin.nextLine();
		
		System.out.println("Nhap họ tên sinh vien: ");
		this.ho_ten = nhap_thong_tin.nextLine();
		
		System.out.println("Nhap diem lý thuyết: ");
		this.diem_ly_thuyet = nhap_thong_tin.nextFloat(); nhap_thong_tin.nextLine();
		
		System.out.println("Nhap diem thực hành: ");
		this.diem_thuc_hanh = nhap_thong_tin.nextFloat();
		
		nhap_thong_tin.close();
	}
	
	float DiemTB() {
		return (this.diem_ly_thuyet + this.diem_thuc_hanh)/2;
	}
	
	void XuatThongTin() {
		System.out.println("Ma sinh vien la: " + this.ma_sinh_vien);
		System.out.println("Ten sinh vien la: " + this.ho_ten);
		System.out.println("Diem ly thuyet la: " + this.diem_ly_thuyet);
		System.out.println("Diem thuc hanh la: " + this.diem_thuc_hanh);
		System.out.println("Diem trung binh la: " + this.DiemTB());
		if (this.DiemTB() >= 5){
			System.out.println("Sinh vien Dau");
		}
		else
		{
			System.out.println("Sinh vien Rot");
		}
	}
}