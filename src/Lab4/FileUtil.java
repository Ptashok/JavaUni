package Lab4;

import java.io.*;
import java.util.List;

public class FileUtil {

    // Збереження списку пасажирів у файл
    public static void savePassengersToFile(String filename, List<? extends Human> passengers) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(passengers);
        }
    }

    // Завантаження списку пасажирів із файлу
    public static List<? extends Human> loadPassengersFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<? extends Human>) ois.readObject();
        }
    }
}
