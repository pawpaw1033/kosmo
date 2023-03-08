<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
   <%--2023. 1. 17./Kosmo--%>
 <article >
        <header>
            <h1>[회원찾기]MemberJsonDemo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
        <div class="row">
       <input type="text" id="id" name="id" placeholder="아이디를 입력하세요">
        <button id="jsonAjaxTest">Click</button>
        <div id="target" class="row justify-content-center">Target!</div>
        </div>
        </div>
        </article>
<script>
// JQuery 시작
$(function(){
	$('#jsonAjaxTest').click(function() {
		//alert("Test"+$('#deptno').val());
		$.ajaxSetup({ // Ajax 게시물 삭제
			cache:false
		});
		$.ajax({
			url:"../memberJsonView1?id="+$('#id').val(),
			success:function(jsonData){
				$('#target').html(""); // 데이터 비우기
				console.log(jsonData);
				console.log(Object.keys(jsonData));
				console.log(typeof(jsonData));
				// json데이터를 jQuert반복자를 사용해서 출력하기
				$.each(jsonData, function(k, v) {
				console.log(k +":"+v);
				$('#target').append("<p>"+k+","+v+"</p>");
				});
				// target의 자식인 p태그를 선택해서
				// jQuery의 css함수를 사용해서 동적으로 css를 적용할 수 있다.
				$('#target>p').css("background", "pink")
				.css("text-align", "center")
				.css("color", "#ffffff");
			} 
		});
	});
});
</script>


</body>
</html>