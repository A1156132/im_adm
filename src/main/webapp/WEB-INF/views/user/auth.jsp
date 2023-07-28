<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://im.mobis.co.kr/im/assets/coloradmin/plugins/jquery/jquery-3.6.0.min.js"/>
<script>
function stringToDateFormat(date) {
    if(!date || date.length<0) return '';
    var yyyy = date.substring(0, 4);
    var mm = date.substring(4, 6);
    var dd = date.substring(6, 8);
    var result = yyyy+'-'+mm+'-'+dd;

    if(date.length>8) {
        var h = date.substring(8, 10);
        var m = date.substring(10, 12);
        var s = date.substring(12, 14);
        result += ' '+h+":"+m+":"+s;
    }
    return result;
};
</script>

<style>
table {border: 1px solid; border-collapse: collapse;}
th, td {border: 1px solid; border-color:#dee2e6; padding: 7px 15px; text-align: left;}
thead {background-color: #146ac7; color: white;text-align: center; font-weight:border;}
</style>
</head>
<body>
<h1>사용자 권한 목록</h1>
<p>사용자가 현재 사용할 수 있는 시스템 목록입니다.</p>
<table>
	<thead>
		<tr>
			<td>시스템</td>
			<td>시스템명</td>
			<td>시스템 담당자</td>
			<td>계정생성일</td>
			<td>사용가능여부</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${authList}">
			<tr>
				<td>${row.sys_code}</td>
				<td>${row.sys_name}</td>
				<td>${row.sys_manager}</td>
				<td>${row.prov_dt}</td>
				<td>${row.flag!=""?"O":"X"}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>