
$( document ).ready(function() {
 
    $(".modify").click(function( event ) {
    	
    	var $boardFrame = $(this).closest(".board-frame");
    	var content;
    	var password = prompt("password를 입력하세요");
    	
        	var $body = $boardFrame.children(".body");
        	var boardNo = $boardFrame.data("no");    	
        	content = $body.text();
        	
        	$.ajax({
      		  url: "checkPassword",
      		  type: "get",
      		  data: { "boardNo": boardNo, "password": password },
      		  dataType: "text"
      		})
      		  .done(function( data ) {
      			console.log(data)
      		    if (data == "true") {
      	        	$boardFrame.children(".body").replaceWith("<textarea name='body'>"+content.trim()+"</textarea>");  	
      	        	$boardFrame.children(".email").append("<input type='submit' class='result' value='완료'>");
      		    }
      		});
//        	content = $boardFrame.children("textarea").val();
//        	$boardFrame.children("textarea").replaceWith("<div class='body'>"+content+"</textarea>");  	    		
    });
 
});


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

