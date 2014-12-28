function chkEmail(){
  var email = board_form.email.value;
  var regExp = /\w+@\w+\.\w+/;
    
  alert("A");
  
  if(regExp.test(email)){
    board_form.action = "/insertBoard";
    alert();
    return true;
  }else{
    alert("Email형식이 아닙니다.");
    return false;
  }
}