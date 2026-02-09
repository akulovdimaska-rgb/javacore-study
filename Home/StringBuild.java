package Home;

public class StringBuild {
    static void main(String[] args) {
        StringBuild stringBuild = new StringBuild();
        System.out.println(stringBuild.getAlphabet());
        int n = 100;
        System.out.println(stringBuild.getAlphabet2(n));
    }

    public String getAlphabet() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char i = 'a', y = 'A'; i <= 'z'; i++, y++) {
            stringBuilder.append(i)
                    .append(y)
                    .append(' ');
        }
        return stringBuilder.toString();
    }

    public String getAlphabet2(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char i = 'a', y = 'A'; i <= 'z'; i++, y++) {
            if (stringBuilder.length() >= n) {
                stringBuilder.setLength(n);
                System.out.println(stringBuilder.length());
                return stringBuilder.toString();
            }
                stringBuilder.append(i)
                        .append(y)
                        .append(' ');
        }
        System.out.println(stringBuilder.length());
        return stringBuilder.toString();
    }
}


