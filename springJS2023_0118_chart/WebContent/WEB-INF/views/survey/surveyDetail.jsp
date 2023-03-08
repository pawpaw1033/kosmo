<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article >
        <header>
            <h1>Survey Detail Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
<div>
<%-- form start --%>

 <table class="table">
		<thead>
			<tr>
				<th colspan="2">SurveyDetail</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<th>Á¦¸ñ</th>
			<td>
			<input type="text" name="sub" id="sub" == code here ==
							readonly="readonly"> 
		   == code here ==
			</td>
			</tr>
		== code here ==
				<tr>
					<th>== code here ==</th>
					<td>== code here ==</td>
				</tr>
		== code here ==
		</tbody>
		<tfoot>
			<tr>
				<th colspan="2">
				
				<input type="button" value="list"
					onclick="location='surveylist'"> 
					<input type="button" value="delete" id="delete"></th>
			</tr>
		</tfoot>
	</table> 
</div>
 
</article>