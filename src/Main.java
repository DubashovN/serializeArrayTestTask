import java.io.*;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println(serialize().replaceAll("[^0-9.,]", "").length());
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
        Integer[] intArray = new Integer[1000];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(200);
        }
        return intArray;
    }
}
