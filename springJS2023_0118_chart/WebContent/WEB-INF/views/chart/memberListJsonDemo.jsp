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
	// JQuery ����
	$(function() {
		$('#listBtn').click(
				function() {
					//alert("Test"+$('#deptno').val());
					$.ajaxSetup({ // Ajax �Խù� ����
						cache : false
					});
					$.ajax({
						url : "../memberListJsonView1",
						success : function(jsonData) {
							$('#target').html(""); // ������ ����
							console.log(jsonData);
							console.log(Object.keys(jsonData));
							console.log(typeof (jsonData));
							// json�����͸� jQuery�ݺ��ڸ� ����ؼ� ����ϱ�
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
							// target�� �ڽ��� p�±׸� �����ؼ�
							// jQuery�� css�Լ��� ����ؼ� �������� css�� ������ �� �ִ�.
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