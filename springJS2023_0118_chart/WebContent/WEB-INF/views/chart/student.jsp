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
 // ������ json�� �Ľ��� ������
 const students = [];
 students.push({name: '����', kor:87, eng:98, math: 88, scien:90});
 students.push({name: '����', kor:92, eng:98, math: 96, scien:88});
 students.push({name: '�ܿ�', kor:76, eng:96, math: 94, scien:86});
 students.push({name: '�ٴ�', kor:87, eng:52, math: 98, scien:92});
 console.log(students);
 // bar ��Ʈ : �����Ϳ��� ������� �̸��� x:category
 var chart = c3.generate({
		bindto : '#chart',
		//data.json
		data : {
			 json: students,
			    keys: {
			      // x: 'name', // it's possible to specify 'x' when category axis
			      value: ['kor', 'eng','math','scien']
			    },
 // data.type
 type:'bar'
		},
		axis:{
		        x: {
		            type: 'category',
		            categories: [students[0].name, students[1].name, students[2].name, students[3].name]
		        
		    }
		}
		});
 </script>

</body>
</html>