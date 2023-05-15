package DAO;

import DTO.BookDTO;

import java.sql.*;
import java.util.ArrayList;

public class BookDAO {
static Connection con=null;
static {
    try {
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ieja8","root","sql123");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public int insertBooks(BookDTO d1) {
        PreparedStatement pstmt=null;
        int count=0;
        String query="insert into book_info values(?,?,?)";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,d1.getBookId());
            pstmt.setString(2,d1.getBookName());
            pstmt.setDouble(3,d1.getBookPrice());
            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int deleteBook(BookDTO d1) {
    PreparedStatement pstmt=null;
    int count=0;
    String query="delete from book_info where book_id=?";

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,d1.getBookId());
            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public ArrayList<BookDTO> viewBooks()
    {
        Statement stmt=null;

        ResultSet rs=null;

        ArrayList<BookDTO>bookList=new ArrayList<>();

        String query="select*from book_info";

        try {
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);
            while (rs.next())
            {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);

                //store data into DTO class object

                BookDTO d1=new BookDTO();
                d1.setBookId(id);
                d1.setBookName(name);
                d1.setBookPrice(price);

                //add object itno list

                bookList.add(d1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

//    {
//        PreparedStatement pstmt=null;
//        ResultSet rs=null;
//        String query="select*from book_info";
//
//        try {
//            pstmt=con.prepareCall(query);
//            rs=pstmt.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }

}
