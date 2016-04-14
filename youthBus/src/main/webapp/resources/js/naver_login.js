//naver_login init
function naver_login(){
	
	var naver_id_login = new naver_id_login("HuF4g6zbRdU8Ap3FKbw2", "http://mongsil311.cafe24.com/");
	naver_id_login.setButton("green", 1,40);
	naver_id_login.setState("abcdefghijkmnopqrst");
	naver_id_login.setPopup();
	naver_id_login.init_naver_id_login();	
	
	naver_id_login.get_naver_userprofile(); 
    id = naver_id_login.getProfileData('id');
    name = naver_id_login.getProfileData('name');
    gender = naver_id_login.getProfileData('gender');

}


