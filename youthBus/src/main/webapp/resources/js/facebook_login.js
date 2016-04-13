//SDK 초기화
$(document).ready(function() {
  $.ajaxSetup({ cache: true });
  $.getScript('//connect.facebook.net/ko_KR/sdk.js', function(){
    FB.init({
      appId: '856055527837167',
      xfbml : true,
      cookie : true,
      version: 'v2.5' // or v2.0, v2.1, v2.2, v2.3
    });
  });
});

function statusChangeCallback(response) {
	console.log('statusChangeCallback');
	console.log(response);

	if (response.status === 'connected') {
		// 페이스북 로그인 ok , 앱 로그인 ok
		facebooklogin();
	} else if (response.status === 'not_authorized') {
		// 페이스북 로그인 ok , 앱 로그인 no
		facebooklogin();
	} else { 
		//unknown 페이스북 로그인 no , 앱 로그인 no
		facebooklogin();
	}
}

function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

function facebooklogin() {
	FB.login(function(response) {
		var accessToken = response.authResponse.accessToken;
		FB.api('/me', 'get', {
			access_token : accessToken,
			fields : 'id, name, gender'
		}, function(user) {
			console.log(user.id, user.name, user.gender);
			var param = {"id" : user.id, "name" : user.name, "gender" : user.gender};
			$.ajax({
				url : "http://mongsil311.cafe24.com/memberAjax",
				type : 'POST',
				data : param,
				success : function(){
					$(location).attr('href', "/index");
				}
			});

		});
	}, { scope : 'public_profile'} );
}