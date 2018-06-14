import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BookDao {

    private static final String url = "jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC";
    private static final String username = "user";
    private static final String password = "root";
    private static Connection connection;


    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Scanner scanner = new Scanner(System.in);
        String answer = "";

        while (!answer.equals("5")) { //koniec


            System.out.println("Wybierz opcję: \n 1 - Dodaj nowy rekord \n 2 - Wyświetl wszystkie książki \n 3 - Usuwanie \n 4 - Aktualizacja \n 5 - Koniec");
            answer = scanner.nextLine();

            if (answer.equals("1")) { //zapis
                LibrarySave addBook = new LibrarySave();
                addBook.add(connection);
            }

            if (answer.equals("2")) { //odczyt
                LibraryRead libraryRead = new LibraryRead();
                libraryRead.read(connection);

            }

            if (answer.equals("3")) { //usuwanie
                LibraryDelete deleteBook = new LibraryDelete();
                deleteBook.delete(connection);
            }


            if (answer.equals("4")) { //aktualizacja
                LibraryUpdate updateBook = new LibraryUpdate();
                updateBook.update(connection);
            }

        }
            close();
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}