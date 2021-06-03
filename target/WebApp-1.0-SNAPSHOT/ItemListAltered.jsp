<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>List Viewer App</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>

<div class="main"><%
    String alterAction = (String) request.getAttribute("alterAction");
    String message;

    if (alterAction.compareTo("new") == 0){
        String isCreated = (String) request.getAttribute("isCreated");

        if (isCreated.compareTo("true") == 0){
            message = "The new list has been successfully created.";
        }

        else {
            message = "An error was faced when creating the new list.";
        }
    }

    else if (alterAction.compareTo("remove") == 0){
        String isRemoved = (String) request.getAttribute("isRemoved");

        if (isRemoved.compareTo("true") == 0){
            message = "The list has been successfully removed.";
        }

        else {
            message = "An error was faced when removing the list.";
        }
    }

    else {
        String isRenamed = (String) request.getAttribute("isRenamed");

        if (isRenamed.compareTo("true") == 0){
            message = "The list has been successfully renamed.";
        }

        else {
            message = "An error was faced when renaming the list.";
        }
    }%>

    <h2><%=message%></h2>
    <a href="index.html">Click here to go back to the main menu.</a>

</div>

</body>

</html>
