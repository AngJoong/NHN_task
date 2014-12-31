$( document ).ready(function() {
 
    $(".modify").click(function( event ) {
    	var $boardFrame = $(this).closest(".board-frame");
    	var $body = $boardFrame.children(".body");
    	var $resultBt = $boardFrame.find(".result");
    	var $textArea = $boardFrame.children("textarea");
    	
	   	 if($body.css("display") != "none"){
	     	var password = prompt("password를 입력하세요");
	    	var content = $body.text().trim();
	    	var boardNo = $boardFrame.data("no");    	

	   		$.ajax({
	    		  url: "checkPassword",
	    		  type: "get",
	    		  data: { "boardNo": boardNo, "password": password },
	    		  dataType: "text"
	    		})
	    		  .done(function( data ) {
	    		    if (data == "true") {
	    		    	$textArea.text(content);
	    		    	$body.toggle();
	    		    	$resultBt.toggle();
	    		    	$textArea.toggle();
	    		    }else{
	    		    	alert("password가 틀렸습니다.");
	    		    }
	    		});
	   	 }else{
	    	$body.toggle();
	    	$resultBt.toggle();
	    	$textArea.toggle(); 
	   	 }    		
    });
 
});


function chkEmail(){
	  var email = board_form.email.value;
	  var regExp = /\w+@\w+\.\w+/;
    			  
	  if(regExp.test(email)){
	    board_form.action = "insertBoard";
	    return true;
	  }else{
	    alert("Email형식이 아닙니다.");
			    return false;
	  }
} 
