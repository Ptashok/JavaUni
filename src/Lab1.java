import java.util.ArrayList;
import java.util.List;

public class Lab1 {
    public static void main(String[] args) {
        String input = "abc def krt ghi bac qwerty";
        String[] result = findWordsWithIncreasingCodes(input);

        // Вывод результата
        for (String word : result) {
            System.out.println(word);
        }
    }

    public static String[] findWordsWithIncreasingCodes(String input) {
        // Разбиваем строку на слова по пробелам
        String[] words = input.split("\\s+");

        List<String> validWords = new ArrayList<>();

        // Проходим по каждому слову
        for (String word : words) {
            if (isIncreasing(word)) {
                validWords.add(word);
            }
        }

        // Преобразуем список в массив и возвращаем
        return validWords.toArray(new String[0]);
    }

    // Проверка, что символы в слове идут в порядке возрастания их кодов
    public static boolean isIncreasing(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            // Если текущий символ больше следующего, то порядок нарушен
            if (word.charAt(i) >= word.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
