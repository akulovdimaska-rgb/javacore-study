//package Home;
//
//import java.util.function.Function;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class ReverseWords2 {
//    class StringReplacer {
//
//    }
//    public static String replace(String input, Pattern regex, Function<Matcher, String> callback) {
//                                                                                                                 // разбиваем предложение на слова
//
//        StringBuffer resultString = new StringBuffer();
//       Matcher regexMatcher = regex.matcher(input);
//       while (regexMatcher.find()){
//           regexMatcher.appendReplacement(resultString, callback.apply(regexMatcher));
//        }
//       regexMatcher.appendTail(resultString);
//        return resultString.toString();
////             //Заменяю исходное слово на перевернутое
////        newString = myString.replaceAll(matcher.group(), reversedWords.toString());
//
//    }
//    public static void main(String[] args) throws Exception {
//        String myString = "Let's take LeetCode contest";
//        // Output: "s'teL ekat edoCteeL tsetnoc"
//        System.out.println(StringReplacer.replace(myString, Pattern.compile("\\w+"), m -> new StringBuilder(m.group()).reverse().toString()));
//    }
//}
