import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryUpdate {

    public void update(Connection connection) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nr id książki:");
        String id = scan.nextLine();
        System.out.println("Podaj tytuł:");
        String title = scan.nextLine();
        System.out.println("Podaj autora:");
        String author = scan.nextLine();
        System.out.println("Podaj rok wydania:");
        Integer year = Integer.valueOf(scan.nextLine());
        System.out.println("Podaj nr ISBN: ");
        String isbn = scan.nextLine();

        final String string = "update books set title=?, author=?, bookYear=?, isbn=? where id = ?";

        try {
            PreparedStatement prepStmt = connection.prepareStatement(string);
            prepStmt.setString(1, title);
            prepStmt.setString(2, author);
            prepStmt.setInt(3, year);
            prepStmt.setString(4, isbn);
            prepStmt.setString(5, id);
            prepStmt.executeUpdate();

            System.out.println("\n Zakualizowano pozycję \n");

        } catch (SQLException e) {
            System.out.println("Nie zaktualizowano pozycji");
        }

    }
}
