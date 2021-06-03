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

@WebServlet("/runAlterItemList.html")
public class AlterItemListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();

        if (request.getParameter("alterAction").compareToIgnoreCase("new") == 0) {
            handleNewAction(model, request);
        }
        else if (request.getParameter("alterAction").compareToIgnoreCase("remove") == 0) {
            handleRemoveAction(model, request);
        }
        else {
            handleRenameAction(model, request);
        }

        sendResponse(model, request, response);
    }

    private void handleNewAction(Model model, HttpServletRequest request) {
        boolean isAdded = model.addNewList(request.getParameter("listName"));
        request.setAttribute("alterAction", "new");
        request.setAttribute("isCreated", String.valueOf(isAdded));
    }

    private void handleRemoveAction(Model model, HttpServletRequest request) {
        boolean isRemoved = model.removeList(request.getParameter("listName"));
        request.setAttribute("alterAction", "remove");
        request.setAttribute("isRemoved", String.valueOf(isRemoved));
    }

    private void handleRenameAction(Model model, HttpServletRequest request) {
        boolean isRenamed = model.renameList(request.getParameter("listName"), request.getParameter("newListName"));
        request.setAttribute("alterAction", "rename");
        request.setAttribute("isRenamed", String.valueOf(isRenamed));
    }

    private void sendResponse(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        model.saveToFile();

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/ItemListAltered.jsp");
        dispatch.forward(request, response);
    }
}
