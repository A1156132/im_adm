<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://im.mobis.co.kr/im/assets/coloradmin/plugins/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	var $form = $("#loginInfo");
	
	// click login btn 
	$(document).on("click", ".loginBtn", function (){
		loginCheck();
	});
	
	
	// enter text box
	$(document).on("keyup", ".userIdTxt", function (event){
		if(event.keyCode==13) { 
			alert("엔터!");
			loginCheck();
		}
		
		// 영어,숫자만 입력되도록 valid check
		if (!(event.keyCode >=37 && event.keyCode<=40)) {
		    var inputVal = $(this).val();
		    $(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
		   }
	});
	/* 
	$(document).on("click", ".btn", function (){
		loginCheck();
	});
	 */
	function loginCheck(){

		var user_id = $(".userIdTxt").val().trim();
		if(user_id == "") {
			alert("사번을 입력하세요."); 
			$("#login_user_id").focus();
			return false;
		}

		$form.submit();
		
		/* $.ajax({
		    url: "loginChk",
		    type: 'POST',
		    data: $form.serialize(),
		    dataType: "json",
		    success: function(data) {
		    	
		    	if(!data.result){
		    		alert("로그인 정보가 잘못되었습니다.");
		    		return false;
		    		
		    	}else{
		    		window.location.href ="monitor/sysList";
		    	}

		    }
		})// -- ajax */
	} 
});
</script>
<style>
body {background-color:#eee;}
#logBtn { background-color:#4256BA; border:0; width:198px; height:60px; margin-bottom:5px;}
#main_div {background-color:white; position:absolute; top:40%; left:50%; margin-left:-530px; margin-top:-215px; width:1006px; height:460px}
#l_box {float:left; padding:2%; padding-top:20px; width:550px; height:100%; font-size:13px; }
#r_box {padding:1%;}
.userIdTxt {width:200px; height:30px; border:1px solid #d3d8de; margin:5% 0% 10% 5%;}
.loginBtn{margin-left:5%; width:200px; height:50px; line-height:50px; cursor:pointer; display:inline-block; background-color:#4256BA; border:0; text-align:center;
font-family:impact}
a{text-decoration:none; color:white; }

</style>
</head>
<body>

		<form id="loginInfo" action="loginChk" method="post">
		<div id="main_div">
			<!-- 좌측 설명 div -->
			<div id="l_box">
				<div id="txt_box">
					<p style="font-weight:bold">프로비전 모니터링</p>
					<p class="login-input-notice">모비스 IM에서 발급 받은  사번을 입력하시기 바랍니다. (예:A+사번)</p>
					<p style="font-weight:bold">권한신청 절차</p>
					<p class="login-input-notice">1) ITSM 문의시스템 선택 : HQ>업무시스템일반 > IM 선택</p>
					<p class="login-input-notice">2) 문의 유형 선택 : 데이터변경 신청</p>
					<p class="login-input-notice">3) ID 및 담당 시스템명, 접속할 IP 포함하여 접수</p>
					<p class="login-input-notice">관리자권한은 지정 IP에서만 접근 가능합니다.<p>
					<p> (*IP변경이 있을 경우 ITSM에서 데이터변경 접수 바랍니다.)</p>
				</div>
			</div>
			<!-- // 좌측 설명 div-->		
			<!-- 우측 로그인폼  -->
			<div id="r_box">
				<img src="https://im.mobis.co.kr/im/assets/app/img/hyundaimobis_CI_horizontal.jpg" style="padding-bottom:30px; width:300px;">
										
				<div class="login-input-div">
					<input type="text" class="userIdTxt" id="login_user_id" name="login_user_id" placeholder="A사번을 입력하세요."  value="">
				</div>
				<span class="loginBtn"><a href="#" class="btn">로그인</a></span>
			</div>
			<!--// 우측 로그인폼  -->
		</div>
		</form>
		<%@ include file="./footer.jsp" %>
</body>
</html>