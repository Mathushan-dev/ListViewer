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
import java.util.ArrayList;

@WebServlet("/runEditSingleItemList.html")
public class EditSingleItemListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        model.storeItemAttributes(request.getParameter("listName"), request.getParameter("itemIndex"),
                request.getParameter("itemText"), request.getParameter("itemUrl"), request.getParameter("itemContactName"),
                request.getParameter("itemContactNumber"), request.getParameter("itemAddressPlaceName"),
                request.getParameter("itemAddressPlaceAddress"), request.getParameter("itemImageAddress"));
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
