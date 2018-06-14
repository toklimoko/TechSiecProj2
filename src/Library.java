import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Library {

    private static final String url = "jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC";
    private static final String username = "user";
    private static final String password = "admin1";
    private static Connection connection;


    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
                BookDao bookDao = new BookDao();
                bookDao.add(connection);
            }

            if (answer.equals("2")) { //odczyt
                BookDao bookDao = new BookDao();
                bookDao.read(connection);

            }

            if (answer.equals("3")) { //usuwanie
                BookDao bookDao = new BookDao();
                bookDao.delete(connection);
            }


            if (answer.equals("4")) { //aktualizacja
                BookDao bookDao = new BookDao();
                bookDao.update(connection);
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
