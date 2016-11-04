package practiceJava;

/**
 * given a number, duplicate one digit in the number, make the result largest.
 * e.g. for 123, the result is 1233
 * Created by speng on 11/3/16.
 */
public class DuplicateADigit {
    public static void main(String[] args) {
        int[] inputs = new int[]{0, 1, 11, 123, 321, 123321, 12321, 32123,
                -1, -11, -123, -321, -123321, -12321, -32123};
        DuplicateADigit duplicateADigit = new DuplicateADigit();
        for (int num : inputs) {
            System.out.println(duplicateADigit.duplicateAdigit(num));
        }
    }

    int duplicateAdigit(int num) {
        if (Math.abs(num) < 10)
            return num * 11;
        int targetDight = -1;
        String absVal = Integer.toString(Math.abs(num));
        int flag = num > 0 ? 1 : -1;
        for (int i = 0; i < absVal.length() - 1; i++) {
            if ((absVal.charAt(i + 1) - absVal.charAt(i)) * flag < 0) {
                targetDight = i;
                break;
            }
        }
        if (targetDight == -1)
            targetDight = absVal.length() - 1;
        StringBuilder sb = new StringBuilder(absVal);
        sb.insert(targetDight, absVal.charAt(targetDight));
        return flag * Integer.valueOf(sb.toString());
    }
}
