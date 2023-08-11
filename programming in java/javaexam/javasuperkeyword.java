class a{
	void bark() {
		System.out.println("barking");
	}
}

class b extends a{
	void eat() {
		System.out.println("eating");
	}
	void work() {
		eat();
		super.bark();
	}
}
public class javasuperkeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi kk");
		b ab=new b();
		ab.work();
	}

}
