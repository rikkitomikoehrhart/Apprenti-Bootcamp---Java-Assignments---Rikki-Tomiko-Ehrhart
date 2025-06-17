package org.example;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (!numbers.contains(",") && (!numbers.contains("\n"))){
            return Integer.parseInt(numbers);
        } else {
            String[] nums;
            String delimiter = "";
            if (numbers.startsWith("//")) {
                String[] splitNumbers = numbers.split("\n");
                delimiter = processDelimiter(splitNumbers[0]);
                numbers = splitNumbers[1];
            }

            nums = numbers.split(",|;|\\n" + delimiter);
            return getSum(nums);
        }
    }

    private String processDelimiter(String delimiter) {
        if (delimiter.startsWith("//[")) {
            if (delimiter.contains("][")) {
                delimiter = delimiter.substring(3, delimiter.length() - 1);
                String[] delimiterList = delimiter.split("\\]\\[");
                delimiter = "";

                for (int i = 0; i < delimiterList.length; i++) {
                    delimiter += returnRegExDelimiter(delimiterList[i]);
                }
            } else {
                delimiter = returnRegExDelimiter(delimiter.substring(3, delimiter.length()-1));
            }
        } else {
            delimiter = returnRegExDelimiter(delimiter.substring(2));
        }
        return delimiter;
    }


    private String returnRegExDelimiter(String delimiter) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < delimiter.length(); i++) {
            if (i < delimiter.length()) {
                temp.append("\\");
            }
            temp.append(delimiter.charAt(i));
        }
        return "|" + temp.toString();
    }


    private int getSum(String[] nums) {
        int sum = 0;
        String negatives = "";

        for (String num : nums) {
            if (num.startsWith("-")) {
                negatives += num + " ";
            } else if (!num.isEmpty()){
                int intNum = Integer.parseInt(num);
                sum += intNum > 1000 ? 0 : intNum;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
        return sum;
    }
}
