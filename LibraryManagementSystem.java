import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private Member borrowedBy;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowedBy = null;
    }

    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Borrowed By: " + (borrowedBy != null ? "Borrowed" : "Available"));
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Member member) {
        this.borrowedBy = member;
    }

    public boolean isAvailable() {
        return borrowedBy == null;
    }
}

class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public void displayMember() {
        System.out.println("Name: " + name);
        System.out.println("Member ID: " + memberId);
        System.out.println("Books Borrowed: " + borrowedBooks.size());
    }

    public String getName() {
        return name;
    }

    public String getMemberID() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setBorrowedBy(this);
            System.out.println(name + " has borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Book is not available for borrowing");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            System.out.println(name + " has returned the book: " + book.getTitle());
            book.setBorrowedBy(null);
        } else {
            System.out.println("This book was not borrowed by " + name);
        }
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found in the library");
        }
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member.getName());
    }

    public void removeMember(Member member) {
        if (members.remove(member)) {
            System.out.println("Member removed: " + member.getName());
        } else {
            System.out.println("Member not found in the Library");
        }
    }

    public void listBooks() {
        System.out.println("\nBook Details:");
        for (Book book : books) {
            book.displayBook();
            System.out.println("---");
        }
    }

    public void listMembers() {
        System.out.println("\nMember Details:");
        for (Member member : members) {
            member.displayMember();
            System.out.println("---");
        }
    }

    public Book findBookbyIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberbyID(String memberId) {
        for (Member member : members) {
            if (member.getMemberID().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("It Ends With Us", "Coolen Hoover", "ISBN-001");
        Book book2 = new Book("Wings of Fire", "APJ Abdul Kalam", "ISBN-002");
        Book book3 = new Book("Breaking Bad", "Vince Gilligan", "ISBN-003");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Member mem1 = new Member("Walter White", "M001");
        Member mem2 = new Member("Jesse Pinkman", "M002");

        library.addMember(mem1);
        library.addMember(mem2);

        System.out.println("\nBorrowing Books:");
        mem1.borrowBook(book1);
        mem2.borrowBook(book2);

        System.out.println("\nBooks after borrowing:");
        library.listBooks();

        System.out.println("\nReturning Books:");
        mem1.returnBook(book1);

        System.out.println("\nBooks after returning:");
        library.listBooks();
    }
}