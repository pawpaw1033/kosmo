<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <style>
.card {
    margin-bottom: 5%;
    min-height: 200px;
}


.card-caption h4 {
    margin-bottom: 8px;
    font-style: bold;
}

.card button {
    margin-top: 16px;
}

.card-text {
    margin: 8px 0;
    color: #232323;
}

#map {
    display: flex;
    width: 100%;
    min-height: 300px;
    height: 100%;
}
</style>
<div id="demo" class="carousel slide" data-bs-ride="carousel">
  <!-- Indicators/dots -->
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="3"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="4"></button>
  </div>
  
  <!-- The slideshow/carousel -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <%-- image를 세션값이 따라 변경 해보는 데모 --%> 
   <c:choose>
   <c:when test="${sessionScope.sessionName != null }">
     <c:set var="imgv3" value="h.jpg" scope="page"/>
   </c:when>
   <c:otherwise>
    <c:set var="imgv3" value="bh5.jpg" scope="page"/>
   </c:otherwise>
   </c:choose>
      <img src="${pageContext.request.contextPath}/resources/image/${imgv3}" alt="Kosmo113" class="d-block" style="width:100%">
      <div class="carousel-caption">
        <h3>안녕하세요 </h3>
        <p>
        <c:choose>
        <c:when test="${sessionScope.sessionName != null }">
             ♥ ${sessionScope.sessionName} ♥
            <div class="card">
               <div class="row no-gutters">
                  <div class="col-8">
                     <div id="map"></div>
                  </div>
                  <div class="col-4">
                     <div class="card-body">
                        <h4 class="card-text">jQuery스터디 모임</h4>
                        <p class="card-text">서울 금천구 가산디지털1로 151 2층 B강의실</p>
                        <button type="button" class="btn btn-dark" onclick="alert('Open 준비중!')">jQuery스터디 모임
                           확인</button>
                     </div>
                  </div>
               </div>
            </div>
        </c:when>
        <c:otherwise>
        로그인을 해주세요!
        로그인을 하면 장소를 확인 할 수 있어요
        </c:otherwise>
        </c:choose>
        </p>
      </div>
    </div>
    
    <div class="carousel-item">
      <%-- image를 세션값이 따라 변경 해보는 데모 --%> 
   <c:choose>
   <c:when test="${sessionScope.sessionName != null }">
     <c:set var="imgv3" value="h2.jpg" scope="page"/>
   </c:when>
   <c:otherwise>
    <c:set var="imgv3" value="nj.jpg" scope="page"/>
   </c:otherwise>
   </c:choose>
      <img src="${pageContext.request.contextPath}/resources/image/${imgv3}" alt="Carousel" class="d-block" style="width:100%">
      <div class="carousel-caption">
        <h3> 어서오세요!</h3>  
      <p>
        <c:choose>
        <c:when test="${sessionScope.sessionName != null }">
              ${sessionScope.sessionName}님 반가워요. 오늘 날씨가 너무 좋네요
        </c:when>
        <c:otherwise>
        
        Thank you
        </c:otherwise>
        </c:choose>
        </p>
       
      </div> 
    </div>
    
    <div class="carousel-item">
    <%-- image를 세션값이 따라 변경 해보는 데모 --%> 
   <c:choose>
   <c:when test="${sessionScope.sessionName != null }">
     <c:set var="imgv3" value="h3.jpg" scope="page"/>
   </c:when>
   <c:otherwise>
    <c:set var="imgv3" value="bh9.jpg" scope="page"/>
   </c:otherwise>
   </c:choose>
      <img src="${pageContext.request.contextPath}/resources/image/${imgv3}" alt="JSP" class="d-block" style="width:100%">
      <div class="carousel-caption">
        <h3>UI 요구사항 확인하기,UI 설계하기 </h3>
       <p>
        <%-- image를 세션값이 따라  메세지 변경 해보는 데모 --%> 
        <c:choose>
        <c:when test="${sessionScope.sessionName != null }">
              ${sessionScope.sessionName}님 반가워요. 오늘 날씨가 너무 좋네요
        </c:when>
        <c:otherwise>
              오늘의 날씨 같은 거 출력 해주면 어떨까?
        </c:otherwise>
        </c:choose>
        </p>
       
      </div>  
    </div>
    
     <div class="carousel-item">
    <%-- image를 세션값이 따라 변경 해보는 데모 --%> 
   <c:choose>
   <c:when test="${sessionScope.sessionName != null }">
     <c:set var="imgv3" value="qw.jpg" scope="page"/>
   </c:when>
   <c:otherwise>
    <c:set var="imgv3" value="uy1.jpg" scope="page"/>
   </c:otherwise>
   </c:choose>
      <img src="${pageContext.request.contextPath}/resources/image/${imgv3}" alt="JSP" class="d-block" style="width:100%">
      <div class="carousel-caption">
        <h3>UI 요구사항 확인하기,UI 설계하기 </h3>
       <p>
        <%-- image를 세션값이 따라  메세지 변경 해보는 데모 --%> 
        <c:choose>
        <c:when test="${sessionScope.sessionName != null }">
              ${sessionScope.sessionName}님 반가워요. 오늘 날씨가 너무 좋네요
        </c:when>
        <c:otherwise>
              오늘의 날씨 같은 거 출력 해주면 어떨까?
        </c:otherwise>
        </c:choose>
        </p>
       
      </div>  
    </div> 
   
     <div class="carousel-item">
    <%-- image를 세션값이 따라 변경 해보는 데모 --%> 
   <c:choose>
   <c:when test="${sessionScope.sessionName != null }">
     <c:set var="imgv3" value="kl.jpg" scope="page"/>
   </c:when>
   <c:otherwise>
    <c:set var="imgv3" value="bh6.jpg" scope="page"/>
   </c:otherwise>
   </c:choose>
      <img src="${pageContext.request.contextPath}/resources/image/${imgv3}" alt="JSP" class="d-block" style="width:100%">
      <div class="carousel-caption">
        <h3>UI 요구사항 확인하기,UI 설계하기 </h3>
       <p>
        <%-- image를 세션값이 따라  메세지 변경 해보는 데모 --%> 
        <c:choose>
        <c:when test="${sessionScope.sessionName != null }">
              ${sessionScope.sessionName}님 반가워요. 오늘 날씨가 너무 좋네요
        </c:when>
        <c:otherwise>
              오늘의 날씨 같은 거 출력 해주면 어떨까?
        </c:otherwise>
        </c:choose>
        </p>
       
      </div>  
    </div>
  </div>
  
  <!-- Left and right controls/icons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>
<%-- 카카오 맵 API --%>  
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=53d732fdeef7185913d1cad8c4088bfa&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
    center: new kakao.maps.LatLng(37.477001, 126.879982), // 지도의 중심좌표
    level: 5 // 지도의 확대 레벨
};

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption);


//마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(37.477001, 126.879982); 

//마커를 생성합니다
var marker = new kakao.maps.Marker({
 map:map,
 position: markerPosition
});
map.setCenter(markerPosition);

//아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
//마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
//marker.setClickable(true);

//마커를 지도에 표시합니다.
marker.setMap(map);

//마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
var iwContent = '<div style="background:orange;">Kosmo123!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
 iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

//인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
 content : iwContent,
 removable : iwRemoveable
});

//마커에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'click', function() {
   // 마커 위에 인포윈도우를 표시합니다
   infowindow.open(map, marker);  
});
</script>

    