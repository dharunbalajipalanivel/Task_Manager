class stu {
    int id;
    String name;

    stu(int id, String name) {
        this.id = id;
        this.name = name;
        // id = id;
        // name = name;
        System.out.println(id + name);
    }

    void display() {
        System.out.println(id + name);
    }
}

class thisi {
    public static void main(String[] args) {
        stu a = new stu(12, "kk");
        a.display();
    }
}