<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.nit.beans.*"
    import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
ArrayList<BookBean> al1 = (ArrayList<BookBean>)session.getAttribute("alist");
out.println("Page Belongs to: "+cb.getFullName()+"<br>");

if(al1.size()==0)
{
	out.println("No Books Available...");	
}
else
{
%>
	<table border="1">
	<% 
		Iterator<BookBean> it = al1.iterator();
		while(it.hasNext())
		{ 
			BookBean bb = (BookBean)it.next();
		%>
			<tr style="background-color: lime;">
				<td>
				<% out.println(bb.getBookCode()); %>
				</td>
				<td>
				<% out.println(bb.getBookName());  %>
				</td>
				<td>
				<% out.println(bb.getBookAuthor()); %>
				</td>
				<td>
				<% out.println(bb.getBookPrice()); %>
				</td>
				<td>
				<% out.println(bb.getBookQty()); %>
				</td>
				<td>
				<a href="buy?bCode=<%= bb.getBookCode() %>">Buy</a>
				</td>
			</tr>
		<% } %>
	</table>
<% }%>
<a href="custLogout">Logout</a>
</body>
</html>