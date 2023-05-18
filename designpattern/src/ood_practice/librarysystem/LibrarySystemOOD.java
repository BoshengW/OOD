package ood_practice.librarysystem;

import java.util.*;

public class LibrarySystemOOD {

    public static void main(String[] args) {

    }
}

class Book {
    String bookId;
    String name;
    BorrowInfo info;
    String ShelfID;

    public Book(String bookId, String name, String shelfID) {
        this.bookId = bookId;
        this.name = name;
        this.ShelfID = shelfID;
        this.info = new BorrowInfo();
    }
}

class BorrowInfo {
    boolean isBorrowed;
    String estReturnDate;
    String lastBorrowDate;

    public BorrowInfo() {
        isBorrowed = false;
        estReturnDate = null;
        lastBorrowDate = null;
    }
}

class Shelf {
    String shelfID;
    String Category;
    String shelf_location;
    HashSet<String> books; // set of book id
}

class ShelfSystem {
    HashMap<String, Shelf> shelves;
    public String findLocation(Book book) {
        Shelf target = shelves.get(book.ShelfID);
        if (target.books.contains(book.bookId)) {
            return target.shelf_location;
        } else {
            return "Book not available";
        }
    }
}

class User {
    String userId;
    HashSet<Book> ownedBooks;

    LibrarySystem lib = new LibrarySystem();
}

class LibrarySystem {
    HashMap<String, List<Book>> BookDataBase;
    HashMap<String, HashSet<User>> waitlist;
    HashMap<String, User> UserDB;
    ShelfSystem shelfSys;

    private void Notify(Book book) {
        // Improvement: use Pub-Sub Design System
    }

    public String findBook(Book book) {
        return shelfSys.findLocation(book);
    }

    private boolean bookIsAvail(Book book) {
        if (!BookDataBase.containsKey(book.name)) return false;
        for (Book i: BookDataBase.get(book.name)) {
            if (i.bookId == book.bookId) {
                return i.info.isBorrowed;
            }
        }
        return false;
    }

    public Book borrowToUser(Book book, User user) {
        // check book availability
        if (!bookIsAvail(book)) {
            System.out.println("Book is borrowed");
            return null;
        }

        // update Book info
        book.info.isBorrowed = true;
        book.info.lastBorrowDate = "today";
        book.info.estReturnDate = "tomorrow";

        // update user info
        user.ownedBooks.add(book);

        // return Book to User
        return book;

    }

    public boolean ReverseToUser(Book book, User user) {
        // check book available
        book.info.isBorrowed = false;
        if (!bookIsAvail(book)) return false;
        // add user in waitlist
        waitlist.putIfAbsent(book.bookId, new HashSet<>());
        waitlist.get(book.bookId).add(user);
        return true;
    }

    public boolean returnFromUser(Book book, User user) {
        // update Book info
        book.info.isBorrowed = false;
        if (!bookIsAvail(book)) return false;

        // update user info
        user.ownedBooks.remove(book);
        // (optional) if expired return date, user need to pay extra fee

        // if return book is in waitlist then notify users
        Notify(book);
        return true;
    }

    public boolean addBook(Book book) {
        BookDataBase.putIfAbsent(book.name, new ArrayList<>());
        BookDataBase.get(book.name).add(book);
        return true;
    }

    public boolean removeBook(Book book) {
        if (BookDataBase.containsKey(book.name)) {
            List<Book> temp = new ArrayList<>();
            for (Book i: BookDataBase.get(book.name)) {
                if(i.bookId != book.bookId) temp.add(i);
            }
            BookDataBase.put(book.name, temp);
            return true;
        } else {
            System.out.println("Book not found");
            return false;
        }
    }

}


