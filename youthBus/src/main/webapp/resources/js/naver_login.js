//naver_login init
var naver = null;
  $.ajaxSetup({ cache: true });
  $.getScript('./resources/js/naverLogin_implicit-1.0.1.js', function(){
	  naver = new naver_id_login("HuF4g6zbRdU8Ap3FKbw2", "http://mongsil311.cafe24.com/naver_login");
	  naver.setButton('green', 3, 40);
	  naver.setPopup('true');
	  naver.init_naver_id_login();
	  naver.get_naver_userprofile(profileCallback);
  });
  
  
  function profileCallback(){
  	  console.log(naver.getProfileData('id'));
  	  console.log(naver.getProfileData('name'));
  	  console.log(naver.getProfileData('gender'));	
	  var param = {"id" : naver.getProfileData('id'), "name" : naver.getProfileData('name'), "gender" : naver.getProfileData('gender')};
	  $.ajax({
			url : "http://mongsil311.cafe24.com/memberAjax",
			type : 'POST',
			data : param,
			success : function(){
				$(opener.location).attr("href","/index");
				self.close();
			}
		});
  }


