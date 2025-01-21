package PAT_A1022_Digital_Library;

import java.util.*;
import java.io.*;

/**
 * 测试点4概率超时
 */
public class Main {
    static class Book {
        String id, name, author;
        Set<String> keywords;
        String publisher, year;

        Book(String id, String name, String author, Set<String> keywords, String publisher, String year) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.keywords = keywords;
            this.publisher = publisher;
            this.year = year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Book> books = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String id = reader.readLine();
            String name = reader.readLine();
            String author = reader.readLine();

            String line = reader.readLine();
            Set<String> keywords = new HashSet<>(Arrays.asList(line.split(" ")));

            String publisher = reader.readLine();
            String year = reader.readLine();

            books.add(new Book(id, name, author, keywords, publisher, year));
        }

        int m = Integer.parseInt(reader.readLine());
        String line;
        while (m-- > 0) {
            line = reader.readLine();
            System.out.println(line);
            String info = line.substring(3);
            char t = line.charAt(0);
            List<String> res = new ArrayList<>();

            for (Book book : books) {
                switch (t) {
                    case '1':
                        if (book.name.equals(info)) res.add(book.id);
                        break;
                    case '2':
                        if (book.author.equals(info)) res.add(book.id);
                        break;
                    case '3':
                        if (book.keywords.contains(info)) res.add(book.id);
                        break;
                    case '4':
                        if (book.publisher.equals(info)) res.add(book.id);
                        break;
                    case '5':
                        if (book.year.equals(info)) res.add(book.id);
                        break;
                }
            }

            if (res.isEmpty()) System.out.println("Not Found");
            else {
                Collections.sort(res);
                for (String id : res) System.out.println(id);
            }
        }
    }
}