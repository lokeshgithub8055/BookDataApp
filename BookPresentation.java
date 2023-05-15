package Demo;

import DAO.BookDAO;
import DTO.BookDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookPresentation {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        System.out.println("select mode of operation");
        System.out.println("1: Add new books");
        System.out.println("2: Delete books");
        System.out.println("3: View books");
        int ch=sc.nextInt();
        switch (ch)
        {
            case 1:
                addBooks();
                break;
            case 2:
                deleteBooks();
                break;
            case 3:
                viewBooks();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void viewBooks() {
        BookDAO d1=new BookDAO();
        ArrayList<BookDTO>bookList=d1.viewBooks();
        for(BookDTO b:bookList)
            System.out.println(b);
    }

    private static void deleteBooks() {
        System.out.println("Enter book id to be deleted");
        int id=sc.nextInt();

        BookDTO d1=new BookDTO();
        d1.setBookId(id);

        BookDAO d2=new BookDAO();
        int count=d2.deleteBook(d1);
        System.out.println(count + "Book deleted");
    }

    private static void addBooks() {
        System.out.println("Enter book Id");
        int id=sc.nextInt();
        System.out.println("Enter book name");
        String name=sc.next();
        System.out.println("Enter book price");
        double price=sc.nextDouble();

        // add data into DTO objet

        BookDTO d1=new BookDTO();
        d1.setBookId(id);
        d1.setBookName(name);
        d1.setBookPrice(price);

        //call method from DAO class

        BookDAO b1=new BookDAO();
        int count = b1.insertBooks(d1);
        System.out.println(count + "Book inserted succesfully");
    }
}
