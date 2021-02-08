class Main {
    public static void main(String[] args) {

        Book b1 = new Book("Harry Potter", "JK Rowling");
        Book b2 = new Book("Seigneur des anneaux", "Tolkien");
        Book b3 = new Book("Les justes", "Albert Camus");

        Librarian chef = new Librarian("Samy");
        Member man = new Member("Guy");
        Guest dummy = new Guest("Toto");

        chef.addABook(b1);
        chef.addABook(b2);
        chef.addABook(b3);

        System.out.println();

        man.getLibrary();
        man.addABook(new Book("One random book", "A random guy"));

        System.out.println();

        dummy.getLibrary();
        dummy.addABook(new Book("azertyuiop", "Jean-Jacques"));

        for(Book b : chef.getLibrary()) {
            System.out.println(b);
        }
    }
}
