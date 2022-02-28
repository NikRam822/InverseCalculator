package com.company;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Класс для тестирования программы
 */
class NotationTest {
    /**
     * Тест кореектного ввода строки
     */
    @Test
    void Correct1() {
        Opn natation = new Opn();


        String Actual = natation.treatmentResult("12 13 +");
        String Expected = String.valueOf(25.0);
        assertEquals(Expected, Actual);

    }

    /**
     * Тест кореектного ввода строки
     */
    @Test
    void Correct2() {
        Opn natation = new Opn();


        String Actual = natation.treatmentResult("12 13 + 5 *");
        String Expected = String.valueOf(125.0);
        assertEquals(Expected, Actual);

    }

    /**
     * Тест некореектного ввода строки
     */
    @Test
    void Incorrect1() {
        Opn natation = new Opn();


        String Actual = natation.treatmentResult("1234 + 45 + + * 2");
        String Expected = "Некорректный ввод";
        assertEquals(Expected, Actual);
    }

    /**
     * Тест некореектного ввода строки
     */
    @Test
    void Incorrect2() {
        Opn natation = new Opn();


        String Actual = natation.treatmentResult("12 + + 13 34 443");
        String Expected = "Некорректный ввод";
        assertEquals(Expected, Actual);
    }

    /**
     * Тест некореектного ввода строки
     */
    @Test
    void Incorrect3() {
        Opn natation = new Opn();


        String Actual = natation.treatmentResult("12 13 1342");
        String Expected = "Некорректный ввод";
        assertEquals(Expected, Actual);
    }

    /**
     * Тест строки деления на ноль
     */
    @Test
    void TryToDel0() {
        Opn natation = new Opn();


        String actual = natation.treatmentResult("12 0 /");
        String expected = "Деление на ноль";
        assertEquals(expected, actual);
    }

    /**
     * Тест некореектного ввода строки
     */
    @Test
    void Incorrect4() {
        Opn natation = new Opn();


        String Actual = natation.treatmentResult("hgnof");
        String Expected = "Некорректный ввод";
        assertEquals(Expected, Actual);
    }
}