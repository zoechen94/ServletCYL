/**
 * 登录
 */
$(function(){
	$(".submit").click(function(){
		 
   var username=document.getElementById("username").value;
   var pass=document.getElementById("pass").value;
   var checkvalue;
//   var check=document.getElementById("checkbox");
//   if(check.checked){
//	    checkvalue=check.value;
//	}
   var check=$("input[id='checkbox']").is(':checked');
   if(check==true){
	   checkvalue=$("input[id='checkbox']").attr('value')
   }
   $.ajax({
	   url: "querylogin", 
	   type:"POST",
	   data : {
		   "username":username,
		   "password":pass,
		   "checkbox":checkvalue,
		   "time":new Date().getTime()
       },
	   dataType:"JSON",
	   async:false,
       success : function(out){
    	   var pathName=window.document.location.pathname; 
    	  var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    	  if(out!=null){
    		  location.href=projectName+"/maindetail";
    	  }else{
    		  alert("查无此人");
    	  }
       },
       error : function(er){
    	   console.log("login.js里进入error回调")
       }
   });
   
	});
});