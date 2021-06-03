<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Patient Data App</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
<div class="main">
    <h1>Search Result</h1>
    <a href="index.html">Main menu</a><br><br><%

    List<String> searchResult = (List<String>) request.getAttribute("searchResult");

    if(searchResult.isEmpty()){ %>
        <p>There are no results</p> <%
    }

    else{ %>
        <p>There are <%=searchResult.size() / 2%> results</p>
        <p>The item in which a match was found will be loaded when a list below is selected</p>
        <p>Select a list below to view</p> <%
    }

    for (int i = 0; i < searchResult.size(); i+=2){
        String listName = searchResult.get(i);
        String itemIndex = searchResult.get(i+1);
        String display = listName + ",item-" + itemIndex; %>

        <ul>
            <form method="POST" action="/runViewItemList.html">
                <input type="hidden" name="listName" value="<%=listName%>">
                <input type="hidden" name="itemIndex" value="<%=itemIndex%>">
                <input type="submit" value="<%=display%>">
            </form>
        </ul><%
    } %>

</div>
</body>

</html>