/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2021-05-24 14:39:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EditItemList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title>List Viewer App</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<h1>");
      out.print(request.getAttribute("listName"));
      out.write("</h1>\n");
      out.write("<a href=\"index.html\">Main menu</a><br><br>");

    boolean isValidItem = true;
    String linkListName = ((String) request.getAttribute("itemLink"));

    if (linkListName.compareTo("$$DNE$$") != 0){
      out.write("\n");
      out.write("        <p>This item is a link to another list.<br>Click move to view that list.</p>\n");
      out.write("\n");
      out.write("        <form method=\"POST\" action=\"/runViewItemList.html\">\n");
      out.write("            <input type=\"hidden\" name=\"listName\" value=\"");
      out.print(linkListName);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"itemIndex\" value=\"0\">\n");
      out.write("            <input type=\"submit\" value=\"Move\">\n");
      out.write("        </form>");

    }

    if (((String) request.getAttribute("itemText")).compareTo("$$DNE$$") == 0){
        isValidItem = false;
    }

    String listName = (String) request.getAttribute("listName");
    String itemIndexNow = (String) request.getAttribute("itemIndex");
    String itemIndexNext = String.valueOf((Integer.parseInt(itemIndexNow) + 1));
    String itemIndexPrev = String.valueOf((Integer.parseInt(itemIndexNow) - 1));

    String itemText = (String) request.getAttribute("itemText");
    String itemUrl = (String) request.getAttribute("itemUrl");
    String itemContactName = (String) request.getAttribute("itemContactName");
    String itemContactNumber = (String) request.getAttribute("itemContactNumber");
    String itemAddressPlaceName = (String) request.getAttribute("itemAddressPlaceName");
    String itemAddressPlaceAddress = (String) request.getAttribute("itemAddressPlaceAddress");
    String itemImageAddress = (String) request.getAttribute("itemImageAddress");

    if (isValidItem) {
        if (linkListName.compareTo("$$DNE$$") == 0) {
      out.write("\n");
      out.write("            <form method=\"POST\" action=\"/runEditSingleItemList.html\">\n");
      out.write("                <label>Text:</label><br>\n");
      out.write("                <textarea name=\"itemText\" rows=\"10\" cols=\"100\">");
      out.print(itemText);
      out.write("</textarea><br><br>\n");
      out.write("\n");
      out.write("                <label>URL:</label>\n");
      out.write("                <input type=\"text\" name=\"itemUrl\" value=\"");
      out.print(itemUrl);
      out.write('"');
      out.write('>');


                if (!itemUrl.isEmpty()){
      out.write("\n");
      out.write("                    <a href=");
      out.print(itemUrl.strip());
      out.write(">Go to url</a>");

                }
                else { 
      out.write("\n");
      out.write("                    <label>Save changes first to visit url</label>");

                }
      out.write("\n");
      out.write("\n");
      out.write("                <br><br><label>Contact name:</label>\n");
      out.write("\n");
      out.write("                <input type=\"text\" name=\"itemContactName\" value=\"");
      out.print(itemContactName);
      out.write("\">\n");
      out.write("                <label>Contact number:</label>\n");
      out.write("                <input type=\"text\" name=\"itemContactNumber\" value=\"");
      out.print(itemContactNumber);
      out.write("\">\n");
      out.write("\n");
      out.write("                <label>Place name:</label>\n");
      out.write("                <input type=\"text\" name=\"itemAddressPlaceName\" value=\"");
      out.print(itemAddressPlaceName);
      out.write("\">\n");
      out.write("                <label>Place address:</label>\n");
      out.write("                <input type=\"text\" name=\"itemAddressPlaceAddress\" value=\"");
      out.print(itemAddressPlaceAddress);
      out.write('"');
      out.write('>');


                if (!itemAddressPlaceAddress.isEmpty()){
      out.write("\n");
      out.write("                <a href=\"https://www.google.com/maps/dir/?api=1&query&destination=");
      out.print(itemAddressPlaceAddress.strip());
      out.write("\">Get directions</a>");

                }
                else { 
      out.write("\n");
      out.write("                    <label>Save changes first to view directions</label>");

                }
      out.write("\n");
      out.write("\n");
      out.write("                <br><br><label>Image file path:</label>\n");
      out.write("                <input type=\"text\" name=\"itemImageAddress\" value=\"");
      out.print(itemImageAddress);
      out.write("\">\n");
      out.write("                <label>Save changes first to view image</label><br>\n");
      out.write("                <img src=");
      out.print(itemImageAddress);
      out.write(" alt=");
      out.print(itemImageAddress);
      out.write(" style=\"width:200px;height:200px;\"><br><br>\n");
      out.write("\n");
      out.write("                <input type=\"hidden\" name=\"listName\" value=\"");
      out.print(listName);
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"itemIndex\" value=\"");
      out.print(itemIndexNow);
      out.write("\">\n");
      out.write("                <input type=\"submit\" value=\"Save changes\">\n");
      out.write("            </form><br>");

        }
      out.write("\n");
      out.write("\n");
      out.write("        <form method=\"POST\" action=\"/runViewItemList.html\">\n");
      out.write("            <input type=\"hidden\" name=\"listName\" value=\"");
      out.print(listName);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"itemIndex\" value=\"");
      out.print(itemIndexNext);
      out.write("\">\n");
      out.write("            <input type=\"submit\" value=\"Next Item\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <form method=\"POST\" action=\"/runViewItemList.html\">\n");
      out.write("            <input type=\"hidden\" name=\"listName\" value=\"");
      out.print(listName);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"itemIndex\" value=\"");
      out.print(itemIndexPrev);
      out.write("\">\n");
      out.write("            <input type=\"submit\" value=\"Previous Item\">\n");
      out.write("        </form><br>");

    }

    else {
        if (linkListName.compareTo("$$DNE$$") == 0) {
      out.write("\n");
      out.write("            <p>There are no items here</p>");

        }

        if (Integer.parseInt(itemIndexNow) >= 0 && linkListName.compareTo("$$DNE$$") == 0) {
      out.write("\n");
      out.write("            <p>Maybe you would like to create a new item?<br></p>\n");
      out.write("\n");
      out.write("            <form method=\"POST\" action=\"/runAlterItem.html\">\n");
      out.write("                <input type=\"hidden\" name=\"listName\" value=\"");
      out.print(listName);
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"itemIndex\" value=\"");
      out.print(itemIndexNow);
      out.write("\">\n");
      out.write("                <input type=\"text\" name=\"itemLink\" placeholder=\"Name of list to link\" required>\n");
      out.write("                <input type=\"hidden\" name=\"alterAction\" value=\"new\">\n");
      out.write("                <input type=\"submit\" value=\"New Item that is link to another list\">\n");
      out.write("            </form><br>\n");
      out.write("\n");
      out.write("            <form method=\"POST\" action=\"/runAlterItem.html\">\n");
      out.write("                <input type=\"hidden\" name=\"listName\" value=\"");
      out.print(listName);
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"itemIndex\" value=\"");
      out.print(itemIndexNow);
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"itemLink\" value=\"false\">\n");
      out.write("                <input type=\"hidden\" name=\"alterAction\" value=\"new\">\n");
      out.write("                <input type=\"submit\" value=\"New Item that is not a link to another list\">\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <p>NOTE A new list will be created then linked if the name above does not match</p>");

        }

        itemIndexNext = "0";
        itemIndexPrev = "0";

        if (linkListName.compareTo("$$DNE$$") == 0) {
      out.write("\n");
      out.write("            <form method=\"POST\" action=\"/runViewItemList.html\">\n");
      out.write("                <input type=\"hidden\" name=\"listName\" value=\"");
      out.print(listName);
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"itemIndex\" value=\"");
      out.print(itemIndexNext);
      out.write("\">\n");
      out.write("                <input type=\"submit\" value=\"View List again\">\n");
      out.write("            </form>");

        }
    }

    if (itemIndexNow.compareTo("0") != 0 && isValidItem) {
      out.write("\n");
      out.write("        <form method=\"POST\" action=\"/runAlterItem.html\">\n");
      out.write("            <input type=\"hidden\" name=\"listName\" value=\"");
      out.print(listName);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"itemIndex\" value=\"");
      out.print(itemIndexPrev);
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"alterAction\" value=\"remove\">\n");
      out.write("            <input type=\"submit\" value=\"Remove current Item\">\n");
      out.write("        </form>");

    }

    if (itemIndexNow.compareTo("0") == 0) {
      out.write("\n");
      out.write("        <p>The header item cannot be removed!<br>If you would like to remove the list then return to the main menu.</p>");

    }
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}