import java.util.ArrayList;

class Librarian extends User implements Library {

    public Librarian(String login) {
        super(login);
    }

    @Override
    public ArrayList<Book> getLibrary() {
        return bookCollection;
    }

    @Override
    public boolean addABook(Book b) {
        if(b == null)
            return false;
        bookCollection.add(b);
        System.out.println(b + " was added to the library successfully");
        return true;
    }

    @Override
    public boolean borrowABook(Book b) {
        System.out.println("You can't do that");
        return false;
    }

    @Override
    public boolean returnABook(int index) {
        System.out.println("You can't do that");
        return false;
    }

    @Override
    public void displayBorrowedBooks() {
        System.out.println("No borrowed books");
    }

}