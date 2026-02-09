package Streaming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchCity {
    public static void main(String[] args) {
        List<List<String>> cityList = new ArrayList<>();
        cityList.add(List.of("London", "New York"));
        cityList.add(List.of("New York", "Lima"));
        cityList.add(List.of("Lima", "San Paulo"));

        System.out.println(searchCity(cityList));

    }

    public static String searchCity(List<List<String>> cityList) {                               //      [["London", "New York"],["New York", "Lima"],[("Lima", "Sao Paulo"]]
// Находим город с частотой 1 - это первый и последний города
        List<String> endpoints = cityList.stream()
                .flatMap(List::stream)                                                     //      ["London", "New York","New York", "Lima", Lima", "Sao Paulo"]
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))      //      [London=1, New York=2, Lima=2, Sao Paulo=1]
                .entrySet().stream()                                                             //      [London=1, New York=2, Lima=2, Sao Paulo=1]
                .filter(entry -> entry.getValue() < 2)                          		 //      [London=1, Sao Paulo=1]
                .map(Map.Entry::getKey)                                                          //      [London, Sao Paulo]
                .toList();

// У меня так не работает, т.к. установлена Java 17
//        boolean isSearchCity = cityList.stream()
//                .map(List::getFirst)                                                             //      ["London", "New York", "Lima"]
//                .anyMatch(element -> element.equals(stringList.getFirst()));             //      true

//        return isSearchCity ? stringList.get(1) : stringList.get(0);

// для Java 17
        String startCity = cityList.get(0).get(0);
        return endpoints.get(0).equals(startCity) ? endpoints.get(1) : endpoints.get(0);
    }

}
