package Home;

public class ReverseVowels {
    // 345. Reverse Vowels of a String
    // Given a string s, reverse only all the vowels in the string and return it.
    // The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
// Input: s = "IceCreAm"
// Output: "AceCreIm"
// Explanation:
// The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
// Example 2:
// Input: s = "leetcode"
// Output: "leotcede"
public static String reversVowels(String s){    // создаём метод, который возвращает строку с перемещёнными символами
    int n = s.length();
    char ch[]=s.toCharArray(); // Преобразуем строку в массив символов
    int start = 0;             // Затем создаем указатели start для перемещения от начала массива char
    int end = s.length()-1;    // и end, для перемещения от конца массива к началу

while (start<end)               // пока начальный указатель меньше предыдущего:
{
    if (!isVowel(ch[start]))    // внутри if мы обращаемся к методу isVowel, в котором прописываем чары, являющиеся гласными
    {                           // если гласная вначале массива не найдена,
        start++;                // смещаем начальный указатель на один вправо
    } else if (!isVowel(ch[end])) //если в конце массива гласная не найдена,
    {
        end--;                    //смещаем конечный указатель на один влево
    } else {                      // иначе, если мы находим гласную букву, то производим замену символа end на старт
                                  // чтобы провести замену символов без потерь вводим временную переменную temp
        char temp=ch[start];      // присваиваем временной переменной значение start
        ch[start]=ch[end];        // меняем значение переменной start значение end
        ch[end]=temp;             // присваиваем переменной end значение temp (т.е. начальное значение start)
        start++;                  // смещаем указатели start - вправо,
        end--;                    //  а end - влево
    }
}
return String.valueOf(ch);
}
public static boolean isVowel(char ch){
if (ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u'|| ch=='A'|| ch=='E'|| ch=='I'|| ch=='O'|| ch=='U') {
    return true;            // метод возвращает true, если в строке 37 найден один из символов
}
    return false;           // метод возвращает false, если символ в строке 37 не найден
}

public static void main(String[] args){
    // System.out.println(reversVowels("dktpfr"));
    System.out.println(reversVowels("IceCreAm"));
}



}
