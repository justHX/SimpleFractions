package ru.nikita.fractions;

public class Fractions {
    public int whole;
    public int numerator;
    public int denominator;

    public Fractions(int whole, int numerator, int denominator) {
        this.whole = whole;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fractions(String expression) {
        expression = expression.replace(' ', '/');
        String[] type = expression.split("/");
        this.whole = Integer.parseInt(type[0]);
        this.numerator = Integer.parseInt(type[1]);
        this.denominator = Integer.parseInt(type[2]);
    }

    public Fractions(double dotNumber) {
        this.whole = (int)dotNumber;
        dotNumber %= 1;
        int divisor = 1;
        while (dotNumber % 1 != 0) {
            dotNumber*=10;
            divisor*=10;
        }
        this.numerator = (int)dotNumber;
        this.denominator = divisor;
    }

    private static String dotFormat(double d) {
        String type = String.valueOf(d);
        String[] arr = type.split("\\.");
        String answer = arr[0] + "/" + arr[1] + "/1";
        for (char c : arr[1].toCharArray()) {
            answer += "0";
        }
        return answer;
    }


    @Override
    public String toString() {
        return whole + " " + numerator + "/" + denominator;
    }
}
