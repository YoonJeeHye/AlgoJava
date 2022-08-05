package week1_이상원;

import java.util.Arrays;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    answer[i] += 1;
                } else {
                    answer[i] += 1;
                    break;
                }
            }
        }
//        return answer;
//        return Arrays.toString(answer);
    }
}
