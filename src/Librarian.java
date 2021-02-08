import java.util.ArrayList;

class Librarian extends User implements Library {

    public Librarian(String login) {
        super(login);
    }

    @Override
    public ArrayList<Book> getLibrary() {
        return bookCollection;
    }

    public boolean addABook(Book b) {
        if(b == null)
            return false;
        bookCollection.add(b);
        System.out.println(b + " was added to the library successfully");
        return true;
    }

}