<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
   <%--2023. 1. 17./Kosmo--%>


<link href="${pageContext.request.contextPath}/resources/css/c3.css" rel="stylesheet">
<style></style>


<%--load c3.css --%>
<!-- Load d3.js and c3.js -->
<script src="${pageContext.request.contextPath}/resources/js/d3-5.8.2.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/c3.min.js"></script>
 <article >
        <header>
            <h1>Chart Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
        <div id="chart"></div>
        </div>
        </article>
</head>
<body>
 <div id="chart"></div>
 <script>
 // 서버측 json을 파싱한 데이터
 let wheather = [];
 wheather.push({name: '날씨 설문조사 내용', 비가옵니다:500, 안옵니다:200, 모릅니다:666, 태풍이옵니다:54, 관심없음: 120});
 
 console.log(wheather[0]);
 // bar 차트 : 데이터에서 사용자의 이름을 x:category
 var chart = c3.generate({
		bindto : '#chart',
		//data.json
		data : {
			 json: wheather,
			    keys: {
			      // x: 'name', // it's possible to specify 'x' when category axis
			      value: ['비가옵니다', '안옵니다','모릅니다','태풍이옵니다','관심없음']
			    },
 // data.type
 type:'donut'
		},
		donut:{
			title: '날씨 설문조사 내용'
		},
		axis:{
		        x: {
		            type: 'category',
		            categories: [wheather[0].name]
		        
		    }
		}
		});
 </script>

</body>
</html>