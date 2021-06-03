<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>
    <title>List Viewer App</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
<div class="main">
    <h1>Remove a list</h1><%

    List<String> lists = (List<String>) request.getAttribute("listNames");

    if (!lists.isEmpty()) { %>
        <p>Select a list from below to remove: </p> <%
    }

    else { %>
    <p>There are currently no lists to remove. Please create a list first.</p> <%
    }

    for (String list : lists){ %>
        <ul>

            <form method="POST" action="/runAlterItemList.html">
                <input type="hidden" name="listName" value="<%=list%>">
                <input type="hidden" name="alterAction" value="remove"/>
                <input type="submit" value="<%=list%>">
            </form>
        </ul> <%
    } %>

</div>
</body>

</html>
