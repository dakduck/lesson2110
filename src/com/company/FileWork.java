package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Класс для работы с файлами
 * @author Gurova Irina
 */
public class FileWork {

    /**
     * Функция получения кол-ва слов в файле
     * @param f Передаем файл для исследования
     * @return Возвращается ко-во слов в тексте, при оштбке вернет -1
     */
    public static int numOfWordsInAFile(File f) {
        int countWords = -1;
        try {
            Scanner fscan = new Scanner(f);
            countWords=0;
            while (fscan.hasNext()) {
                fscan.next();
                countWords++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file. Check the directory");
        }
        return countWords;
    }
}
