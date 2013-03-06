import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 02.03.13
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */

@WebServlet( name = "SimpleServlet", urlPatterns = {"/simple"} )

public class ServletGuestBook extends HttpServlet {
    GuestBook guestBook;


    @Resource(name = "jdbc_testDS")
    private DataSource ds;

    @PostConstruct
    public void init(){
        try {
            guestBook = new GuestBook(ds);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("ListRecords", guestBook.getRecords());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("WEB-INF/test.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "";
        message = req.getParameter("textfield");
        try {
            guestBook.addRecord(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(req, resp);
    }
}
