<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>List Viewer App</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
<div class="main">
    <h1>View/Edit a list</h1><%

    List<String> lists = (List<String>) request.getAttribute("listNames");

    if (!lists.isEmpty()) {%>
        <p>Select a list from below to view/edit: </p><%
    }

    else {%>
        <p>There are currently no lists to view/edit. Please create a list first.</p><%
    }

    for (String listName : lists){%>
        <ul>
            <form method="POST" action="/runViewItemList.html">
                <input type="hidden" name="listName" value="<%=listName%>">
                <input type="hidden" name="itemIndex" value="0"/>
                <input type="submit" value="<%=listName%>">
            </form>
        </ul><%
    } %>
</div>
</body>

</html>
