import java.util.ArrayList;

class Guest extends User implements Library {

    public Guest(String login) {
        super(login);
    }

    public void getDetails(Book b) {
        System.out.println(b);
    }

    @Override
    public ArrayList<Book> getLibrary() {
        return bookCollection;
    }

    @Override
    public boolean addABook(Book b) {
        System.out.println("Guests are not allowed to do that !");
        return false;
    }
}