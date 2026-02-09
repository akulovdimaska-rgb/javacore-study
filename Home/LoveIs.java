package Home;

public class LoveIs {

    public static void main(String[] args) {
        boolean loveIs = false;

        if ("Петя+Маша" == "Любовь") { // комментарий нужен, чтобы запутать: \u000a\u007d\u007b
            loveIs = true;
            System.out.println("❤️❤️❤️");
        }

        if (!loveIs) {
            System.out.println("Чудес не бывает");
        }
    }
}
