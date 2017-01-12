/**
 * 登录
 */
$(function(){
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	var id=GetQueryString("id");
	var type_id=GetQueryString("type_id");
	var name=GetQueryString("name");
	var price=GetQueryString("price");
	var time=GetQueryString("time");
	$('#bill_id').val(id);
	$('#xiaofei').val(name);
	$('#price').val(price);
	$('#time').val(time);
     $.ajax({
       url: "querytype", 
	   type:"POST",
	   dataType:"JSON",
	   async:false,
       success : function(out){
    	   var json;
    	   var str="";
   	        if(out!=null){
   	            for(var i=0;i<out.length;i++){
   	        	json=out[i];
   	        	str+="<option value='"+json.id+"'>"+json.name+"</option>";
   	            }
   	            $("#type_id").html(str);
   	        }else{
  		        alert("没有");
  	        }
       },
       error : function(er){
   	        console.log("login.js里进入error回调")
       }
    });
     $(".submit").click(function(){
    	
    var a=$("#type_id").val();
    var type_id=$('#type_id option:selected') .val();//选中的值
    var name=$("#xiaofei").val();
    var price=$("#price").val();
    alert("type_id："+type_id+"|name:"+name+"|price:"+price);
    	 updatebill();
    	 function updatebill(){
    		 $.ajax({
    		   url: "updatebill", 
    		   type:"POST",
    		   data : {
    			   "id":id,
    			   "type_id":type_id,
    			   "name":name,
    			   "price":price,
    			   "time":new Date().getTime()
    	       },
    		   dataType:"text",
    		   async:false,
    	       success : function(out){
    	    	   console.log(out)
    	    	  var pathName=window.document.location.pathname; 
    	    	  var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    	    	
    	    		  location.href=projectName+"/billdetail";
    	    	  
    	       },
    	       error : function(er){
    	    	   console.log("login.js里进入error回调")
    	       }
    	   });
    	 }
    		});
});