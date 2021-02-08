import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    // Return true if user's login appears in librarian list
    private static boolean isLibrarian(String login) {
        try(BufferedReader br = new BufferedReader(new FileReader("src/res/librarians.txt"))) {;
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while(line != null) {
                if(line.equals(login))
                    return true;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Return true if user's login appears in members' logins file
    private static boolean isMember(String login) {
        try(BufferedReader br = new BufferedReader(new FileReader("src/res/members.txt"))) {;
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while(line != null) {
                if(line.equals(login))
                    return true;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void displayBookCollection(User user) {
        ArrayList<Book> bookCollection = user.getLibrary();
        for(int i = 0; i < bookCollection.size(); i++)
            System.out.println("\t" + i + " - " + bookCollection.get(i));
    }


    private static void nextUserAction() {
        String[] actions = {"1. Check available books", "2. Borrow a book", "3. Return a book", "4. Add a book", "5. Become member !", "6. Exit"};
        System.out.println("What do you want to do ?(Enter a number)");
        for (String s : actions) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Harry Potter", "JK Rowling");
        Book b2 = new Book("Seigneur des anneaux", "Tolkien");
        Book b3 = new Book("Les justes", "Albert Camus");

        Librarian chef = new Librarian("Samy");

        chef.addABook(b1);
        chef.addABook(b2);
        chef.addABook(b3);

        boolean execution = true;
        String login = "";
        User activeUser = null;
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome ! This is a library please enter your login to continue:");
        System.out.print("Login: ");
        login = sc.nextLine();

        // Si l'utilisateur n'est pas libraire et qu'il n'est pas membre alors c'est un guest
        if(isMember(login))
            activeUser = new Member(login);
        if(isLibrarian(login))
            activeUser = new Librarian(login);
        activeUser = new Guest(login);


        while(execution) {
            nextUserAction();
            System.out.print("Select an action: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayBookCollection(activeUser);
                    break;
                case 2:
                    displayBookCollection(activeUser);
                    System.out.print("Select a book to borrow by typing its associated number: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice < 0 || choice > activeUser.getLibrary().size()) {
                        System.out.print("Select a valid number please: ");
                        choice = sc.nextInt();
                        sc.nextLine();
                    }
                    activeUser.borrowABook(activeUser.getLibrary().get(choice));
                    break;
                case 3:
                    activeUser.displayBorrowedBooks();
                    System.out.print("Select the book to return: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice < 0 || choice > 2) {
                        System.out.print("Please select a valid number: ");
                        choice = sc.nextInt();
                        sc.nextLine();
                    }
                    activeUser.returnABook(choice);
                    break;
                case 4:
                    System.out.print("What is the book's name: ");
                    String newBookTitle = sc.nextLine();
                    System.out.print("Who wrote the book: ");
                    String newBookAuthor = sc.nextLine();
                    activeUser.addABook(new Book(newBookTitle, newBookAuthor));
                    break;
                case 5:
                    registerGuest(login);
                    break;
                case 6:
                    System.out.println("Good bye ! See you soon !");
                    execution = false;
            }
        }
    }

    private static void registerGuest(String login) {
        try {
            Files.write(Paths.get("src/res/members.txt"), login.getBytes(), StandardOpenOption.APPEND);
            System.out.println(login + " has been registered as a member !");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
