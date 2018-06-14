import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryDelete {

    public void delete(Connection connection) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj id książki, którą chcesz usunąć: ");
        String id = scan.nextLine();

        final String string = "delete from books where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

            System.out.println("\n Usunięto pozycję. \n");

        } catch (SQLException e) {
            System.out.println("Nie można uzunąć pozycji.");
        }
    }

}
