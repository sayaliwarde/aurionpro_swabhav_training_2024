<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=ISO-8859-1>
<title>JSTL Demo</title>
</head>
<body>
<c:out value="sayali"></c:out><p>

<c:set var="name" scope ="session" value="kaivalya"></c:set>
<c:out value="${name}"></c:out><p>

<!-- <% pageContext.setAttribute("number" , 5); %> -->

 <c:set var="number" value="5" />
<c:out value="${number}" />
<c:if test="${number % 2 == 0}">
  <c:out value="Even" />
</c:if><p>

<c:set var="income" scope="session" value="${4000*4}"/> <p> 
<c:out value="${income}"/><p>
<c:choose>  
    <c:when test="${income <= 1000}">  
       Income is not good.  
    </c:when>  
    <c:when test="${income > 10000}">  
        Income is very good.  
    </c:when>  
    <c:otherwise>  
       Income is undetermined...  
    </c:otherwise> 
</c:choose> <p> 

<c:forEach var="i" begin="1" end="3">  
   Item <c:out value="${i}"/><p>  
</c:forEach>

<c:forTokens items="S-a-y-a-l-i" delims="-" var="name">  
   <c:out value="${name}"/><p>  
</c:forTokens> 

<c:import url="NewFile.jsp"/>  
 

</body>
</html>