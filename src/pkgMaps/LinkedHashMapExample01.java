package pkgMaps;

import java.util.LinkedHashMap;
import java.util.Map;

class Book {
    int id;
    String name, author, publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}

public class LinkedHashMapExample01 {
    public static void main(String[] args) {
        // Creating map of Books
        // Generalized by Object. This allows to input any object as a value. You need to cast the Object to a specific class type that has been entered. Need
        // to remember the key.
        Map<Integer, Object> map = new LinkedHashMap<Integer, Object>();
        // Creating Books
        Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);
        // Adding Books to map
        map.put(2, b2);
        map.put(1, b1);
        map.put(3, b3);
        map.put(4, "xyz");

        // Traversing map
        for (Map.Entry<Integer, Object> entry : map.entrySet()) {
            int key = entry.getKey();
            Object o = entry.getValue();
            System.out.println(key + " Details:");
            // Object o is casted to Book type to retrieve values
            if (key != 4) {
                System.out.println(((Book) o).id + " " + ((Book) o).name + " " + ((Book) o).author + " " + ((Book) o).publisher + " " + ((Book) o).quantity);
            } else {
                System.out.println(o.toString());
                System.out.println((String) o);
                System.out.println(o);
            }
        }
    }
}
