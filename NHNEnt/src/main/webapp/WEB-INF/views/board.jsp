<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
 	<link rel="stylesheet" type="text/css" href="resources/css/board.css">
	<script type="text/javascript" src="resources/js/board.js"></script>
  	<title>Board</title>
</head>
<body>
	<div id="board_stream">
		<div id="writer" class="board">
   	  		<form id="board_form" name="board_form" onsubmit="return chkEmail();" method="post">
        		<input type="text" name="email" placeholder="email"/>
       			<input type="password" name="password" placeholder="password"/>
	        	<input type="submit" value="등록"/>
		        <textarea name="body"></textarea>
	      	</form>
	    </div>
	    
	    <c:if test="${not empty requestScope.boardList || fn:length(requestScope.boardList) > 0}">
	    	<c:forEach var="board" items="${boardList}">
	    		<div class="board">
	    			<form action="updateBoard" method="POST">
   			 			<div class="board-frame" data-no="${board.boardNo}">
	  						<div class="email">
	   							E-mail: ${board.email}
	    						<input type="button" value="수정" class="modify">     
	    						<input type="hidden" name="boardno" value="${board.boardNo}">
	  						</div>
						  	<div class="createDate">
						    	생성일: ${board.createTime}
						  	</div>
						  	<div class="modificationDate">
						    	수정일: ${board.modificationTime}
						  	</div> 
						  	<div class="body">
						  		${board.body}
						  	</div>
						</div>
					</form>
			    </div>
	    	</c:forEach>
	    </c:if>
   	</div>
</body>
</html>