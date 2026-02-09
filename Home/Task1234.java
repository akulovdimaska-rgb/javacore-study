package Home;

public class Task1234 {
//У нас есть строка, которая содержит математическое выражение. Нужно посчитать результат.
//String s1 = "3+2*2";

    static void main(String[] args) {
        String s = "3+2*2"; // 7
        String s1 = "3+2*3/2"; //6
        String s2 = "-4*2+1+3/5*6";//-3,4
        //System.out.printf("3+2*2 = %s\n3+2*3/2=%s\n-4*2+1+3/5*6=%s",getResult(s), getResult(s1),getResult(s2));
        System.out.println(getResult(s));
    }

    /*
     Создаю переменные
    int result = 0; 3 |
    int currentNumber = 0; 2 |
    char firstOperator =''; + |
    nextNumber
    1. Разбиваю строку на массив char
    2. Прохожу по массиву char
    3. Встречаю первый char:
        - если это '-', складываю в переменную firstOperator
        - если это 'число', складываю в result
            - если firstOperator '-', складываю '-' и 'число'
        - если это оператор
            - если это '+' или '-', обновляем firstOperator
        - если это 'число', обновляем currentNumber
        - если это '+' или '-', currentNumber складываем с result
        - если это '*' или '/', currentNumber (/,*) nextNumber и сохраняем в currentNumber
           - обнуляем nextNumber
           - увеличиваем индекс на 1
           - если следующий индекс null, то currentNumber (+ или -) result

     */
    public static double getResult(String s) {
//(+)3+2*2
        char lastOperator = '+';
        double result = 0;
        double currentNumber = 0;
        double num = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                num = num*10 + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) || i == s.length() - 1) {
                switch (lastOperator) {
                    case '+' -> {
                        result = result + currentNumber;
                        currentNumber = num;
                    }
                    case '-' -> {
                        result = result + currentNumber;
                        currentNumber = -num;
                    }
                    case '*' -> currentNumber = currentNumber * num;
                    case '/' -> currentNumber = currentNumber / num;
                }
                lastOperator = currentChar;
                num = 0;
            }
        }
        return result + currentNumber;
    }
}

