$(document).ready(function(){
	var id =$("#userId").val();
	var bucketArray = [];
	var name;
	var bContent;
	var bIndex = 0;
	var height;
	var width;
	$("#tagDiv").css("display" , "none");
	$("#insertBtn").css("display" , "none");
	$("#bucketBox").css("width", "1200px");
	$("#bucketBox").css("height", $(window).height());
	
	jQuery.fn.center = function () {
	    this.css("position","absolute");
	    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
	    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
	    return this;
	}
	
	function bucketDTO(bIndex, bName, bDate, bImage, bContent, bLike, bReply){
		var _bName = bName;
		var _bDate = bDate;
		var _bImage = bImage;
		var _bContent = bContent;
		var _bLike = bLike;
		var _bReply = bReply;
		var _bIndex = bIndex;
		
		this.getbName = _bName;
		
		this.getbImage = _bImage;
		
		this.getbContent = _bContent;
		
		this.getbLike = _bLike;
		
		this.getbDate = _bDate;
		
		this.getbReply = _bReply;
		
		this.getbIndex = _bIndex;
	}
//	데이터 셀렉트
	// http://mongsil311.cafe24.com/resources/bucket_image/ 서버 이미지 주소
		$.ajax({
			url : "http://mongsil311.cafe24.com/selectmyBucket",
			type : 'POST',
			data : {"bIndex" : bIndex, "id" : id},
			datatype : 'json',
			success : function(data){
				for(var i = 0; i < data.length; i++){
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
					height = $(".bContent").height() / 2;
					width = $(".bContent").width() / 2;
					bucketArray[i] = new bucketDTO(data[i].bIndex, data[i].bName, data[i].bDate, data[i].bImage, data[i].bContent, data[i].bLike, data[i].bReply);
					$(".footerTest").css("position", "absolute");
					$(".footerTest").css("float", "block");
					$(".ftt").css("bottom", "1%");
					$(".ftt").css("border", "solid 1px red");
					$(".iii").css("border", "solid 1px blue");
					
					$("#bucket"+i).click(function(){
						var index =  $(this).find('input:hidden').val();
						var bIndex = $(this).find('#bIndex').val();
						openLayer(index, bIndex);
					});
				}
				if(data.length == 20){
					$("#bucketBox").append("<div id='more'></div>");
					$("#more").css("background-color", "#F6F6F6").css("border-radius","3px").css("position" , "relative");
					$("#more").css("width", "350px").css("height", "350px").css("float", "left").css("margin-left", "30px").css("margin-bottom", "30px");
					$("#more").append("<div class='bName'></div>");
					$("#more").append("<div class='bDate'></div>");
					$("#more").append("<div class='bImage'></div>");
					$("#more").append("<div class='bContent'>더 보기</div>");
					$("#more").append("<div class='bLike'></div>");
					$("#more").append("<div class='bReply'></div>");
				}
				
				function openLayer(IdName, bIndex){
					$("#layerPop").center();
					$("#layerPop").css("display", "block");
					$(".inner_bucket").append("<div class='layerName'>" + bucketArray[IdName].getbName + "</div>");
					$(".inner_bucket").append("<div class='layerDate'>" + bucketArray[IdName].getbDate + "</div>");
					$(".inner_bucket").append("<div class='layerImg'><img src='http://mongsil311.cafe24.com/resources/bucket_image/" + bucketArray[IdName].getbImage + "'</div>");
					$(".layerImg").append("<div class='bContent'>" + bucketArray[IdName].getbContent + "</div>").css("position", "relative");
					$(".layerImg img").css("height" , "350px").css("width" , "400px");
					$(".layerImg .bContent").css("position" , "absolute").css("top" , "50%").css("left" , "50%").css("margin-left", -width).css("margin-top", -height).css("background-color", "rgba(0,0,0,0.5)").css("color", "white").css("font-size", "25px");
					$(".layerName").css("float", "left").css("font-size", "18px").css("margin","10px 0 10px 10px").css("font-weight","600");
					$(".layerDate").css("font-size", "16px").css("margin-left", "300px").css("margin-top","10px");
					$.ajax({
						url : "http://mongsil311.cafe24.com/selectBucketReply",
						type : 'POST',
						data : {"bIndex" : bIndex},
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
								$("#reply"+i).css("border-bottom", "1px dotted black");
								
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
	$("#nextBtn").click(function(){
		id = $("#userId").val();
		name = $("#nickName").val();
		bContent = $("#bucket").val();
		
		if(bContent == ""){
			alert("버킷 내용을 채워주세요");
			return;
		}else{
			$("#tagDiv").css("display" , "block");
			$("#insertBtn").css("display" , "block");
		}
	});
	
	$("#insertBtn").click(function(){
		var Tag = $("input:radio[name='group']:checked").val();
		
		if(Tag == undefined){
			alert("태그를 선택해 주세요");
		}else{
			var param = {"id" : id, "name" : name, "bContent" : bContent, "Tag" : Tag};
			$.ajax({
				url : "http://mongsil311.cafe24.com/insertBucket",
				type : 'POST',
				data : param,
				success : function(){
					alert("success");
				}
			});
			$("#tagDiv").css("display" , "none");
			$("#insertBtn").css("display" , "none");
			$("#bucket").val("");
			$.ajax({
				url : "http://mongsil311.cafe24.com/selectmyBucket",
				type : 'POST',
				data : {"bIndex" : bIndex},
				datatype : 'json',
				success : function(data){
					$("#bucketBox").empty();
					for(var i = 0; i < data.length; i++){
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
						height = $(".bContent").height() / 2;
						width = $(".bContent").width() / 2;
						bucketArray[i] = new bucketDTO(data[i].bIndex, data[i].bName, data[i].bDate, data[i].bImage, data[i].bContent, data[i].bLike, data[i].bReply);
						$(".footerTest").css("position", "absolute");
						$(".footerTest").css("float", "block");
						$(".ftt").css("bottom", "1%");
						$(".ftt").css("border", "solid 1px red");
						$(".iii").css("border", "solid 1px blue");
						
						$("#bucket"+i).click(function(){
							var index =  $(this).find('input:hidden').val();
							var bIndex = $(this).find('#bIndex').val();
							openLayer(index, bIndex);
						});
					}
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
		}
	});
});
