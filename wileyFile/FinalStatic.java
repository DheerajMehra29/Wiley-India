import java.util.Scanner;

class BankAccount {
    static int phoneNo;
    static final String ifsc;

    BankAccount() {
        phoneNo = 758457;
    }

    @Override
    public String toString() {
        System.out.println(phoneNo);
        System.out.println(ifsc);
        return super.toString();
    }

    static {
        Scanner scanner = new Scanner(System.in);

        ifsc = scanner.nextLine();

        scanner.close();
    }
}

public class FinalStatic {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        System.out.println(b1);

        BankAccount b2 = new BankAccount();
        System.out.println(b2);

        b2.phoneNo = 12345;

        System.out.println("After changing...");
        System.out.println(b1);
    }
}
