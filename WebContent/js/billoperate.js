/**
artDialog
 */
$(document).ready(function(){
	var check=$("#check").val();
		 $("#check").click(function(){
			 $.ajax({
				   url: "billdetail", 
				   type:"POST",
				   data : {
					   "check":username,
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
