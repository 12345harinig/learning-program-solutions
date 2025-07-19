package LibrarySearchSystem;

import java.util.Arrays;

public class LibraryTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "Java Programming", "James Gosling"),
            new Book(102, "Python Basics", "Guido van Rossum"),
            new Book(103, "C Programming", "Dennis Ritchie"),
            new Book(104, "Data Structures", "Narasimha Karumanchi")
        };

        // Linear Search (no need to sort)
        System.out.println(" Linear Search:");
        Book result = BookSearch.linearSearch(books, "Python Basics");
        System.out.println(result != null ? "Found: " + result : "Book not found.");

        // Sort for Binary Search
        Arrays.sort(books); // uses compareTo()
        System.out.println("\n📚 Sorted Books for Binary Search:");
        for (Book b : books) System.out.println(b);

        // Binary Search
        System.out.println("\n Binary Search:");
        Book result2 = BookSearch.binarySearch(books, "Python Basics");
        System.out.println(result2 != null ? "Found: " + result2 : "Book not found.");
    }
}

