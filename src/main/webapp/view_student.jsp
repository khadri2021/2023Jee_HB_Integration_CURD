<%@ page import="com.khadri.jee.hibernate.integration.entities.Student"%>
<%@ page import="java.util.Objects"%>

<html>
<script type="text/javascript">

// function ajaxSearchForm(){
// 	var studentId= document.getElementById('stdid').value;
	 	
// 	var xhttp = new XMLHttpRequest();
// 	  xhttp.onreadystatechange = function() {
// 	    if (this.readyState == 4 && this.status == 200) {
// 	     // alert("Search Successfully");
// 	    }
// 	  };
// 	  xhttp.open("POST", "register?mode=SEARCH&sId="+studentId, true);
// 	  xhttp.send();
	
// }


</script>
<body bgcolor="#80ffff">
	<form action="register">
	</table>
			<table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="student_admin.jsp">Go To</a> previous page</td>
			</tr>
		</table>
		<table border="4">
		
			<tr>
				<td colspan="2" align="center">VIEW STUDENT FORM</td>
			</tr>
			<tr>
				<td>STUDENT ID :</td>
				<td><input type="text"  name="stdid" placeholder="enter id for search"></td>
			</tr>
			 
			<tr>
				<td colspan="7" align="center"><input type="submit"  value="Search Record" ></td>
			</tr>
			<input type="hidden"  name="mode" value="SEARCH">
			<% Student searchRecord = (Student)request.getAttribute("search_result"); %>
			
			<%if(Objects.nonNull(searchRecord)){ %>
		
			<tr>
				<td align="center">STUDENT ID</td>
				<td align="center">STUDENT NAME</td>
				<td align="center">STUDENT AGE</td>
				<td align="center">STUDENT BRANCH</td>
				<td align="center">STUDENT PHONE NUMBER</td>
				<td align="center">STUDENT PARENT PHONE NUMBER</td>
				<td align="center">STUDENT ADDRESS</td>
			</tr>
			
			<tr>
				<td align="center"><%=searchRecord.getId() %></td>
				<td align="center"><%=searchRecord.getStudName() %></td>
				<td align="center"><%=searchRecord.getStudAge() %></td>
				<td align="center"><%=searchRecord.getStudBranch()%></td>
				<td align="center"><%=searchRecord.getStudPhone()%></td>
				<td align="center"><%=searchRecord.getStudParentPhone() %></td>
				<td align="center"><%=searchRecord.getStudAddress() %></td>
			</tr>
			
			<%}else{ %>
			<tr>
				<td align="center">STUDENT ID</td>
				<td align="center">STUDENT NAME</td>
				<td align="center">STUDENT AGE</td>
				<td align="center">STUDENT BRANCH</td>
				<td align="center">STUDENT PHONE NUMBER</td>
				<td align="center">STUDENT PARENT PHONE NUMBER</td>
				<td align="center">STUDENT ADDRESS</td>
			</tr>
			
			<tr bgcolor="red">
			   <td colspan="7" align="center">No Record Found </td>
			</tr>
			
			<%} %>
				
		</table>
			<table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="student_admin.jsp">Go To</a> previous page</td>
			</tr>
		</table>

	</form>

</body>
</html>
