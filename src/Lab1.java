import java.util.ArrayList;
import java.util.List;

public class Lab1 {
    public static void main(String[] args) {
<<<<<<< HEAD
        String input = "abc def krt ghi bac qwerty";
=======
        String input = "abc krt def ghi bac qwerty";
>>>>>>> 1881b9e (Збереження змін перед pull)
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
//Знайти слова, символи в яких йдуть в порядку зростання їх кодів. На вхід поступає
//рядок із словами. На виході – масив String.

//Объяснение решения:
//Метод findWordsWithIncreasingCodes:
//
//Разбивает входную строку на слова с помощью split("\\s+").
//Проходит по каждому слову и проверяет, идут ли символы в нём в порядке возрастания.
//Если слово соответствует критерию, добавляет его в список validWords.
//Преобразует список в массив строк и возвращает его.
//Метод isIncreasing:
//
//Проходит по символам слова.
//Проверяет, что каждый символ имеет код, больший, чем предыдущий.
//Если где-то встречается нарушение порядка (текущий символ больше или равен следующему), возвращает false.
//Если порядок сохраняется до конца, возвращает true.

//Слова abc, def, ghi имеют символы в порядке возрастания по их кодам. Слово bac не подходит, так как b > a, а qwerty не подходит, так как r > t.
//
//Это задание относительно простое, так как требует базовых знаний о строках, работе с циклами и проверках условий.