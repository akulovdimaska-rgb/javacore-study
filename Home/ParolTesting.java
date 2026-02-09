package Home;

/**
 * Условие: Проверить, соответствует ли пароль требованиям:
 * <p>
 * Длина >= 8 символов
 * Есть хотя бы одна цифра
 * Есть хотя бы одна заглавная буква
 * Есть хотя бы один спецсимвол (!@#$%^&*)
 * <p>
 * 1. Проверить длину
 * 2. Проверить наличие спецсимвола из набора
 * 3. Проверить наличие заглавной буквы
 * 4. Если соответствует, то вывести true, "Пароль соответствует"
 */

public class ParolTesting {
    private static final String SPECIAL_CHARS = "!@#$%^&*";

    public static void main(String[] args) {
        String parol = "Adidfs8*";
        ParolTesting parolTesting = new ParolTesting();
        System.out.println(parolTesting.isTrueParol(parol));

    }

    public boolean isTrueParol(String parol) {
        // Проверка длины пароля
        if (parol.length() < 8) {
            return false;
        }
        // Создание флагов
        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasSpecial = false;

        // Проход по паролю с ранним выходом
        for (char ch : parol.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
            if (isSpecialChar(ch)) {
                hasSpecial = true;
            }

            if (hasDigit && hasUpperCase && hasSpecial) {
                break;

            }
        }
        return hasDigit && hasUpperCase && hasSpecial;
    }

    private boolean isSpecialChar(char ch) {
        return "!@#$%^&*".indexOf(ch) != -1;
    }
}