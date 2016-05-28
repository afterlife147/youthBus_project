$(document).ready(function(){
	var bIndex = 0;
	var insert_rIndex;
	var insert_rId;
	var insert_rName = $("#nickName").val();
	var height;
	var width;
	var testHeight = $(window).height();
	var bucketArray = [];
	$("#bucketBox").css("width", "1200px");
	$("#bucketBox").css("height", $(window).height());
	
	jQuery.fn.center = function () {
	    this.css("position","absolute");
	    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
	    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
	    return this;
	}
	function bucketDTO(bIndex, bName, bDate, bImage, bContent, bLike, bReply, bId){
		var _bName = bName;
		var _bDate = bDate;
		var _bImage = bImage;
		var _bContent = bContent;
		var _bLike = bLike;
		var _bReply = bReply;
		var _bIndex = bIndex;
		var _bId = bId;
		
		this.getbName = _bName;
		
		this.getbImage = _bImage;
		
		this.getbContent = _bContent;
		
		this.getbLike = _bLike;
		
		this.getbDate = _bDate;
		
		this.getbReply = _bReply;
		
		this.getbIndex = _bIndex;
		
		this.getbId = _bId;
	}
	//	�뜝�럥�몥�뜝�럩逾졾뜝�럡�댉 �뜝�룞�삕�뜝�럩�쟼�뜝�럥諭�
	// http://mongsil311.cafe24.com/resources/bucket_image/ �뜝�럡�맋�뵓怨ㅼ삕 �뜝�럩逾졿쾬�꼶梨룟뜝占� �썒�슣�닔占쎄틬
	$.ajax({
		url : "http://mongsil311.cafe24.com/selectBucket",
		type : 'POST',
		data : {"bIndex" : bIndex},
		datatype : 'json',
		success : function(data){
			for(var i = 0; i < data.length; i++)
			{
				$("#bucketBox").append("<div id='bucket" + i +"'></div>");
				$("#bucket"+i).css("background-color", "#F6F6F6").css("border-radius","3px").css("position" , "relative");
				$("#bucket"+i).css("width", "350px").css("height", "350px").css("float", "left").css("margin-left", "30px").css("margin-bottom", "30px");
				$("#bucket"+i).append("<div class='bName'>" + data[i].bName + "</div>");
				$("#bucket"+i).append("<div class='bDate'>" + data[i].bDate + "</div>");
				$("#bucket"+i).append("<div class='bImage'><img src='http://mongsil311.cafe24.com/resources/bucket_image/" + data[i].bImage + "'</div>");
				$("#bucket"+i).append("<div class='bContent'>" + data[i].bContent + "</div>");
				$("#bucket"+i).append("<div class='bLike'><img src='http://mongsil311.cafe24.com/resources/img/bSmile.png'/>" + data[i].bLike + "</div>");
				$("#bucket"+i).append("<div class='bReply'><img src='http://mongsil311.cafe24.com/resources/img/bReply.png'/>" + data[i].bReply + "</div>");
				$("#bucket"+i).append("<input type='hidden' value='"+i+"'/>");
				$("#bucket"+i).append("<input type='hidden' id='bIndex' value='"+data[i].bIndex+"'/>");
				$("#bucket"+i).append("<input type='hidden' id='bId' value='"+data[i].bId+"'/>");
				$("#bucket"+i).append("<input type='hidden' id='bName' value='"+data[i].bName+"'/>");
				height = $(".bContent").height() / 2;
				width = $(".bContent").width() / 2;
				bucketArray[i] = new bucketDTO(data[i].bIndex, data[i].bName, data[i].bDate, data[i].bImage, data[i].bContent, data[i].bLike, data[i].bReply, data[i].bId);
				$(".footerTest").css("position", "absolute");
				$(".footerTest").css("float", "block");
				
				$("#bucket"+i).click(function(){
					var index =  $(this).find('input:hidden').val();
					var bIndex = $(this).find('#bIndex').val();
					var bId = $(this).find('#bId').val();
					var bName = insert_rName;
					openLayer(index, bIndex, bId, bName);
				});
			}
//		if(data.length == 20){
//			$("#bucketBox").append("<div id='more'></div>");
//			$("#more").css("background-color", "#F6F6F6").css("border-radius","3px").css("position" , "relative");
//			$("#more").css("width", "350px").css("height", "350px").css("float", "left").css("margin-left", "30px").css("margin-bottom", "30px");
//			$("#more").append("<div class='bName'></div>");
//			$("#more").append("<div class='bDate'></div>");
//			$("#more").append("<div class='bImage'></div>");
//			$("#more").append("<div class='bContent'>더 보기</div>");
//			$("#more").append("<div class='bLike'></div>");
//			$("#more").append("<div class='bReply'></div>");
//		}
		
		function openLayer(IdName, bIndex, bId, bName){
			insert_rIndex = bIndex;
			insert_rId = bId;
			insert_rName = bName;
			$("#layerPop").center();
			$("#layerPop").css("display", "block");
			$(".inner_bucket").append("<div class='layerName'>" + bucketArray[IdName].getbName + "</div>");
			$(".inner_bucket").append("<div class='layerDate'>" + bucketArray[IdName].getbDate + "</div>");
			$(".inner_bucket").append("<div class='layerImg'><img src='http://mongsil311.cafe24.com/resources/bucket_image/" + bucketArray[IdName].getbImage + "'</div>");
			$(".layerImg").append("<div class='bContent'>" + bucketArray[IdName].getbContent + "</div>").css("position", "relative");
			$(".layerImg img").css("height" , "375px").css("width" , "380px");
			$(".layerImg .bContent").css("position" , "absolute").css("top" , "50%").css("left" , "50%").css("margin-left", -width).css("margin-top", -height).css("background-color", "rgba(0,0,0,0.5)").css("color", "white").css("font-size", "25px");
			$(".layerName").css("float", "left").css("font-size", "18px").css("margin","10px 0 10px 10px").css("font-weight","600");
			$(".layerDate").css("font-size", "16px").css("margin-left", "290px").css("margin-top","10px");

			$("#text_reply").css("position","absolute").css("bottom","15px").css("right","75px");
			$("#insert_reply").css("position","absolute").css("bottom","15px").css("right","18px");
			$("#like_btn").css("position","absolute").css("cursor","pointer").css("width","30px").css("height","30px").css("bottom","15px").css("right","470px"); 
			
			$.ajax({
				url : "http://mongsil311.cafe24.com/selectBucketReply",
				type : 'POST',
				data : {"bIndex" : insert_rIndex},
				datatype : 'json',
				success : function(data){
					if(data == ''){
						$(".inner_reply").append("<div id='noreply'></div>");
					}
					for(var i = 0; i < data.length; i++){
						$(".inner_reply").append("<div id='reply" + i + "'></div>");
						$("#reply"+i).append("<div class='rName'>" + data[i].rName + "</div>");
						$("#reply"+i).append("<div class='rContent'>" + data[i].rContent + "</div>");
						$("#reply"+i).append("<div class='rWriteTime'>" + data[i].rWriteTime + "</div>");
						$("#reply"+i).css("border-bottom", "1px dotted black").css("width","440px");
						$(".inner_reply").css("margin","20px 0 0 0").css("height","350px");
						$(".rName").css("float", "left").css("font-size", "18px").css("margin","10px 0 10px 10px").css("font-weight","600");
						$(".rContent").css("font-size", "20px").css("margin","20px 0 20px 100px").css("font-weight","300");
						$(".rWriteTime").css("margin-left", "300px");
					}
				}
			});	
		}
		
		$("#closeBtn").click(function(){
			$("#layerPop").css("display", "none");
			$(".inner_bucket").empty();
			$(".inner_reply").empty();
			$("#text_reply").val("");
		});

		$(".bName").css("float", "left").css("font-size", "18px").css("margin","10px 0 10px 10px").css("font-weight","600");
		$(".bDate").css("font-size", "16px").css("margin-left", "255px").css("margin-top","10px");
		$(".bImage img").css("height" , "280px");
		$(".bImage img").css("width" , "350px");
		$(".bContent").css("position" , "absolute").css("top" , "50%").css("left" , "50%").css("margin-left", -width).css("margin-top", -height).css("background-color", "rgba(0,0,0,0.5)").css("color", "white").css("font-size", "25px");
		$(".bLike img").css("height" , "18px").css("margin","6px 6px 0 10px");
		$(".bLike img").css("width" , "18px");
		$(".bReply img").css("height" , "18px").css("margin","6px 6px 0 10px");
		$(".bReply img").css("width" , "18px");
		$(".bLike").css("float", "left").css("font-size", "18px");
		$(".bReply").css("margin-left", "100px").css("font-size", "18px");
		$("#footer").css("bottom", $(window).height());
		}
	});
	
	$("#insert_reply").click(function(){
		var index =  insert_rIndex;
		var text_reply = $("#text_reply").val();
		var bId = insert_rId;
		var bName = insert_rName;
		var date = new Date();
		var insert_date = (date.getMonth()+1) + "월" + date.getDate() + "일 " + date.getHours() + "시" + date.getMinutes() + "분";

		if(text_reply == ""){
			alert("댓글을 작성해주세요.");
			return;
		}else{
			$.ajax({
				url : "http://mongsil311.cafe24.com/insertBucketReply",
				type : 'POST',
				data : {"rIndex" : index , "rContent" : text_reply , "rId" : bId, "rName" : bName, "rDate" : insert_date},
				datatype : 'json',
				success : function(data){
				}
			});
		}
	});
	
	$("#like_btn").click(function(){
		var index =  insert_rIndex;
		$.ajax({
			url : "http://mongsil311.cafe24.com/updateLike",
			type : 'POST',
			data : {"rIndex" : index},
			datatype : 'json',
			success : function(data){
			}
		});
		alert("응원하였습니다.");
	});

});