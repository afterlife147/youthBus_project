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

/*window.fbAsyncInit = function() {
	FB.init({
		appId : '856055527837167',
		xfbml : true,
		version : 'v2.5'
	});
};

(function(d, s, id) {
	var js;
	var fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/ko_KR/all.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));*/


function statusChangeCallback(response) {
	console.log('statusChangeCallback');
	console.log(response);

	if (response.status === 'connected') {
		// 페이스북 로그인 ok , 앱 로그인 ok
		facebooklogin();
		//$(location).attr('href' , '/index');
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
			$.post("/index", {"id": user.id, "name": user.name, "gender": user.gender});
			/*
			 * // $.post("./fbloginprocess.jsp", { "userid": user.id,
			 * "username": user.name, "fbaccesstoken":accessToken} function
			 * (responsephp) { //댓글을 처리한 다음 해당 웹페이지를 갱신 시키기 위해 호출.
			 * location.replace('./main.jsp'); } );
			 */
		});
	}, { scope : 'public_profile'} );
}