import java.util.ArrayList;

interface Library {
    ArrayList<Book> bookCollection = new ArrayList<>();

    public ArrayList<Book> getLibrary();
    public boolean addABook(Book b);
}