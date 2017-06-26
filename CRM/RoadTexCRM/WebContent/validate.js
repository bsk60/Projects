
function validate() {
    var x = document.forms["signup"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    var pass = document.signup.pwd.value;
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }
    else if(pass == null || pass == ""){
    	alert("Invalid pass")
    	return false;
}

}

function validate2() {
	var clientName = document.updateC.clientName.value;
	var contactName = document.updateC.contactName.value;
	var phone = document.updateC.phone.value;
	var x = document.forms["updateC"]["email"].value;
	var street = document.updateC.street.value;
	var city = document.updateC.city.value;
	var state = document.updateC.state.value;
	var zip = document.updateC.zip.value;
	var offer = document.updateC.offer.value;
	
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }else if(clientName ==  null || clientName == ""){
    	alert("Enter client's name");
    	return false;
    }else if(contactName ==  null || contactName == ""){
    	alert("Enter contact's name");
    	return false;
    }else if(phone ==  null || phone == ""){
    	alert("Enter phone");
    	return false;
    }else if(email ==  null || email == ""){
    	alert("Enter email");
    	return false;
    }else if(street ==  null || street == ""){
    	alert("Enter street");
    	return false;
    }else if(city ==  null || city == ""){
    	alert("Enter city");
    }else if(state ==  null || state == ""){
    	alert("Enter state");
    }else if(zip ==  null || zip == ""){
    	alert("Enter zip");
    }else if(offer ==  null || offer == ""){
    	alert("Enter offer");
    }
	
}