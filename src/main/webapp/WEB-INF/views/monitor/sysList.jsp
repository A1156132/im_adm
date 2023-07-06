<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://im.mobis.co.kr/im/assets/coloradmin/plugins/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	var $form = $("#search_form");
	var todayDate = getToday();
	
	// 프로비전 시작일~ 종료일 날짜 설정
	$(".search_start_dt").val(todayDate);
	$(".search_end_dt").val(todayDate);
	
	
	// enter text box
	$(document).on("keyup", ".onlyTxt", function (event){
		// 영어,숫자만 입력되도록 valid check
		/* if (!(event.keyCode >=37 && event.keyCode<=40)) {
		    var inputVal = $(this).val();
		    $(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
		   } */
	});
	
	
	// paging number click
	$(document).on("click", ".no", function (){
		var sel_sys_code = $(".sel_sys_code option:selected").val(); 
		if(sel_sys_code == "") {
			alert("시스템을 선택하세요"); 
			return false;
		}else{
			$("#sys_code").val(sel_sys_code);
		}
		$("#currentPage").val($(this).text());
		$("#user_id").val($("input[name='search_user_id']").val().trim());
		$("#user_nm").val($("input[name='search_user_nm']").val());
		$("#dept_nm").val($("input[name='search_dept_nm']").val());
		$form.submit();
	});
	
	// search click btn 
	$(document).on("click", ".searchBtn", function (){
		var sel_sys_code = $(".sel_sys_code option:selected").val(); 
		if(sel_sys_code == "") {
			alert("시스템을 선택하세요"); 
			return false;
		}else{
			$("#sys_code").val(sel_sys_code);
		}

		$("#user_id").val($("input[name='search_user_id']").val().trim());
		$("#user_nm").val($("input[name='search_user_nm']").val());
		$("#dept_nm").val($("input[name='search_dept_nm']").val());

		$form.submit();

	});
	// clearBtn click btn 
	$(document).on("click", ".clearBtn", function (){
		$("input[name='search_user_id']").val("");
		$("input[name='search_user_nm']").val("");
		$("input[name='search_dept_nm']").val("");
		$("input[name='search_user_id']").focus();
	});
	
	
});

function getToday(){
    var date = new Date();
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);

    return year + "-" + month + "-" + day;
}
</script>
<title>Insert title here</title>
<style>
body {background-color:#eee; color:#242a30; font-size:15px; padding:0px; margin:0px;}
#main_div {background-color:white; position:absolute; left:2%;  width:95%; height:570px;}
.desc_box{font-size:10px; background-color:white; padding:10px;}
table{font-size:13px; width:99%; border-collapse:collapse; border:1px solid #dee2e6;}
#search_tb{margin-top:10px; margin-left :10px; margin-right:10px;}
#search_tb tr{border:2px solid #ced8db; border-left:0px; border-right:0px; background-color:whitesmoke;}
#search_tb td{padding:6px; font-size:12px;}
a{text-decoration:none; color:white; } 
input[type=text]{border:1px solid #d3d8de; height:20px;}
select{border:1px solid #d3d8de; height:20px}
h1{margin-bottom:5px; text-shadow:2px 2px 4px #ccc; font-size:24px; font-weight:500; color:#242a30; padding:0px; margin:0px;}
.cal{width:80px;}
label{color:#777; font-weight:bold;}
#content_tb{display:block; height:500px; overflow-y:auto; font-size:13px; margin:10px 10px 0px 5px; border:#e2e7eb; }
#content_tb thead tr{background-color:#2a72b5; }
#content_tb thead td{ padding:5px; color:white; font-weight:bold; border:#e2e7eb;}
#content_tb td{border:1px solid #dee2e6; padding:7px;}
.searchBtn{ cursor:pointer; display:inline-block; background-color:#4256BA; border:0; text-align:center; padding:5px 10px; font-weight:bold;}
.clearBtn{ cursor:pointer; display:inline-block; background-color:#ced8db; border:0; text-align:center; padding:5px 10px; font-weight:bold;}
.paging{text-align:center; margin-top:30px;}
.no{padding:6px 12px; margin-left:5px; border:1px solid #ddd; border-radius:6px!important; background-color:white; cursor :pointer;} 
.selected{color:white; background-color:#2a72b5;}
#wrap{height: auto;  min-height: 100%;  padding-bottom: 30px;}
</style>
</head>
<body>
<div id="wrap">
<div class="desc_box">
	<h1>*시스템 모니터링 페이지</h1>
	 - 사용자 상세 정보는 라인을  클릭하세요.</br>
	 - 프로비전 일자 : IM시스템에서 해당 사용자 정보를 배포한 날짜</br>
	 - 동기화 상태 : 연계 시스템의 동기화여부 (동기화여부란이 N인 경우 IM에서 배포되었으나 연계시스템에서 인사배치가 수행되지 않은 상태)</br>
	</div>
<div id="main_div">
	<form id="search_form" action="provList" method="POST">
	<input type="hidden" id="sys_code" name="sys_code" />
	<input type="hidden" id="user_id" name="user_id" />
	<input type="hidden" id="user_nm" name="user_nm" />
	<input type="hidden" id="dept_nm" name="dept_nm" />	
	<!-- paging -->
	<input type="hidden" id="currentPage" name="currentPage" value="${currentPage}"/>	
	
	<table id="search_tb">
		<tr>
			<td><label>시스템명(리소스)</label></td>
			<td>
				<select class="sel_sys_code">
					<option value="">---시스템선택---</option>
						<c:forEach var="list" items="${sysList}">
							<option  <c:if test ="${sys_code eq list.sys_code}">selected="selected"</c:if> value="${list.sys_code}">${list.sys_name}</option>
						</c:forEach>
				</select>
			</td>
			
			<td><label>사번(로그인ID)</label></td>
			<td><input type="text" style="width:100px" class="onlyTxt" name="search_user_id" value="${user_id}" /></td>
			<td><label>이름</label></td>
			<td><input type="text" class="onlyTxt" name="search_user_nm" value="${user_nm}" /></td>
			<td><label>부서</label></td>
			<td><input type="text" class="onlyTxt" name="search_dept_nm" value="${dept_nm}" /></td>
			<td><label>프로비전일자</label></td>
			<td><input type="text" name="search_start_dt" value="${search_start_dt}" class="cal search_start_dt"  />~<input type="text" name="search_end_dt" value="${search_end_dt}" class="cal search_end_dt"  /></td>
			<td><span class="clearBtn"><a href="#" class="btn">초기화</a></span></td>
			<td><span class="searchBtn"><a href="#" class="btn">조회</a></span></td>
		</tr>
	</table>
	</form>
	<table id="content_tb">
		<thead>
			<td style="display:none;">선택</td>
			<td style="width:10%">법인명(법인코드)</td>
			<td style="width:10%">사번(로그인ID)</td>
			<td style="width:15%">이름</td>
			<td style="width:20%">부서</td>
			<td style="width:5%">상태</td>
			<td style="width:15%">직위/직책</td>
			<td style="width:10%" >프로비전 날짜(수정일)</td>
			<td style="width:5%">동기화</td>
			<tD style="width:10%">동기화 날짜</td>
		<!-- 	<th>플래그초기화</th> -->
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
			<tr style="cursor:pointer"onmouseover="this.style.background='#f3f3f4'" onmouseout="this.style.background='white'">
				<td style="width:10%">${user.branch_nm}(${user.branch_cd})</td>
				<td style="width:10%">${user.user_id}</td>
				<td style="width:15%">${user.name}</td>
				<td style="width:20%">${user.dept_nm}</td>
				<c:if test='${user.status eq "3"}'><td style="width:5%">재직</td></c:if>
				<c:if test='${user.status eq "0"}'><td style="width:5%; color:red;">퇴직</td></c:if>
				<c:if test='${user.status eq "1"}'><td style="width:5%; color:orange;">휴직</td></c:if>
				<td style="width:15%">${user.position_out_nm}<c:if test='${user.duty_nm ne "" && not empty user.duty_nm}'>/${user.duty_nm}</c:if></td>
				<td style="width:10%">${user.prov_dt}</td>
				<td style="width:5%">${user.flag}</td>
				<td style="width:10%">${user.sync_dt}</td>
				<!-- <td>-</td>-->
			</tr>
			</c:forEach>
		
		</tbody>
	</table>
	<!-- navigator -->
	<div class="paging">
		<div style="float:right; font-size:12px; font-weight:bold;">총 ${totalCnt} 건</div>
		<div class="ele">
			<c:set var="page" value="${currentPage}"/>
			<!-- page maxpage를 넘었을 경우 제한 -->
			<c:if test="${page > maxPage}">
				<c:set var="page" value="${maxPage}"/>
			</c:if>
							
			<!-- 페이지를 8개씩 나누기 위해 현재 페이지에 보여줄 max값 설정 -->
			<fmt:formatNumber value="${page/8 - (page/8 % 1)}" type="pattern" pattern="0" var="full"/>
			<c:set var="full" value="${full * 8}"/>	
											
			<!-- prev(전페이지), next(다음페이지) 개수 설정 -->
			<c:set var="scope" value="${page%8}"/>			
			<c:choose>
				<c:when test="${scope == 0}">
					<c:set var="prev" value="8"/>
					<c:set var="next" value="1"/>
				</c:when>
				<c:when test="${scope < 9}">
					<c:set var="prev" value="${scope}"/>
					<c:set var="next" value="${9-scope}"/>
				</c:when>
			</c:choose>								
					
			<!-- prev 버튼 -->
			<c:if test="${page > 8}">
				<fmt:formatNumber value="${(page-1)/8 - (((page-1)/8) % 1)}" type="pattern" pattern="0" var="prevb"/>
				<c:set value="${(prevb-1)*8 + 1}" var="prevb"/>
				<span id="prevBtn" class="prev button" value="${prevb}"></span>
			</c:if>
			
			<!-- 전 페이지 -->
			<c:if test="${page != 1}">							
				<c:set var="j" value="${prev}"/>				
				<c:forEach var="i" begin="1" end="${prev-1}">
					<c:set var="j" value="${j - 1}"/>			
					<c:if test="${(page - j) > 0}">								
						<span class="no">${page - j}</span>
					</c:if>
				</c:forEach>
			</c:if>
			<c:if test="${page == 0}">	
				<c:set var="page" value="1"/>
			</c:if>						
					
			<!-- 현재 페이지 -->
			<span class="no selected">${page}</span>
			
			<!-- 다음 페이지 -->
			<c:if test="${page != maxPage}">
				<c:forEach var="i" begin="1" end="${next-1}">
					<c:if test="${maxPage >= page+i}">
						<span class="no">${page+i}</span>
					</c:if>
				</c:forEach>
			</c:if>
					
			<!-- next 버튼 -->
			<c:if test="${maxPage >= page + next}">
				<fmt:formatNumber value="${(page-1)/8 - (((page-1)/8) % 1)}" type="pattern" pattern="0" var="nextb"/>
				<c:set value="${(nextb+1)*8 + 1}" var="nextb"/>
				<span id="nextBtn" class="next button" value="${nextb}"></span>
			</c:if>	
		</div>
	</div>
	<!--// navigator -->
	
</div> <!-- // main DIV -->
<%@ include file="../footer.jsp" %>
</body>
</html>