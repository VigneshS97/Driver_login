/**
 * 
 */
 function validation(){
 				/*header('Content-Type: application/javascript');*/
 
 
 if(document.getElementById('driverLoginId').value == undefined ||
 	 document.getElementById('driverLoginId').value == ''){
           alert('Please Fill Valid LoginId');
           return;
       }
       if(document.getElementById("Password").value==undefined || 
       	document.getElementById("Password").value=="" || 
       	document.getElementById("Password").value.length <10){
           alert("Please File Valid Password");
           return;
       }
       
       
       var formData = {
    		loginId : $("#driverLoginId").val(),
    		password :  $("#Password").val()
    	}
    	
       
//       $.ajax({
//			type : 'POST',
//			contentType : 'application/json',
//			url :  'http://localhost:8083/authenticate',
//			data : JSON.stringify(formData),
//			dataType : 'json',
//			success : function() {
//				alert("success");
//		
//				window.location.href = "http://localhost:8083/notification"; 
//		
//
//			},
//			error : function() {
//				alert("Error!")
//				
//			}
//		});
var xhr = new XMLHttpRequest();
    xhr.open("POST", 'http://localhost:8083/authenticate', true);
    xhr.setRequestHeader("Content-Type", "application/json");
    
    //email should be case sensitive?
    xhr.send(JSON.stringify(formData));

 

    xhr.onreadystatechange = function() {
    	
    	if(xhr.readyState == 4&& xhr.status ==200) {
    	
    	   }
    }

 }
 
 
 
    
    function storeTokenInLocal(token){
    	return window.localStorage.setItem("token",token);
    	
    }
    
    function getTokenFromLocal(){
    	
    	return window.localStorage.getItem(token);
    	
    }
    
     
//    	let data= response.json();
//    	return data;
//    }
    
    