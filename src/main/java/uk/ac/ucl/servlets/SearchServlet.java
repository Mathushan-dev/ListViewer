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

@WebServlet("/runSearchItemListAll.html")
public class SearchServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Model model = ModelFactory.getModel();

    String searchString = request.getParameter("searchString").strip();
    String searchAction = request.getParameter("searchAction").strip();
    List<String> searchResult;

    if (searchAction.compareToIgnoreCase("itemListSearch") == 0){
      searchResult = model.searchForList(searchString);
    }
    else {
      searchResult = model.searchForItem(searchString.toLowerCase());
    }

    sendResponse(model, request, response, searchResult);
  }

  private void sendResponse(Model model, HttpServletRequest request, HttpServletResponse response, List<String> searchResult) throws ServletException, IOException {
    request.setAttribute("searchResult", searchResult);
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/SearchResult.jsp");
    dispatch.forward(request, response);
  }
}
