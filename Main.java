import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Show All Books");
            System.out.println("7. Show All Members");
            System.out.println("8. Show All Transactions");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Available Copies: ");
                    int copies = sc.nextInt();
                    library.addBook(new Book(id, title, author, copies));
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    int mId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    library.addMember(new Member(mId, name));
                    break;

                case 3:
                    System.out.print("Enter Book Title: ");
                    String searchTitle = sc.nextLine();
                    library.searchBook(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter Member ID: ");
                    int memId = sc.nextInt();
                    library.issueBook(bookId, memId);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int rBookId = sc.nextInt();
                    System.out.print("Enter Member ID: ");
                    int rMemId = sc.nextInt();
                    library.returnBook(rBookId, rMemId);
                    break;

                case 6:
                    library.showAllBooks();
                    break;

                case 7:
                    library.showAllMembers();
                    break;

                case 8:
                    library.showAllTransactions();
                    break;

                case 9:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

    

