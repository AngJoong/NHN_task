<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	    <div class="board">
	    </div>
   	</div>
</body>
</html>