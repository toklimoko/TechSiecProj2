import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LibrarySave {

    public void add(Connection connection){

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nr id książki:");
        String id= scan.nextLine();
        System.out.println("Podaj tytuł:");
        String title = scan.nextLine();
        System.out.println("Podaj autora:");
        String author = scan.nextLine();
        System.out.println("Podaj rok wydania:");
        String year =scan.nextLine();
        System.out.println("Podaj nr ISBN:");
        String isbn = scan.nextLine();

        final String string = "insert into books(id,title,author,bookYear,isbn) values(?, ?, ?, ?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, author);
            preparedStatement.setString(4, year);
            preparedStatement.setString(5, isbn);
            preparedStatement.executeUpdate();
            System.out.println("\n Dodano pozycję. \n");
        } catch (SQLException e) {
            System.out.println("Nie dodano pozycji.");
            e.printStackTrace();
        }

    }
}
