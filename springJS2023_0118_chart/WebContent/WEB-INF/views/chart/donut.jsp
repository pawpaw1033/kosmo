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
 let wheather = [];
 wheather.push({name: '���� �������� ����', �񰡿ɴϴ�:500, �ȿɴϴ�:200, �𸨴ϴ�:666, ��ǳ�̿ɴϴ�:54, ���ɾ���: 120});
 
 console.log(wheather[0]);
 // bar ��Ʈ : �����Ϳ��� ������� �̸��� x:category
 var chart = c3.generate({
		bindto : '#chart',
		//data.json
		data : {
			 json: wheather,
			    keys: {
			      // x: 'name', // it's possible to specify 'x' when category axis
			      value: ['�񰡿ɴϴ�', '�ȿɴϴ�','�𸨴ϴ�','��ǳ�̿ɴϴ�','���ɾ���']
			    },
 // data.type
 type:'donut'
		},
		donut:{
			title: '���� �������� ����'
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