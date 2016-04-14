//naver_login init
var naver = null;
  $.ajaxSetup({ cache: true });
  $.getScript('https://static.nid.naver.com/js/naverLogin_implicit-1.0.1.js', function(){
	  naver = new naver_id_login("HuF4g6zbRdU8Ap3FKbw2", "http://mongsil311.cafe24.com/");
	  naver.setButton('green', 3, 40);
	  naver.init_naver_id_login();
	  naver.get_naver_userprofile('naver_login()');
  });
  
  function naver_profile(){
		$.ajax({
			url: "https://openapi.naver.com/v1/nid/me",
			type: "GET",
			data: {"access_token":naver.oauthParams.access_token},
			dataType: "jsonp",
			jsonp: "oauth_callback",
			success: function (result) {
				console.log("success");
				console.log(result.response.name);
//				inner_profileParams.age           = result.response.age;
//				inner_profileParams.birthday      = result.response.birthday;
//				inner_profileParams.email         = result.response.email;
//				inner_profileParams.enc_id        = result.response.enc_id;
//				inner_profileParams.gender        = result.response.gender;
//				inner_profileParams.id            = result.response.id;
//				inner_profileParams.nickname      = result.response.nickname;
//				inner_profileParams.profile_image = result.response.profile_image;
			}
		});
  }
  function naver_login(){
	  console.log(naver.getProfileData('id'));
	  console.log(naver.getProfileData('name'));
	  console.log(naver.getProfileData('gender'));
	  console.log(naver.getAccessToken());
	  id = naver.getProfileData('id');
	  name = naver.getProfileData('name');
	  gender = naver.getProfileData('gender');
	}



