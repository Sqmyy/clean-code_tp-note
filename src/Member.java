import java.util.ArrayList;

class Member extends User implements Library {
    Book[] borrowedBooks;

    public Member(String login) {
        super(login);
        borrowedBooks = new Book[3];
    }

    public boolean borrowABook(Book b) {
        for(int i = 0; i < borrowedBooks.length; i++) {
            if(borrowedBooks[i] == null) {
                borrowedBooks[i] = b;
                return true;
            }
        }
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
}