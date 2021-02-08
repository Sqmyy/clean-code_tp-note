import java.util.ArrayList;

class Member extends User implements Library {
    public Book[] borrowedBooks;

    public Member(String login) {
        super(login);
        borrowedBooks = new Book[3];
    }

    public boolean borrowABook(Book b) {
        for(int i = 0; i < borrowedBooks.length; i++) {
            if(borrowedBooks[i] == null) {
                borrowedBooks[i] = b;
                System.out.println("You have borrowed " + b);
                return true;
            }
        }
        System.out.println("Sorry you can't borrow more than 3 books");
        return false;
    }

    @Override
    public ArrayList<Book> getLibrary() {
        return bookCollection;
    }

    @Override
    public boolean addABook(Book b) {
        System.out.println("Simple members are not allowed to do that !");
        return false;
    }

    @Override
    public boolean returnABook(int index) {
        return false;
    }

    @Override
    public void displayBorrowedBooks() {
        for(int i = 0; i < 3; i++) {
            System.out.println(i + " - " + borrowedBooks[i]);
        }
    }

}