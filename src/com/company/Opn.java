package com.company;

import java.util.Stack;

/**
 * Класс для обработки входного выражения
 */
class Opn implements Not {


    @Override
    public String treatmentResult(String enterLine) {
        String resultLine;
        String[] strings = enterLine.split(" ");
        int countErrors1 = errorNumbers1(strings);
        int countErrors2 = errorOperations2(strings);

        if (countErrors1 != 0 & countErrors2 == 0) {
            double result = tеreatmentNewLine(strings);

            resultLine = String.valueOf(result);
            if (resultLine.equals("Infinity")) {
                resultLine = "Деление на ноль";
            }
        } else {

            resultLine = "Некорректный ввод";
        }
        return resultLine;
    }

    /**
     * Метод для отслеживания некорректного ввода операндов
     * @param enterLine массив подстрок входно строки
     * @return  счетчик ошибок
     */
    private int errorNumbers1(String[] enterLine) {

        int countErrors1 = 0;
        String operators = "*+-/";

        for (String value : enterLine) {
            if (operators.contains(value)) {
                countErrors1++;
            }
        }
        return countErrors1;
    }

    /**
     * метод для обработки операндов и занесния в стек
     * @param enterLine входная строка (исходное выражение)
     * @return  результат входного выражения
     */
    private double tеreatmentNewLine(String[] enterLine) {
        double result = 0.0;
        Stack<Double> stack = new Stack<>();
        for (String value : enterLine) {
            if (isNumber(value)) {
                stack.push(Double.parseDouble(value));
            } else {
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();
                switch (value) {
                    case "+" -> result = stack.push(tmp1 + tmp2);
                    case "-" -> result = stack.push(tmp2 - tmp1);
                    case "*" -> result = stack.push(tmp1 * tmp2);
                    case "/" -> result = stack.push(tmp2 / tmp1);
                }
            }
        }
        return result;
    }

    /**
     * Метод для отслеживания некрректного ввода операций
     * @param enterLine массив подстрок входно строки
     * @return  счетчик ошибок
     */
    private int errorOperations2(String[] enterLine) {
        int countErrors2 = 0;
        String operators = "*+-/";
        for (int i = 0; i < enterLine.length - 1; i++) {

            if (operators.contains(enterLine[i])) {
                if (operators.contains(enterLine[i + 1])) {
                    countErrors2++;
                }
            }
        }

        return countErrors2;
    }


    /**
     * метод для проверки , явлетсе ли элемент массива - числом. Если это число - возвращает true , если нет - false
     *
     * @param newNumber число , или оператор
     * @return код числа , или оператора
     */
    private boolean isNumber(String newNumber) {
        try {
            Double.parseDouble(newNumber);

            return true;

        } catch (NumberFormatException ex) {
            return false;
        }
    }
}





