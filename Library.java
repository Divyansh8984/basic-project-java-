
    import java.util.*;
    import java.time.LocalDate;
    
    public class Library {
        private List<Book> books = new ArrayList<>();
        private List<Member> members = new ArrayList<>();
        private List<Transaction> transactions = new ArrayList<>();
    
        // Add a new book
        public void addBook(Book book) {
            books.add(book);
            System.out.println("Book added successfully!");
        }
    
        // Add a new member
        public void addMember(Member member) {
            members.add(member);
            System.out.println("Member added successfully!");
        }
    
        // Search book by title
        public void searchBook(String title) {
            for (Book b : books) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    System.out.println(b);
                    return;
                }
            }
            System.out.println("Book not found!");
        }
    
        // Issue a book
        public void issueBook(int bookId, int memberId) {
            for (Book b : books) {
                if (b.getId() == bookId && b.getAvailableCopies() > 0) {
                    b.setAvailableCopies(b.getAvailableCopies() - 1);
                    transactions.add(new Transaction(bookId, memberId, LocalDate.now()));
                    System.out.println("Book issued successfully!");
                    return;
                }
            }
            System.out.println("Book not available!");
        }
    
        // Return a book
        public void returnBook(int bookId, int memberId) {
            for (Transaction t : transactions) {
                if (t.getBookId() == bookId && t.getMemberId() == memberId && t.getReturnDate() == null) {
                    t.setReturnDate(LocalDate.now());
                    for (Book b : books) {
                        if (b.getId() == bookId) {
                            b.setAvailableCopies(b.getAvailableCopies() + 1);
                            break;
                        }
                    }
                    System.out.println("Book returned successfully!");
                    return;
                }
            }
            System.out.println("No active transaction found!");
        }
    
        // Show all books
        public void showAllBooks() {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    
        // Show all members
        public void showAllMembers() {
            for (Member m : members) {
                System.out.println(m);
            }
        }
    
        // Show all transactions
        public void showAllTransactions() {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
    


