<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>List Viewer App</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body><%
    String listName = (String) request.getAttribute("listName");
    String itemNumber = (String) request.getAttribute("itemNumber");
    String error = (String) request.getAttribute("error");
    String displayMessage;

    if (error.compareTo("None") == 0){
        displayMessage = "The data has been successfully saved.";
    }

    else {
        displayMessage = error;
    }%>

<h1><%=displayMessage%></h1>

<form method="POST" action="/runViewItemList.html">
    <input type="hidden" name="listName" value="<%=listName%>">
    <input type="text" name="itemNumber" value="<%=itemNumber%>">
    <label>Select OK to continue making changes to the list</label>
    <input type="submit" value="OK"/>
</form>

<a href="index.html">Main Menu</a>

</body>

</html>
