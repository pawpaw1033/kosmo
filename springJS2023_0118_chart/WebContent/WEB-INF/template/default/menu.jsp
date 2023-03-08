<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <nav class="navbar navbar-expand-sm mybgColor" >
     <div class="container-fluid" >
        <ul class="navbar-nav" >
            <li class="nav-item"><a href="${pageContext.request.contextPath}/web/main" class="nav-link active" >Home</a></li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/web/mail/emailForm" class="nav-link">Email</a></li>
       
       <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Board
          </a>
          <ul class="dropdown-menu">
           <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/board/boardForm" >BoardForm</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/board/boardList">BoardList</a></li>
          </ul>
        </li>   
       
       <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            upload
          </a>
          <ul class="dropdown-menu">
           <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/upload/upform" >uploadForm</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/upload/upboardList?&searchType=&searchValue=?cPage=1">uploadList</a></li>
          </ul>
        </li>   
      
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Survey
          </a>
          <ul class="dropdown-menu">
           <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/survey/surveyForm" >Survey</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/survey/surveylist">SurveyList</a></li>
             <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/SurveyDonutChartAjax">SurveyDonutDemo</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/SurveyDonutChartAjaxTitle">SurveyTitleDemo</a></li>
          </ul>
        </li>
      
       <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Chart
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/student">Bar</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/donut">Donut</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/memberJsonDemo">MemberDemo</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/memberListJsonDemo">MemberListDemo</a></li>
           
          </ul>
        </li>
      
       </ul>
      
        <form class="d-flex">
        <input class="form-control me-2" type="text" placeholder="Search" name="searchv" id="searchv">
        <button class="btn btn-danger" type="button">Search</button>
        </form>
      </div>
    </nav>