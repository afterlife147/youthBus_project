function currchange(dn){
	var state = dn;

	switch(state){
		case 0:
			$("#index").css("color" , "#04adc0");
			$("#y_bus").css("color" , "black");
			$("#y_story").css("color" , "black");
			$("#y_helper").css("color" , "black");
			break;
		case 2:
			$("#index").css("color" , "black");
			$("#y_bus").css("color" , "#04adc0");
			$("#y_story").css("color" , "black");
			$("#y_helper").css("color" , "black");
			
			break;
		case 4:
			$("#index").css("color" , "black");
			$("#y_bus").css("color" , "black");
			$("#y_story").css("color" , "#04adc0");
			$("#y_helper").css("color" , "black");
			break;
		case 6:
			$("#index").css("color" , "black");
			$("#y_bus").css("color" , "black");
			$("#y_story").css("color" , "black");
			$("#y_helper").css("color" , "#04adc0");
			
			break;
		}
}

//window.onload = function() { init(); }
//		function init(){
//			
//
//
//			var menu = document.getElementById("menu");
//			menuArray = menu.getElementsByTagName("li");
//
//			menuArray[0].onclick = function() { currchange(0)};
//			menuArray[2].onclick = function() { currchange(2)};
//			menuArray[4].onclick = function() { currchange(4)};
//			menuArray[6].onclick = function() { currchange(6)};
//				
//			menuArray[0].click();
//			}
//			
//		function currchange(dn){
//			var state = dn;
//	
//			switch(state){
//				case 0:
//					document.getElementById("t0").style.color = "#04adc0";
//					document.getElementById("t1").style.color = "black";
//					document.getElementById("t2").style.color = "black";
//					document.getElementById("t3").style.color = "black";
//					break;
//				case 2:
//					document.getElementById("t1").style.color = "#04adc0";
//					document.getElementById("t0").style.color = "black";
//					document.getElementById("t2").style.color = "black";
//					document.getElementById("t3").style.color = "black";
//					
//					break;
//				case 4:
//					document.getElementById("t2").style.color = "#04adc0";
//					document.getElementById("t0").style.color = "black";
//					document.getElementById("t1").style.color = "black";
//					document.getElementById("t3").style.color = "black";
//					break;
//				case 6:
//					document.getElementById("t3").style.color = "#04adc0";
//					document.getElementById("t0").style.color = "black";
//					document.getElementById("t1").style.color = "black";
//					document.getElementById("t2").style.color = "black";
//					
//					break;
//				}
//			}