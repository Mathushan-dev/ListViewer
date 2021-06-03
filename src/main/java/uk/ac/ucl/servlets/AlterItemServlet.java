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

@WebServlet("/runAlterItem.html")
public class AlterItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();

        String listName = request.getParameter("listName");
        String itemIndex = request.getParameter("itemIndex");
        String itemLink = request.getParameter("itemLink");

        if (request.getParameter("alterAction").compareToIgnoreCase("new") == 0) {
            model.insertNewItemToList(listName, itemLink.strip(), itemIndex);
        }
        else {
            model.removeItemFromList(listName, itemIndex);
        }

        sendResponse(model, request, response);
    }

    private void sendResponse(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        model.saveToFile();

        request.setAttribute("listName", request.getParameter("listName"));
        request.setAttribute("itemIndex", request.getParameter("itemIndex"));

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/runViewItemList.html");
        dispatch.forward(request, response);
    }
}