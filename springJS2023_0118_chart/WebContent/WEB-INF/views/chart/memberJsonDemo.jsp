<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
   <%--2023. 1. 17./Kosmo--%>
 <article >
        <header>
            <h1>[ȸ��ã��]MemberJsonDemo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
        <div class="row">
       <input type="text" id="id" name="id" placeholder="���̵� �Է��ϼ���">
        <button id="jsonAjaxTest">Click</button>
        <div id="target" class="row justify-content-center">Target!</div>
        </div>
        </div>
        </article>
<script>
// JQuery ����
$(function(){
	$('#jsonAjaxTest').click(function() {
		//alert("Test"+$('#deptno').val());
		$.ajaxSetup({ // Ajax �Խù� ����
			cache:false
		});
		$.ajax({
			url:"../memberJsonView1?id="+$('#id').val(),
			success:function(jsonData){
				$('#target').html(""); // ������ ����
				console.log(jsonData);
				console.log(Object.keys(jsonData));
				console.log(typeof(jsonData));
				// json�����͸� jQuert�ݺ��ڸ� ����ؼ� ����ϱ�
				$.each(jsonData, function(k, v) {
				console.log(k +":"+v);
				$('#target').append("<p>"+k+","+v+"</p>");
				});
				// target�� �ڽ��� p�±׸� �����ؼ�
				// jQuery�� css�Լ��� ����ؼ� �������� css�� ������ �� �ִ�.
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