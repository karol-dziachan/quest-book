package Controller;

import com.example.database.logic.CommDAO;
import com.example.database.logic.Comment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("")
public class StartController extends HttpServlet {

    final CommDAO commDAO = new CommDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> comments = commDAO.findAll();
        if(comments == null)
        {
            comments=new ArrayList<>();
        }
        Collections.reverse(comments);
        request.getServletContext().setAttribute("comm", comments);
        request.getRequestDispatcher("/home").forward(request, response);
    }

}