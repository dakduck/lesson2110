package com.company;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Класс для тестирования работы класса FileWork
 * @see FileWork
 * @author Gurova Irina
 */
public class FileWorkTest {

    /**
     * Тест для проверки файла из одного слова
     * @throws IOException
     */
    @Test
    public void numOfWordsInAFile1() throws IOException {
        //имя файла
        String fileName = "text.txt";
        Path f = Paths.get(fileName);
        // запись в файл какого-то текста
        Files.write(f, Arrays.asList("Hello"), StandardCharsets.UTF_8);
        // значение, полученное выполнением функции
        int actual = FileWork.numOfWordsInAFile(new File(fileName));
        // ожидаемое значения для файла, состоящего из одного слова
        int expected = 1;
        // сравнение значений
        assertEquals(expected, actual);
        // вывод ответа на экран пользователя
        System.out.println("Test 1. Number of words = " + actual);
    }

    /**
     * Тест для проверки файла со знаками препинания с использованием try-with-resources
     */
    @Test
    public void numOfWordsInAFile2() {
        String str = "Hello\nMy na!me is Comp\nBye?";
        String fileName = "text.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int actual = FileWork.numOfWordsInAFile(new File(fileName));
        int expected = 6;
        assertEquals(expected, actual);
        System.out.println("Test 2. Number of words = " + actual);
    }

    /**
     * Тест для проверки файла с большим кол-вом пробелов
     */
    @Test
    public void numOfWordsInAFile3() {
        String fileName = "text.txt";
        Path f = Paths.get(fileName);
        try {
            Files.write(f, Arrays.asList("I   have many    whitespaces"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int actual = FileWork.numOfWordsInAFile(new File(fileName));
        int expected = 4;
        assertEquals(expected, actual);
        System.out.println("Test 3. Number of words = " + actual);
    }

    /**
     * Тест для проверки файла со знаками препинания
     */
    @Test
    public void numOfWordsInAFile4() {
        String fileName = "text.txt";
        Path f = Paths.get(fileName);
        try {
            Files.write(f, Arrays.asList("I - Claude, you:\nWho are u?"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int actual = FileWork.numOfWordsInAFile(new File(fileName));
        int expected = 7;
        assertEquals(expected, actual);
        System.out.println("Test 4. Number of words = " + actual);
    }

    /**
     * Тест для проверки работы программы, если данного файла не существует
     */
    @Test
    public void numOfWordsInAFile5() {
        String fileName = "text.txt";
        Path f = Paths.get(fileName);
        try {
            Files.write(f, Arrays.asList("Wrong file name"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int actual = FileWork.numOfWordsInAFile(new File("abc.txt"));
        int expected = -1;
        assertEquals(expected, actual);
        System.out.println("Test 5. Number of words = " + actual);
    }

    /**
     * Тест для проверки работы программы, если файл находится не в дериктории проекта.
     * Для этого создайте пустой файл и в переменную fileName запишите его расположение
     */
    @Test
    public void numOfWordsInAFile6() {
        String fileName = "F:\\test.txt";
        Path f = Paths.get(fileName);
        try {
            Files.write(f, Arrays.asList("This has to have at least 15 words in it\nbut im so lazy to write that much!\nsee? you did it"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int actual = FileWork.numOfWordsInAFile(new File(fileName));
        int expected = 22;
        assertEquals(expected, actual);
        System.out.println("Test 6. Number of words = " + actual);
    }
}