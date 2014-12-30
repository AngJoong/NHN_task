<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<meta charset="utf-8">
<!-- 	<link rel="stylesheet" type="text/css" href="../css/board.css">
	<script type="text/javascript" src="../js/board.js"></script>
	 -->
 	<style type="text/css">
		html, body
		{
		    height: 100%;
		}
		
		#board_stream{
		  background-color: white;
		  border: solid 1px grey;
		  width: 60%;
		  height: 100%;
		  margin: auto;
		  padding: 10px;
		}
		
		.board{
		  position: relative;
		  background-color: white;
		  width: 100%;
		  height: 100px;
		  margin: 0px auto 10px auto;
		  border: solid 1px grey;
		}
		
		input{
		  margin: 5px;
		}
		
		textarea{
		  width: 97%;
		  height: 55px;
		  margin-left: 5px;
		}
		
		.head{
		  width: 100%;
		  height: 30%;
		  background-color: red;
		}
		
		.body{
		  width: 100%;
		  height: 70%;
		  background-color: blue;
		}
		
		.email{  
		  display: inline-block;
		  width: 50%;
		}
		
		.createDate{
		  display: inline-block;
		  width: 20%;
		}
		
		.modificationDate{
		  display: inline-block;
		  width: 20%;
		}
 	</style>
	<script type="text/javascript">
		function chkEmail(){
			  var email = board_form.email.value;
			  var regExp = /\w+@\w+\.\w+/;
			    			  
			  if(regExp.test(email)){
			    board_form.action = "/task/insertBoard";
			    return true;
			  }else{
			    alert("Email형식이 아닙니다.");
			    return false;
			  }
		} 
 	</script> 
  	<title>Board</title>
</head>
<body>
	<div id="board_stream">
		<div id="writer" class="board">
   	  		<form id="board_form" name="board_form" onsubmit="return chkEmail();" method="post">
        		<input type="text" name="email" placeholder="email">
        		</input>
       			<input type="password" name="password" placeholder="password">
	        	</input>
	        	<input type="submit" value="등록">
        		</input>
		        <textarea name="body">
		        </textarea>
	      	</form>
	    </div>
	    
	    <c:if test="${not empty requestScope.boardList || fn:length(requestScope.boardList) > 0}">
	    	<c:forEach var="board" items="${boardList}">
	    		<div class="board">
			      	<div class="head">
				        <div class="email">
				          E-mail: ${board.email}
				        </div>
				        <div class="createDate">
				                  생성일: ${board.createTime }
				        </div>
<!-- 				        <div class="modificationDate">
				          수정일
				        </div> -->
				                <input type="submit" value="수정">
				      	</div>
			      	<div class="body">
				        ${board.body}
		    	  	</div>
			    </div>
	    	</c:forEach>
	    </c:if>
	    
	    

   	</div>
</body>
</html>