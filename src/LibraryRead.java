import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryRead {

    public void read(Connection connection) {

        Statement statement = null;

        try {
            statement = connection.createStatement();
            String string = "select * from books";
            ResultSet resultSet = statement.executeQuery(string);

            while(resultSet.next()) {
                int id = resultSet.getInt("ID");
                String title = resultSet.getString("TITLE");
                String author = resultSet.getString("AUTHOR");
                String year = resultSet.getString("YEAR");
                String isbn = resultSet.getString("ISBN");

                System.out.println("ID: " + id + "\n Title: " + title + "\n Author: " + author + "\n Year: " + year + "\n ISBN: " + isbn + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Błąd wczytania bazy danych.");
        }
    }
}
