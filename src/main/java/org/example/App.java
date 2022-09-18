package org.example;

import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {
    private static final String[] unitsDigitWord = new String[]{"Zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"};
    private static final String[] tensDigitWord = new String[]{"Ten", "Twenty", "Thirty", "Forty", "Fifty"};

    public static void main(String[] args) {
        try {
            System.out.println(timeToWord(args[0]));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static String timeToWord(String time) {
        String timeToWord = "It's ";
        if (time.equals("00:00")) {
            timeToWord += "Midnight";
        } else if (time.equals("12:00")) {
            timeToWord += "Midday";
        } else if (time.length() == 5 && Pattern.matches("\\d\\d:\\d\\d", time)) {
            String[] hourMinute = time.split(":");
            String hourInWord = hourToWord(hourMinute[0]);
            String minuteToWord = minuteToWord(hourMinute[1]);
            timeToWord += hourInWord + " " + minuteToWord;
        } else {
            throw new IllegalArgumentException("Please enter time format as specified:- HH:mm");
        }
        return timeToWord;
    }

    private static String minuteToWord(String number) {
        String numberToWord = "";
        if (number.length() == 2) {

            int unitsDigit = Integer.parseInt(number.split("")[1]);
            int tensDigit = Integer.parseInt(number.split("")[0]);
            switch (tensDigit) {
                case 0:
                    numberToWord = unitsDigit == 0 ? "o' clock" : unitsDigitWord[unitsDigit];
                    break;
                case 1:
                    switch (unitsDigit) {
                        case 0:
                            numberToWord = tensDigitWord[tensDigit - 1];
                            break;
                        case 1:
                            numberToWord = "Eleven";
                            break;
                        case 2:
                            numberToWord = "Twelve";
                            break;
                        case 3:
                            numberToWord = "Thirteen";
                            break;
                        case 5:
                            numberToWord = "Fifteen";
                            break;
                        default:
                            numberToWord = unitsDigitWord[unitsDigit] + "teen";
                            break;
                    }
                    break;
                default:
                    numberToWord = tensDigitWord[tensDigit - 1];
                    if (unitsDigit > 0) {
                        numberToWord = numberToWord + " " + unitsDigitWord[unitsDigit];
                    }
            }
        }
        return numberToWord;
    }

    private static String hourToWord(String number) {
        String numberToWord = "";
        if (number.length() == 2) {
            int unitsDigit = Integer.parseInt(number.split("")[1]);
            int tensDigit = Integer.parseInt(number.split("")[0]);
            switch (tensDigit) {
                case 0:
                    numberToWord = unitsDigitWord[unitsDigit];
                    break;
                case 1:
                    switch (unitsDigit) {
                        case 0:
                            numberToWord = tensDigitWord[tensDigit - 1];
                            break;
                        case 1:
                            numberToWord = "Eleven";
                            break;
                        case 2:
                            numberToWord = "Twelve";
                            break;
                        case 3:
                            numberToWord = "Thirteen";
                            break;
                        case 5:
                            numberToWord = "Fifteen";
                            break;
                        default:
                            numberToWord = unitsDigitWord[unitsDigit] + "teen";
                            break;
                    }
                    break;
                default:
                    numberToWord = tensDigitWord[tensDigit - 1];
                    if (unitsDigit > 0) {
                        numberToWord = numberToWord + unitsDigitWord[unitsDigit];
                    }
            }
        }
        return numberToWord;
    }
}
