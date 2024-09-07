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
AdminBean ab = (AdminBean)session.getAttribute("abean");
ArrayList<BookBean> al = (ArrayList<BookBean>)session.getAttribute("alist");
out.println("Page Belongs to: "+ab.getfName()+"<br>");

if(al.size()==0)
{
	out.println("No Books Available...");	
}
else
{
%>
	<table>
	<% 
		Iterator<BookBean> it = al.iterator();
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
				<a href="edit?bCode=<%= bb.getBookCode() %>">Edit</a>
				</td>
				<td>
				<a href="delete?bCode=<%= bb.getBookCode() %>">Delete</a>
				</td>
			</tr>
		<% } %>
	</table>
<% }%>

<a href="addBook.html">Add Book+</a><br>
<a href="logout">Logout</a>
</body>
</html>