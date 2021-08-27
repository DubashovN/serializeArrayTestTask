import java.io.*;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
/* Я не очень понял условие задачи, касающееся как можно более компактной строки.
    Можно удалить из строки и запятые, но тогда не понятно будет гдн какое число.
    Если имеется в виду размер в байтах, то с 9-й java все строки это набор байтов. Размер зависит только от кодовой точки символа.
*/
        System.out.println(serialize().replaceAll("[^0-9.,]", ""));
    }

    public static String serialize() {
        String string = null;
        String file = "serialize.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            objectOutputStream.writeObject(List.of(generateArray()));
            string = String.valueOf(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static Integer[] generateArray() {
        Random random = new Random();
        Integer[] intArray = new Integer[200];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(200);
        }
        return intArray;
    }
}
