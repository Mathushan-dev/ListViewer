package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/runViewAllItemList.html")
public class ViewAllItemListServlet extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    Model model = ModelFactory.getModel();

    List<String> listNames = model.getListNames();
    request.setAttribute("listNames", listNames);
    ServletContext context = getServletContext();
    RequestDispatcher dispatch;

    if (request.getParameter("viewAction").compareToIgnoreCase("edit") == 0) {
      dispatch = context.getRequestDispatcher("/ViewItemListAll.jsp");
    }
    else if (request.getParameter("viewAction").compareToIgnoreCase("remove") == 0) {
      dispatch = context.getRequestDispatcher("/RemoveItemListAll.jsp");
    }
    else {
      dispatch = context.getRequestDispatcher("/RenameItemListAll.jsp");
    }

    dispatch.forward(request, response);
  }
}
