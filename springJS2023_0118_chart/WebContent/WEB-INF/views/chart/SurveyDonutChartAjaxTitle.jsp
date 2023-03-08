<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <link href="${pageContext.request.contextPath}/resources/css/c3.css" rel="stylesheet">
<style></style>


<%--load c3.css --%>
<!-- Load d3.js and c3.js -->
<script src="${pageContext.request.contextPath}/resources/js/d3-5.8.2.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/c3.min.js"></script>
  
    <article >
        <header>
            <h1>[ChartJson Demo]surveyChart.js</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
		<div id="chart"></div>

     </div>
 
    </article>
<script>
/* var jsondata = {
'비가 옵니다': 500,
'안옵니다': 200,
'모릅니다': 666,
'태풍이옵니다': 54,
'관심없음': 120
};  */
$.ajaxSetup({
	cache : false
});
$.ajax({
	url : "../surveyJsonObj2?num=${num}",
	success : function(jsondata) {
		console.log(jsondata[0].sub);
		console.log("---------------------");
		console.log(jsondata[1]);
		console.log("---------------------");
		var chart = c3.generate({
			bindto : '#chart',
			data : {
				json : [jsondata[1]],
				keys : {
					value : Object.keys(jsondata[1]),
				},
				type : 'donut'
			},
			donut : {
				title : jsondata[0].sub,
			},
		});
		//----------------------
	},
	error : function(e) {
		console.log("error:" + e);
	}
});
</script>