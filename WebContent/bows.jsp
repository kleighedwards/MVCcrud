<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Bows</title>
	<link rel="stylesheet" type="text/css" href="bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
</head>
<body id="bowsPage">

		<ul>
			<li><a href="Inventory.do">List All Weapons</a>
			
			<li><a href="goToAdd.do">Add Weapon To Inventory</a></li>
		
			<li><a href="goToInfusion.do">Infuse Weapon</a></li>
		
			<li><a href="goToReinforce.do">Reinforce Weapon</a></li>
		
			<li><a href="sortByClass.jsp">Sort By Weapon Class</a><li>
		</ul>
		
		<br>

	<div class="tableDiv">
	<h2>Bows</h2>


	<table>

	<thead>
			<tr>
				<td>Name</td>
				<td>Base Damage</td>
				<td>Damage Type</td>
				<td>Weapon Class</td>
				<td>Remove from Inventory</td>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="bow" items="${bowList}">
			
			<tr>
				<td>${bow.name}</td>
				<td>${bow.attackRating}</td>
				<td>${bow.damageType}</td>
				<td>${bow.weaponClass}</td>
				<td>
					<form class="removeButton" action="removeBow.do" method="POST">
						<input type="hidden" value="${bow.name}" name="weapon"/>
						<input type="submit" value="Remove"/>
					</form>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	
	<br>
		
</body>
</html>