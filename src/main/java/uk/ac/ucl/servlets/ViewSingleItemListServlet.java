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

@WebServlet("/runViewItemList.html")
public class ViewSingleItemListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> attributes = getReturnAttributes(request);
        setReturnAttributes(request, attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4), attributes.get(5), attributes.get(6), attributes.get(7));
        sendResponse(request, response);
    }

    private void setReturnAttributes(HttpServletRequest request, String itemLink, String itemText, String itemUrl, String itemContactName, String itemContactNumber, String itemAddressPlaceName, String itemAddressPlaceAddress, String itemImageAddress){
        request.setAttribute("listName", request.getParameter("listName"));
        request.setAttribute("itemIndex", request.getParameter("itemIndex"));
        request.setAttribute("itemLink", itemLink);
        request.setAttribute("itemText", itemText);
        request.setAttribute("itemUrl", itemUrl);
        request.setAttribute("itemContactName", itemContactName);
        request.setAttribute("itemContactNumber", itemContactNumber);
        request.setAttribute("itemAddressPlaceName", itemAddressPlaceName);
        request.setAttribute("itemAddressPlaceAddress", itemAddressPlaceAddress);
        request.setAttribute("itemImageAddress", itemImageAddress);
    }

    private ArrayList<String> getReturnAttributes(HttpServletRequest request) {
        ArrayList<String> attributes = new ArrayList<>();
        Model model = ModelFactory.getModel();
        attributes.addAll(model.viewItemAttributes(request.getParameter("listName"), request.getParameter("itemIndex")));
        return attributes;
    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/EditItemList.jsp");
        dispatch.forward(request, response);
    }
}
