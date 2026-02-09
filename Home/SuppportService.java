package Home;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сервис поддержки “Время на заявки”
 * В компании есть сервис ServiceDesk, который хранит лог работы сотрудников поддержки.
 * Каждая обработанная заявка добавляет запись о том, сколько минут конкретный сотрудник agentId потратил на её разбор в
 * minutes (время чтения, уточнений и фиксации результата).
 * Задание
 * Посчитай суммарное время работы по каждому сотруднику за весь период лога.
 * logs =
 * "a1;12",
 * "a2;25",
 * "a1;8",
 * "a3;40",
 * "a2;15",
 * "a1;30",
 * "a3;10",
 * "a4;5",
 * "a2;20",
 * "a4;35",
 * "a3;22",
 * "a1;14"
 */

public class SuppportService {
    public static void main(String[] args) {
        List<String> logs = List.of("a1;12", "a2;25", "a1;8", "a3;40", "a2;15", "a1;30", "a3;10", "a4;5", "a2;20", "a4;35", "a3;22", "a1;14");

        SuppportService suppportService = new SuppportService();
        Map<String, Integer> result = suppportService.calculateTimeOfEmployees(logs);
//        suppportService.calculateTimeOfEmployeesStream(logs);

        System.out.println(result);
    }

    public HashMap<String, Integer> calculateTimeOfEmployees(List<String> logs) {
        HashMap<String, Integer> allTimes = new HashMap<>();

        for (String line : logs) {
            String[] parts = line.split(";");
            String agentId = parts[0];
            String minutesStr = parts[1];

            int minutes = Integer.parseInt(minutesStr);

            Integer current = allTimes.get(agentId);    // ввожу переменную, но это Integer, т.к. работаю с HashMap

            if (current == null) {                      // первый раз встречаем этого агента → кладём minutes как есть
                allTimes.put(agentId, minutes);
            } else {                                    // уже есть, то прибавляем
                allTimes.put(agentId, current + minutes);
            }
        }
        return allTimes;
    }

//    public HashMap<String, Integer> calculateTimeOfEmployeesStream(List<String> logs) {
//return logs.stream()
//        .map(line -> line.split(";"))
//        .collect(
//                HashMap::new
//        (map, parts) -> map.compute(
//                parts[0], (key, oldValue) -> oldValue == null ? Integer.parseInt(parts[1]) : oldValue + Integer.parseInt(parts[1])
//        ),
//        HashMap::putAll
//        );
//
//
//    }
}
