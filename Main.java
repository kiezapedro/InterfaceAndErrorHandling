interface MyInterface {
    // compiler will treat them as:
    // public abstract void method1();
    // public abstract void method2();
    public void method1();

    public void method2();
}

class Main implements MyInterface {
    // this class must have to implement both the abstract methods
    // else you will get compilation error
    // try removing one method and see the error
    public void method1() {
        System.out.println("implementation of method");
    }

    public void method2() {
        System.out.println("implementation of method");
    }

    public static void main(String[] args) {
        MyInterface obj = new Main();
        obj.method1();
        obj.method2();
    }
}