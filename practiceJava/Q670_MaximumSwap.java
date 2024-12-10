public class Q670_MaximumSwap {
    public int maximumSwap(int num) {
        if (num < 12) {
            return num;
        }
        String numString = Integer.toString(num);
        char[] chars = numString.toCharArray(); // is there such a method?
        int[] maxDigitIndices = new int[chars.length];
        int maxDigitIndex = chars.length - 1; // chars has at leat two digits
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > chars[maxDigitIndex]) {
                maxDigitIndex = i;
            }
            maxDigitIndices[i] = maxDigitIndex;
        }
        for (int i = 0; i < chars.length; i++) {
            int currMaxDigitIndex = maxDigitIndices[i];
            if (chars[i] < chars[currMaxDigitIndex]) {
                char tmp = chars[i];
                chars[i] = chars[currMaxDigitIndex];
                chars[currMaxDigitIndex] = tmp;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(chars);
        return Integer.valueOf(sb.toString());
    }
}
