package Home;

import java.util.Arrays;


//2469. Преобразовать температуру
//Дается неотрицательное число с плавающей запятой, округленное до двух знаков после запятой celsius, которое обозначает температуру в градусах Цельсия.
//Необходимо преобразовать градусы Цельсия в Кельвины и Fahrenheit и верните его в виде массива ans = [kelvin, fahrenheit].
//Возвратить массив ans. будут приняты ответы в пределах 10-5 от фактического ответа.
//Обратите внимание, что:
//Kelvin = Celsius + 273.15
//Fahrenheit = Celsius * 1.80 + 32.00


public class ConvertTheTemperature {

    public double[] convertTemperature(double celsius) {
        double ans [] = new double [3];                 // создаем массив
        double kelvin  = celsius + 273.15;              // вводим перевод в Кельвины
        double fahrenheit = celsius*1.80 + 32.00;       // вводим перевод в Фаренгейты
        ans [0] = celsius;
        ans [1] = kelvin;                               // первый индекс массива выделяем для Кельвина
        ans [2] = fahrenheit;                           // второй индекс выделяем для Фаренгейта
        return ans;
    }
    public static void main (String[] args){
        ConvertTheTemperature ct = new ConvertTheTemperature();
        double celsius = 36.50;
        double [] result = ct.convertTemperature(celsius);
        System.out.println(Arrays.toString(result));



    }
}
