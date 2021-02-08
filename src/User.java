abstract class User implements Library{
    String login;

    public User(String login) {
        this.login = login;
    }

    public abstract boolean addABook(Book b);

    public abstract boolean borrowABook(Book b);

    public abstract boolean returnABook(int index);

    public abstract void displayBorrowedBooks();
}