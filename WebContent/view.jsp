<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Andre's Smithy</title>
</head>
<body>
	<h2>Your Inventory</h2>
	
	<c:forEach var="weapon" items="${weaponList}">
		<p>${weapon}</p>
	</c:forEach>
	
	${weaponList[1]}
	
</body>
</html>