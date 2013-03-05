import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 02.03.13
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */

@WebServlet( name = "SimpleServlet", urlPatterns = {"/simple"} )

public class ServletGuestBook extends HttpServlet {
    GuestBook guestBook = GuestBook.getGuestBook();

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ListRecords", guestBook.getRecords());
        req.getRequestDispatcher("WEB-INF/test.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "";
        message = req.getParameter("textfield");
        guestBook.addRecord(message);
        doGet(req, resp);
    }
}
