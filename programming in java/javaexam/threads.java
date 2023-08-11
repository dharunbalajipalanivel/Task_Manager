class A extends Thread {
public void run()
{
for(int i=0;i<10;i++)
System.out.println(“A class=”+i);
}
}

class B extends A {
public void run()
{
for(int i=0;i<10;i++)
System.out.println(“class B=”+i);
}
}

class threads {
    public static void main(String ar[]) {
        A a1 = new A();
        B b1 = new B();
        a1.start();
        b1.start();
    }
}
