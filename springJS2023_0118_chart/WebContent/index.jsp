<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>kosmo</title>
</head>
<body>
<script>
// 함수 만들기 미리보기
function deviceCheck(){
	// javascript 영역 : 
    // javascript : 클라이언트에서 해석되는 인터프린터 언어이고, 객체지향 언어이다
    // 브라우저마다 엔진 다르기 때문에 약간의 파싱의 파이가 있을 수 있다.
    // HTML5에서부터 표준화 된 버전 => ECMA5 ~ 7시리즈
    // 변수 선언은 var, let으로 한다.
    // userAgent : mozilla/5.0 (windows nt 10.0; win64; x64) applewebkit/537.36 (khtml, like gecko) chrome/108.0.0.0 safari/537.36
    // userAgent : mozilla/5.0 (linux; android 10; sm-g981b) applewebkit/537.36 (khtml, like gecko) chrome/80.0.3987.162 mobile safari/537.36
    // userAgent : mozilla/5.0 (iphone; cpu iphone os 13_2_3 like mac os x) applewebkit/605.1.15 (khtml, like gecko) version/13.0.3 mobile/15e148 safari/604.1
    var userAgent = navigator.userAgent.toLowerCase();
    // alert(userAgent);
    // console.log("userAgent : "+ userAgent);
    // var platform = navigator.userAgent.toLowerCase();
    // console.log("platform : "+ platform);
    // indexOf() -> 찾지 못하면 -1
    console.log("indexOf() =>"+ userAgent.indexOf('android'))
    if (userAgent.indexOf('android') > -1 || userAgent.indexOf('iphone') > -1) {
       console.log("mobile");
       // location="이동할url"
       location="mobile/";
    } else {
       console.log("PC");
       location="web/";
    }
}
deviceCheck();
</script>
</body>
</html>