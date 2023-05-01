<%@ page import="java.util.List"%>
<%@ page import="com.khadri.jee.hibernate.integration.entities.Student"%>

<html>
<script type="text/javascript">

function ajaxDeleteForm(rowCount){
	//alert('ajax Invoking '+rowCount);
	var studentId= document.getElementById('stdid'+rowCount).value; 
	
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      alert("Update Successfully");
	    }
	  };
	  xhttp.open("POST", "register?mode=DELETE_RECORD&sId="+studentId, true);
	  xhttp.send();
	
}
</script>

<body bgcolor="#ffff99">
	<%
	List<Student> listOfStudents = (List<Student>) request
			.getAttribute("delete_result");
	%>

	<form action="">
	</table>
			<table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="student_admin.jsp">Go To</a> previous page</td>
			</tr>
		</table>
		<table border="4" id="mydata">
			<tr>
				<td colspan="8" align="center">DELETE STUDENT FORM</td>
			</tr>

			<tr>
				<td align="center">STUDENT ID</td>
				<td align="center">STUDENT NAME</td>
				<td align="center">STUDENT AGE</td>
				<td align="center">STUDENT BRANCH</td>
				<td align="center">STUDENT PHONE NUMBER</td>
				<td align="center">STUDENT PARENT PHONE NUMBER</td>
				<td align="center">STUDENT ADDRESS</td>
				<td align="center">ACTION</td>
			</tr>
			<%
			int inc = 1;
			for (Student student : listOfStudents) {
			%>

			<tr>
				<td><input type="text" id="stdid<%=inc%>"
					value="<%=student.getId()%>" disabled="disabled"></td>
				<td><input type="text" id="stdname<%=inc%>"
					value="<%=student.getStudName()%>" disabled="disabled"></td>
				<td><input type="text" id="stdage<%=inc%>"
					value="<%=student.getStudAge()%>" disabled="disabled"></td>
				<td><input type="text" id="stdbranch<%=inc%>"
					value="<%=student.getStudBranch()%>" disabled="disabled"></td>
				<td><input type="text" id="stdphone<%=inc%>"
					value="<%=student.getStudPhone()%>" disabled="disabled"></td>
				<td><input type="text" id="stdpphone<%=inc%>"
					value="<%=student.getStudParentPhone()%>" disabled="disabled"></td>
				<td><input type="text" id="stdadd<%=inc%>"
					value="<%=student.getStudAddress()%>" disabled="disabled"></td>

				<td><input type="button" value="DELETE RECORD"
					onclick="ajaxDeleteForm(<%=inc%>)"></td>
			</tr>

			<%
			inc++;
			}
			%>

		</table>
		
		</table>
			<table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="student_admin.jsp">Go To</a> previous page</td>
			</tr>
		</table>
	</form>

</body>
</html>
