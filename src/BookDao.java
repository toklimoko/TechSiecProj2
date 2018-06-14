import java.sql.*;
import java.util.Scanner;

public class BookDao {

    public BookDao() {
    }

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
                String year = resultSet.getString("BOOKYEAR");
                String isbn = resultSet.getString("ISBN");

                System.out.println("ID: " + id + "\n Title: " + title + "\n Author: " + author + "\n Year: " + year + "\n ISBN: " + isbn + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Błąd wczytania bazy danych.");
        }
    }

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

        Book book = new Book(id, title, author, year, isbn);

        final String string = "insert into books(ID,TITLE,AUTHOR,BOOKYEAR,ISBN) values(?, ?, ?, ?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.setString(1, book.getId());
            preparedStatement.setString(2, book.getTytul());
            preparedStatement.setString(3, book.getAutor());
            preparedStatement.setString(4, book.getRok());
            preparedStatement.setString(5, book.getIsbn());
            preparedStatement.executeUpdate();
            System.out.println("\n Dodano pozycję. \n");
        } catch (SQLException e) {
            System.out.println("Nie dodano pozycji.");
            e.printStackTrace();
        }

    }

    public void delete(Connection connection) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj id książki, którą chcesz usunąć: ");
        String id = scan.nextLine();

        Book book = new Book(id);

        final String string = "delete from books where ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.setString(1, book.getId());
            preparedStatement.executeUpdate();

            System.out.println("\n Usunięto pozycję. \n");

        } catch (SQLException e) {
            System.out.println("Nie można uzunąć pozycji.");
        }
    }

    public void update(Connection connection) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nr id książki:");
        String id = scan.nextLine();
        System.out.println("Podaj tytuł:");
        String title = scan.nextLine();
        System.out.println("Podaj autora:");
        String author = scan.nextLine();
        System.out.println("Podaj rok wydania:");
        String year = scan.nextLine();
        System.out.println("Podaj nr ISBN: ");
        String isbn = scan.nextLine();

        Book book = new Book(id, title, author, year, isbn);

        final String string = "update books set TITLE=?, AUTHOR=?, BOOKYEAR=?, ISBN=? where ID = ?";

        try {
            PreparedStatement prepStmt = connection.prepareStatement(string);
            prepStmt.setString(1, title);
            prepStmt.setString(2, author);
            prepStmt.setInt(3, Integer.valueOf(book.getRok()));
            prepStmt.setString(4, isbn);
            prepStmt.setString(5, id);
            prepStmt.executeUpdate();

            System.out.println("\n Zakualizowano pozycję \n");

        } catch (SQLException e) {
            System.out.println("Nie zaktualizowano pozycji");
        }

    }







}