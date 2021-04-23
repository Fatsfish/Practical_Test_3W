<%-- 
    Document   : index
    Created on : Apr 23, 2021, 7:12:44 PM
    Author     : User-PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Page</title>
    </head>
    <body>
        <form action="AddController">
            ID <input type="text" name="ID" placeholder="F-XXX" required="" pattern="^F-[0-9]{3}$"></br>
            Name <input type="text" name="Name" placeholder="Food name" required=""></br>
            Description <input type="text" name="Description" placeholder="Description" required=""></br>
            Price <input type="number" name="Price" placeholder="Price"></br>
            Cooking Time<input type="number" name="CookingTime" placeholder="Cooking Time"></br>
            Create Date<input type="datetime-local" name="CreateDate" placeholder="Current Date and Time"></br>
            <input type="submit" value="Add">
            <input type="reset" value="Reset">
        </form>
        <form action="SearchController">
            Search <input type="text" name="search" placeholder="Name of food" value="${param.search}"></br>
            <select name="Status">
                <option value="Available">Available food</option>
                <option value="Deleted">Deleted food</option>
            </select>
            <input type="submit" value="Search">
            <input type="reset" value="Reset">
            <c:if test="${not empty sessionScope.LIST}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Cooking Time</th>
                            <th>Create Date</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="food" items="${sessionScope.LIST}" varStatus="counter">
                        <form action="UpdateController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    ${food.ID}
                                    <input type="hidden" name="ID" placeholder="F-XXX" required="" pattern="^F-[0-9]{3}$" value="${food.ID}"></td>
                                <td>
                                    <input type="text" name="Name" placeholder="Food name" required="" value="${food.Name}"></br></td>
                                <td>
                                    <input type="text" name="Description" placeholder="Description" required="" value="${food.Description}"></br></td>
                                <td>
                                    <input type="number" name="Price" placeholder="Price" value="${food.Price}"></br></td>
                                <td>
                                    <input type="number" name="CookingTime" placeholder="Cooking Time" value="${food.CookingTime}"></br></td>
                                <td>
                                    <input type="datetime-local" name="CreateDate" placeholder="Current Date and Time" value="${food.CreateDate}"></br></td>
                                <td>
                                    <input type="submit" name="action" value="Delete"</td>
                                <td>
                                    <input type="submit" name="action" value="Update"</td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </form>
    </body>
</html>
