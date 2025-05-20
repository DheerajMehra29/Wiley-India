interface Doable {
    void doSomething();

    interface AlsoDoable {
        void doSomething(int x);

        void doSomethingElse();
    }
}

class Implementor implements Doable, Doable.AlsoDoable {
    @Override
    public void doSomething() {
        System.out.println("Printing something on behalf of the outer interface");
    }

    @Override
    public void doSomething(int x) {
        System.out.println("Printing something on behalf of the inner interface");
    }

    @Override
    public void doSomethingElse() {
        System.out.println("Printing something else on behalf of the inner interface");
    }
}

public class NestedInterface {
    public static void main(String[] args) {
        Implementor i = new Implementor();
        i.doSomething();
        i.doSomething(5);
        i.doSomethingElse();
    }
}
