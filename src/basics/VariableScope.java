package basics;

public class VariableScope {

    static int x = 5; // CLASS Variable

    public static void main(String[] args) {
        // Local Variable, Inaccessible outside main.
        int x = 10; // LOCAL
        System.out.println("Local Variable: " + x);
        System.out.println("Class Variable: " + VariableScope.x);
        doSomething();
    }

    static void doSomething() {
        int x = 20; // LOCAL
        System.out.println("Local Variable doSomething: " + x);
    }
}
