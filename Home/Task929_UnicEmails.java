package Home;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Каждое действительное электронное письмо состоит из локального имени и доменного имени, разделённых '@'знаком.
 * Помимо строчных букв, электронное письмо может содержать один или несколько '.' или '+'.
 * <p>
 * Например, в "alice@leetcode.com""alice", это локальное имя, а "leetcode.com" — это доменное имя.
 * Если вы добавите точки '.'между некоторыми символами в локальном имени части адреса электронной почты,
 * письма, отправленные на этот адрес, будут перенаправляться на тот же адрес без точек в локальном имени.
 * Обратите внимание, что это правило не применяется к доменным именам.
 * <p>
 * Например, "alice.z@leetcode.com" и "alicez@leetcode.com" отправьте на тот же адрес электронной почты.
 * Если вы добавите знак плюса '+' в локальное имя, все, что идет после первого знака плюса будет игнорироваться.
 * Это позволяет фильтровать определенные электронные письма. Обратите внимание, что это правило не применяется к доменным именам.
 * <p>
 * Например, "m.y+name@email.com" будет перенаправлено на "my@email.com".
 * Можно использовать оба этих правила одновременно.
 * <p>
 * Для массива строк emails, в котором мы отправляем по одному письму каждому emails[i],
 * верните количество различных адресов, на которые действительно были отправлены письма.
 * <p>
 * Алгоритм:
 * 1) раздел
 * 1) обрабатываем отдельно локальную и (при необходимости) доменную часть:
 * - создаём private метод для обработки localPart;
 * - проходим по каждому элементу массива String-ов;
 * - вызываем дополнительный метод;
 * - разделяем email на две части - localPart и domainPart;
 * - ищем всё, что до '@';
 * --- если встретили '+' - берём всю подстроку до '+'
 * --- удаляем все символы '.' из локальной части
 * --- заканчиваем обработку локальной части
 * - если дошли до конца:
 * --- удаляем все символы '.' из локальной части
 * --- заканчиваем обработку локальной части;
 * 2) склеиваем обе части (локальную и доменную)
 * 3) добавляем готовый адрес в HashSet - для уникальности email-ов
 * 4) подсчитываем количество адресов.
 */

public class Task929_UnicEmails {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com",//testemail@leetcode.com
                "test.e.mail+bob.cathy@leetcode.com",     //testemail@leetcode.com
                "testemail+david@lee.tcode.com"};         //testemail@lee.tcode.com
        System.out.println(countOfDifferentEmails(emails));
    }

    public static int countOfDifferentEmails(String[] emails) {

        HashSet<String> unicEmails = new HashSet<>();
        for (String email : emails) {
            unicEmails.add(clearEmail(email));// сделал так без создания доп. переменной.
        }
        return unicEmails.size();

//        return Arrays.stream(emails)
//                .map(email->clearEmail(email))
//                .collect(Collectors.toSet())
//                .size();
    }

    private static String clearEmail(String email) {
        //test.email+alex@leetcode.com
        int middleIndex = email.indexOf('@');
        String local = processLocal(email.substring(0, middleIndex)); //test.email+alex
        String domain = processDomain(email.substring(middleIndex));  //@leetcode.com

        String resultEmail = local + domain;
        return resultEmail;
    }

    private static String processLocal(String local){
        int tempIndex = local.indexOf('+');
        if (tempIndex != -1) {
            local = local.substring(0, tempIndex);      //test.emai
        }
        return local.replace(".", "");

    }
        // На всякий случай сделал метод для обработки доменной части
    private static String processDomain(String domain){
        return domain;
    }

}


