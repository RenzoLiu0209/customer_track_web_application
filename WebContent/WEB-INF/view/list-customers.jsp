<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Customers Table</title>
		<!-- reference our style sheet -->
		<link type="test/css" rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css"/>
	</head>
	<body>
		
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
			
				<!-- put new button: Add Customer -->
				<input type="button" value="Add Customer"
					onClick="window.location.href='showFormForAdd';return false;"
					class="add-button"/>
					
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="tCustomer" items="${customers}">
					
						<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tCustomer.id}"/>
						</c:url>
						<!-- construct an "delete" link with customer id -->
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tCustomer.id}"/>
						</c:url>
						<tr>
							<td>"${tCustomer.firstName}"</td>
							<td>"${tCustomer.lastName}"</td>
							<td>"${tCustomer.email}"</td>
							<td>
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}" 
									onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>