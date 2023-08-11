class Animal {
    Animal() {
        System.out.println("animal is created");
    }
}

class b {
    b() {
        System.out.println("multiple inheritance");
    }
}

class Dog extends Animal {
    Dog() {
        super();
        System.out.println("dog is created");
    }
}

class TestSuper3 {
    public static void main(String args[]) {
        Dog d = new Dog();
    }
}