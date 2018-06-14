public class Book {


    private String id;
    private String tytul;
    private String autor;
    private String rok;
    private String isbn;

    public Book(String id, String tytul, String autor, String rok, String isbn) {
        this.id = id;
        this.tytul = tytul;
        this.autor = autor;
        this.rok = rok;
        this.isbn = isbn;
    }

    public Book(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", autor='" + autor + '\'' +
                ", rok=" + rok +
                ", isbn=" + isbn +
                '}';
    }
}
