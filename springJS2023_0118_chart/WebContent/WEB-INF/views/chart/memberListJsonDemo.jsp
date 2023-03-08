<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--2023. 1. 17./Kosmo--%>
<article>
	<header>
		<h1>memberListJsonDemo</h1>
	</header>
	<ul class="list-unstyled"><li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<div class="row">
			<button id="listBtn">Click</button>
			<div class="row justify-content-center">
				<table class="table">
					<thead>
						<tr>
							<td>Num</td>
							<td>Id</td>
							<td>Name</td>
							<td>Age</td>
							<td>Gender</td>
						</tr>
					</thead>
					<tbody id="target">
					</tbody>
				</table>
			</div>
		</div>
	</div>
</article>
<script>
	// JQuery 시작
	$(function() {
		$('#listBtn').click(
				function() {
					//alert("Test"+$('#deptno').val());
					$.ajaxSetup({ // Ajax 게시물 삭제
						cache : false
					});
					$.ajax({
						url : "../memberListJsonView1",
						success : function(jsonData) {
							$('#target').html(""); // 데이터 비우기
							console.log(jsonData);
							console.log(Object.keys(jsonData));
							console.log(typeof (jsonData));
							// json데이터를 jQuery반복자를 사용해서 출력하기
							$.each(jsonData, function(k, v) {
									$('#target').append(
											"<tr>" + v + "</tr>");
								$.each(v, function(k, v) {
									if(v !== null)
								$('#target').append(
										"<td>" + v + "</td>");
							});
								//value: Object.keys(jsondata),
							});
							// target의 자식인 p태그를 선택해서
							// jQuery의 css함수를 사용해서 동적으로 css를 적용할 수 있다.
							$('#target>p').css("background", "pink").css(
									"text-align", "center").css("color",
									"#ffffff");
						}
					});
				});
	});
</script>


</body>
</html>