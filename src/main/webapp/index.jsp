<%@ page import="com.example.dethi.entity.Account" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Account account = (Account) session.getAttribute("currentAccount");
    boolean isLoggedIn = false;
    if(account!=null){
        isLoggedIn = true;
    }
    String currentUsername = account == null ? "Guest" :account.getUsername();
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%
    if (isLoggedIn){
%>
<strong>This is me: <%=currentUsername%> <a href="/accounts/logout">(Logout)</a></strong>
<%}else {%>
<a href="/accounts/login">Click here to login</a> or <a href="/accounts/register">Create new account</a>
<%}%>
</body>
</html>