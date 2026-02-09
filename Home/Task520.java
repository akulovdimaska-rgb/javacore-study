package Home;

public class Task520 {
    public boolean identityWord(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {  //"Google"
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }

        if (count == word.length()
                || count == 0
                || (Character.isUpperCase(word.charAt(0)) && count == 1)) {
            return true;
        }
        return false;
    }
}
class Test520Task{
    public static void main(String[] args) {
        Task520 test = new Task520();
        System.out.println(test.identityWord("Aeeem"));
    }
}
