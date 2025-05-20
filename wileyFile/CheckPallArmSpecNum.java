import java.util.Scanner;

class NumberToBeCheckedModel {
	private int num;

	public NumberToBeCheckedModel() {
	}

	public NumberToBeCheckedModel(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

class PerformChecksService {
	private PerformChecksService() {

	}

	public static int reverseNum(int num) {
		int reverse = 0;
		while (num != 0) {
			int remainder = num % 10;
			reverse = reverse * 10 + remainder;
			num = num / 10;
		}
		return reverse;
	}

	public static boolean isPallindrome(int num) {
		return num == reverseNum(num);
	}

	static int cubify(int num) {
		return num * num * num;
	}

	public static boolean isArmstrong(int num) {
		int temp;
		int last = 0;
		int sum = 0;

		// int digits = 0;
		// temp = num;
		// while (temp > 0) {
		// temp = temp / 10;
		// digits++;
		// }

		temp = num;
		while (temp > 0) {
			last = temp % 10;
			// sum += (Math.pow(last, digits));
			sum += cubify(last);
			temp = temp / 10;
		}

		return num == sum;
	}

	static int factorial(int x) {
		int ans = 1;
		for (int i = 1; i <= x; i++) {
			ans = ans * i;
		}
		return ans;
	}

	public static boolean isSpecial(int num) {
		int lastDigit;
		int sumOfFact = 0;
		int temp = num;
		while (num > 0) {
			lastDigit = num % 10;
			sumOfFact += factorial(lastDigit);
			num = num / 10;
		}
		return temp == sumOfFact;
	}
}

class CheckNumberController {
	NumberToBeCheckedModel obj;

	CheckNumberController(NumberToBeCheckedModel obj) {
		this.obj = obj;
	}

	public void checkNumAndPrint() {
		int num = obj.getNum();
		boolean flag = false;

		if (PerformChecksService.isPallindrome(num)) {
			System.out.println("The number is pallindrome");
			flag = true;
		}

		if (PerformChecksService.isArmstrong(num)) {
			System.out.println("The number is armstrong");
			flag = true;
		}

		if (PerformChecksService.isSpecial(num)) {
			System.out.println("The number is special");
			flag = true;
		}

		if (!flag) {
			System.out.println("The reverse of " + num + " is " + PerformChecksService.reverseNum(num));
		}
	}
}

public class CheckPallArmSpecNum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a Number: ");
		int num = scan.nextInt();
		scan.close();

		NumberToBeCheckedModel numObj = new NumberToBeCheckedModel();
		numObj.setNum(num);

		CheckNumberController check = new CheckNumberController(numObj);
		check.checkNumAndPrint();
	}
}
