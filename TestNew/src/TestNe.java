
public class TestNe {
	private int number = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestNe tn = new TestNe();
		TestNe tn2 = tn;
		tn2.Them();
		tn.Them();
		
		System.out.println(tn2.number);
		System.out.print(tn.number);
	}
	public void Print() {
		int number2 = 30;
		System.out.print(number2);
		this.number = 20;
		System.out.print(this.number);
	}
	
	public void Them() {
		number += number + 1;
	}
}
