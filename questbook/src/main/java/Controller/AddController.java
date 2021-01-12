package Controller;

import com.example.database.logic.CommDAO;
import com.example.database.logic.Comment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/add")
public class AddController extends HttpServlet {

    private final CommDAO commDAO = new CommDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        commDAO.add(new Comment(request.getParameter("author"), request.getParameter("description")));

        request.getRequestDispatcher("/").forward(request,response);
    }


}