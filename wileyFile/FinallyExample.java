import java.io.IOException;

class ABC{
     void foo(int a) throws ArithmeticException,ArrayIndexOutOfBoundsException{
        System.out.println(5/a);
        try{
            throw new ArrayIndexOutOfBoundsException("Created Inside foo()");
        }catch(NullPointerException e){
            System.out.println("Inside foo() catch clause");
            throw e;
        }
    }

    void bar(int a) throws ArithmeticException,IOException,ArrayIndexOutOfBoundsException{
        try{ 
            foo(a);
            // throw new ArrayIndexOutOfBoundsException("Created Inside bar()");
        }catch(ArithmeticException e){
            System.out.println("Inside bar() 1st catch clause");
            throw e;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Inside bar() 2nd catch clause");
            throw e;
        }
        System.out.println("After bar() try block");

        try {
            throw new ArrayIndexOutOfBoundsException("Created Inside bar()");
        } catch (Exception e) {
            throw e;
        }
        //throw new IOException();
    }
}

public class FinallyExample {
    public static void main(String[] args) {
        ABC abc=new ABC();
        try{
            abc.bar(0);
          //abc.bar(0);
        }catch(Exception e){
            System.out.println("Inside main() catch clause");
            System.out.println("Exception object "+ e);
        }
        System.out.println("End of main()");
    }
}