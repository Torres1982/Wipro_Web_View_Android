// Validation of HTML input fields
function validateFields() {
	var first_name = document.getElementById("first-name");
	var surname = document.getElementById("surname");
	var email = document.getElementById("email");
  	var dob = document.getElementById("date-of-birth");
	var gender = $("input[name='gender']:checked");

	if (first_name.value.length < 2) {
	    Android.validate("Provide your First Name, please!");
	} else if (surname.value.length < 2) {
		Android.validate("Provide your Surname, please!");
	} else if (!validateEmail(email.value)) {
		Android.validate("Provide Correct Format Email, please!");
	} else if (gender.length === 0) {
		Android.validate("Select Gender, please!");
	} else if (dob.value == "") {
    	Android.validate("Select Date of Birth, please!");
  	} else {
  	    var gender_selected = gender.val();
  	    var message = "Are you sure you want to submit your data?";
		Android.confirmSubmission(message, first_name.value, surname.value, email.value, dob.value, gender_selected);
	}
}

// Simple email validation
function validateEmail(email) {
	var email_regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	return email.match(email_regex);
}

// Prepopulate input text fields with values passed from the Android
function callMe(name, email, dob, gender) {
    document.getElementById("full-name_second").value = name;
    document.getElementById("email_second").value = email;
    document.getElementById("date-of-birth-second").value = dob;
    document.getElementById("gender-second").value = gender;
}

// Prepopulate input text fields with values passed from the Android
function prepopulateSecondWebViewName(name) {
    document.getElementById("full-name_second").value = name;
}
function prepopulateSecondWebViewEmail(email) {
    document.getElementById("email_second").value = email;
}
function prepopulateSecondWebViewBirthDate(dob) {
    document.getElementById("date-of-birth-second").value = dob;
}
function prepopulateSecondWebViewGender(gender) {
        document.getElementById("gender-second").value = gender;
}

// Toggle for the mobile menu button
$('.mobile-menu-icon').click(function() {
	var navigation = $('.main-nav');
	navigation.slideToggle(250);
});
