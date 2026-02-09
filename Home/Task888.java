package Home;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task888 {
    //Есть входные данные формат строки: Вид лога, [Имя потока], Текст лога.
//Посчитать сколько каждого вида логов //Map
//Найти поток, который записал больше всего данных //
//Для него вывести в порядке, задаваемом пользователем статистику по видам логов
// String TypeLog = int countLog
    // INFO 1
    // DEBUG 1
    // WARNING 2
    // TRACE 1
//
    static void main() {
        String[] s = {
                "INFO [thread [xcde [aqx]] - 0] dwwf wbd",
                "DEBUG [thread [wcxf [czed [ayya [fye]]]] - 0] ybqx",
                "INFO [thread [wcxf [czed [ayya [fye]]]] - 0] [yb]",
                "DEBUG [thread [xcde [aqx]] - 0] zqfx wzq",
                "INFO [thread [qbxb [bbb]] - 1] bzyz eba",
                "WARNING [thread [zqfz [wbye [zfq]]] - 1] wqqa [e]   zqw",
                "TRACE [thread [xcde [aqx]] - 0] cbdx",
                "TRACE [thread [wcxf [czed [ayya [fye]]]] - 0] yafd [a]",
                "TRACE [thread [qbxb [bbb]] - 1] faez",
                "WARNING [thread [xcde [aqx]] - 0] [qw] eed",
                "WARNING [thread [xcde [aqx]] - 0] yzz",
                "DEBUG [thread [qbxb [bbb]] - 1] bxef"};

        System.out.println(getCountLogs(s));
        String mostActiveThread = findMostActiveThread(s);
        System.out.println(mostActiveThread);
        System.out.println(getCountLog(s, mostActiveThread));
    }

    public static Map<String, Long> getCountLogs(String[] s) {
        return Arrays.stream(s)
                .map(str -> str.split(" "))
                .map(array -> array[0])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // 1. Вычленить подстроку из каждого потока в "[...]" (получить начальный и конечный индексы)
    //      работаем поочередно с каждым элементом из массива Стрингов
    // 2. Положить подстроку в HashMap как уникальный ключ
    // 3. Подсчитать, сколько раз подстрока встречается count и записать в value
    // 4. Вернуть поток с максимальным значением value
    public static String findMostActiveThread(String[] s) {
        Map<String, Integer> threadCountMap = new HashMap<>(); // Мапа для хранения данных потока и сколько раз они повторялись

        for (String line : s) {


            int count = 0;                  // count будет обновляться каждый раз для нового элемента массива s
            int i = 0;                      // i - счётчик/индекс для прохода по символам строки
            int startIndex = -1;            // нам нужны начальный и конечный индексы для подстроки
            int endIndex = -1;              // -1 означает, что ещё индекс не найдет (обычная практика)

            while (i < line.length()) {     // Проходим по всей длине строки (элемент массива s)
                char c = line.charAt(i);    // Преобразуем каждый элемент в char
                if (c == '[') {             // Сравниваем с '['
                    count++;                // Если такая встречается, то увеличиваем count
                    if (count == 1) {       // Если нашли первую скобку, то мы определили первый индекс уникальной подстроки
                        startIndex = i;     // Это if обязательно должен быть внутренним
                    }
                }

                if (c == ']') {             // Если находим ']', то уменьшаем count
                    count--;

                    if (count == 0) {       // Когда count станет равным 0, мы опледелим конечный индекс подстроки
                        endIndex = i;
                        break;
                    }
                }
                i++;
            }


            if (startIndex != -1 && endIndex != -1) {                          // Проверка, если в строке нет полного блока скобок - StringIndexOutOfBoundsException
                String threadBlock = line.substring(startIndex, endIndex + 1);
                if (threadCountMap.containsKey(threadBlock)) {                             // если подстрока уже есть в мапе, то
                    threadCountMap.put(threadBlock, threadCountMap.get(threadBlock) + 1);  // увеличиваем значение на 1
                } else {
                    threadCountMap.put(threadBlock, 1);                                    // иначе кладем ключ и его первоначальное значение
                }
            }
        }
        String maxKey = "";                                                 // через EntrySet и цикл находим подстроку с наибольшим значением
        int maxValue = 0;                                                   // для чего инициализируем промежуточные значения

        for (Map.Entry<String, Integer> pair : threadCountMap.entrySet()) {
            String key = pair.getKey();
            Integer value = pair.getValue();

            if (maxValue < value) {
                maxValue = value;
                maxKey = key;
            }

        }
        return maxKey;

    }

    public static Map<String, Long> getCountLog(String[] arrayLog, String threadBlock) {

        List<String> logType = new ArrayList<>();

        for (String log : arrayLog) {
            String typeLog = "";
            if (log.contains(threadBlock)) {
                logType.add(log.split(" ")[0]);
            }
        }
// INFO, DEBUG ...

        return logType.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));


    }

}





