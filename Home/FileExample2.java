package Home;

import java.io.File;


public class FileExample2 {
    public static void main(String[] args) {
        // Создаем объект File для работы с файлом
        File file = new File("example.txt");

        // Проверяем, существует ли файл
        if (file.exists()) {
            System.out.println("Файл существует.");
            System.out.println("Путь к файлу: " + file.getAbsolutePath());
            System.out.println("Размер файла: " + file.length() + " байт");
        } else {
            System.out.println("Файл не существует.");
        }
    }
}

