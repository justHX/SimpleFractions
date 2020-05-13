package ru.nikita.fractions;

import ru.nikita.fractions.Fractions;

public class SimpleFractions {
    /**
     * @param a первая дробь
     * @param b вторая дробь
     * @return сумма дробей
     */
    public static Fractions amount(Fractions a, Fractions b) {
        //переводим в неправильную дробь
        a.numerator = a.denominator * a.whole + a.numerator;
        b.numerator = b.denominator * b.whole + b.numerator;
        //приводим к НОК
        if (a.denominator != b.denominator) {
            int type = nok(a.denominator, b.denominator);
            a.numerator = a.numerator * (type / a.denominator);
            b.numerator = b.numerator * (type / b.denominator);
            a.denominator = type;
            b.denominator = type;
        }
        return new Fractions(0, a.numerator + b.numerator, a.denominator);
    }

    /**
     * @param a первая дробь
     * @param b вторая дробь
     * @return разность дробей
     */
    public static Fractions difference(Fractions a, Fractions b) {
        a.numerator = a.denominator * a.whole + a.numerator;
        b.numerator = b.denominator * b.whole + b.numerator;
        if (a.denominator != b.denominator) {
            int type = nok(a.denominator, b.denominator);
            a.numerator = a.numerator * (type / a.denominator);
            b.numerator = b.numerator * (type / b.denominator);
            a.denominator = type;
            b.denominator = type;
        }
        return new Fractions(0, a.numerator - b.numerator, a.denominator);
    }

    /**
     * @param a первая дробь
     * @param b вторая дробь
     * @return произведение дробей
     */
    public static Fractions multiplication(Fractions a, Fractions b) {
        int typeA = a.denominator * a.whole + a.numerator;
        int typeB = b.denominator * b.whole + b.numerator;
        return new Fractions(0, typeA * typeB, a.denominator * b.denominator);
    }

    /**
     * @param a первая дробь
     * @param b вторая дробь
     * @return частное дробей
     */
    public static Fractions division(Fractions a, Fractions b) {
        int typeA = a.denominator * a.whole + a.numerator;
        int typeB = b.denominator * b.whole + b.numerator;
        return new Fractions(0, a.numerator * b.denominator, a.denominator * b.numerator);
    }

    /**
     * @return наибольший общий делитель
     */
    private static int nod(int a, int b) {
        return b == 0 ? a : nod(b, a % b);
    }

    /**
     * @return наименьшее общее кратное
     */
    private static int nok(int a, int b) {
        return a / nod(a, b) * b;
    }


}
