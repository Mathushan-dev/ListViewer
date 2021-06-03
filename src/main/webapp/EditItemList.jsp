<%@ page contentType="text/html;charset=UTF-8"%>

<html>

<head>
    <title>List Viewer App</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
<h1><%=request.getAttribute("listName")%></h1>
<a href="index.html">Main menu</a><br><br><%
    boolean isValidItem = true;
    String linkListName = ((String) request.getAttribute("itemLink"));

    if (linkListName.compareTo("$$DNE$$") != 0){%>
        <p>This item is a link to another list.<br>Click move to view that list.</p>

        <form method="POST" action="/runViewItemList.html">
            <input type="hidden" name="listName" value="<%=linkListName%>">
            <input type="hidden" name="itemIndex" value="0">
            <input type="submit" value="Move">
        </form><%
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
        if (linkListName.compareTo("$$DNE$$") == 0) {%>
            <form method="POST" action="/runEditSingleItemList.html">
                <label>Text:</label><br>
                <textarea name="itemText" rows="10" cols="100"><%=itemText%></textarea><br><br>

                <label>URL:</label>
                <input type="text" name="itemUrl" value="<%=itemUrl%>"><%

                if (!itemUrl.isEmpty()){%>
                    <a href=<%=itemUrl.strip()%>>Go to url</a><%
                }
                else { %>
                    <label>Save changes first to visit url</label><%
                }%>

                <br><br><label>Contact name:</label>

                <input type="text" name="itemContactName" value="<%=itemContactName%>">
                <label>Contact number:</label>
                <input type="text" name="itemContactNumber" value="<%=itemContactNumber%>">

                <label>Place name:</label>
                <input type="text" name="itemAddressPlaceName" value="<%=itemAddressPlaceName%>">
                <label>Place address:</label>
                <input type="text" name="itemAddressPlaceAddress" value="<%=itemAddressPlaceAddress%>"><%

                if (!itemAddressPlaceAddress.isEmpty()){%>
                <a href="https://www.google.com/maps/dir/?api=1&query&destination=<%=itemAddressPlaceAddress.strip()%>">Get directions</a><%
                }
                else { %>
                    <label>Save changes first to view directions</label><%
                }%>

                <br><br><label>Image file path:</label>
                <input type="text" name="itemImageAddress" value="<%=itemImageAddress%>">
                <label>Save changes first to view image</label><br>
                <img src=<%=itemImageAddress%> alt=<%=itemImageAddress%> style="width:200px;height:200px;"><br><br>

                <input type="hidden" name="listName" value="<%=listName%>">
                <input type="hidden" name="itemIndex" value="<%=itemIndexNow%>">
                <input type="submit" value="Save changes">
            </form><br><%
        }%>

        <form method="POST" action="/runViewItemList.html">
            <input type="hidden" name="listName" value="<%=listName%>">
            <input type="hidden" name="itemIndex" value="<%=itemIndexNext%>">
            <input type="submit" value="Next Item">
        </form>

        <form method="POST" action="/runViewItemList.html">
            <input type="hidden" name="listName" value="<%=listName%>">
            <input type="hidden" name="itemIndex" value="<%=itemIndexPrev%>">
            <input type="submit" value="Previous Item">
        </form><br><%
    }

    else {
        if (linkListName.compareTo("$$DNE$$") == 0) {%>
            <p>There are no items here</p><%
        }

        if (Integer.parseInt(itemIndexNow) >= 0 && linkListName.compareTo("$$DNE$$") == 0) {%>
            <p>Maybe you would like to create a new item?<br></p>

            <form method="POST" action="/runAlterItem.html">
                <input type="hidden" name="listName" value="<%=listName%>">
                <input type="hidden" name="itemIndex" value="<%=itemIndexNow%>">
                <input type="text" name="itemLink" placeholder="Name of list to link" required>
                <input type="hidden" name="alterAction" value="new">
                <input type="submit" value="New Item that is link to another list">
            </form><br>

            <form method="POST" action="/runAlterItem.html">
                <input type="hidden" name="listName" value="<%=listName%>">
                <input type="hidden" name="itemIndex" value="<%=itemIndexNow%>">
                <input type="hidden" name="itemLink" value="false">
                <input type="hidden" name="alterAction" value="new">
                <input type="submit" value="New Item that is not a link to another list">
            </form>

            <p>NOTE A new list will be created then linked if the name above does not match</p><%
        }

        itemIndexNext = "0";
        itemIndexPrev = "0";

        if (linkListName.compareTo("$$DNE$$") == 0) {%>
            <form method="POST" action="/runViewItemList.html">
                <input type="hidden" name="listName" value="<%=listName%>">
                <input type="hidden" name="itemIndex" value="<%=itemIndexNext%>">
                <input type="submit" value="View List again">
            </form><%
        }
    }

    if (itemIndexNow.compareTo("0") != 0 && isValidItem) {%>
        <form method="POST" action="/runAlterItem.html">
            <input type="hidden" name="listName" value="<%=listName%>">
            <input type="hidden" name="itemIndex" value="<%=itemIndexPrev%>">
            <input type="hidden" name="alterAction" value="remove">
            <input type="submit" value="Remove current Item">
        </form><%
    }

    if (itemIndexNow.compareTo("0") == 0) {%>
        <p>The header item cannot be removed!<br>If you would like to remove the list then return to the main menu.</p><%
    }%>

    </body>

</html>