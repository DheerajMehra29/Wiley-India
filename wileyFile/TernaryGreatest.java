class AccountDAO {
    private int accNum;
    private int custId;
    private int ifsc;

    AccountDAO() {

    }

    AccountDAO(int accNum, int custId, int ifsc) {
        this.accNum = accNum;
        this.custId = custId;
        this.ifsc = ifsc;
    }

    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getIfsc() {
        return ifsc;
    }

    public void setIfsc(int ifsc) {
        this.ifsc = ifsc;
    }
}

class FindGreatestModel {
    public static int compare(AccountDAO acc) {
        int greatest;

        int greater = (acc.getAccNum() > acc.getCustId()) ? acc.getAccNum() : acc.getCustId();
        greatest = (greater > acc.getIfsc()) ? greater : acc.getIfsc();

        // greatest = (acc.getAccNum() > acc.getCustId())
        // ? (acc.getAccNum() > acc.getIfsc() ? acc.getAccNum() : acc.getIfsc())
        // : (acc.getCustId() > acc.getIfsc() ? acc.getCustId() : acc.getIfsc());

        return greatest;
    }
}

public class TernaryGreatest {
    public static void main(String[] args) {
        AccountDAO acc = new AccountDAO(100, 70, 11123);

        System.out.println("Greatest number is " + FindGreatestModel.compare(acc));
    }
}
