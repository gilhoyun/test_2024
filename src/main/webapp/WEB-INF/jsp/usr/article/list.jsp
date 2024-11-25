<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c"%>    


<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<section class="mt-8">
	<div class="container mx-auto">
		<div class="w-9/12 mx-auto mb-2 pl-3 text-sm">
         <div class="w-9/12 mx-auto">
			<table class="table table-lg">
            <thead>
               <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>작성일</th>
               </tr>          
            </thead>
            <tbody>
              <c:forEach var="article" items="${article }">
               <tr>
                  <td>${article.id }</td>
                  <td class="link link-hover"><a href="detail?id=${article.id }">${article.title }</a></td>
                  <td>${article.name }</td>
                  <td>${article.regDate }</td>
               </tr>
              </c:forEach>  
            </tbody>
         </table>
         </div>
        </div>
        <c:if test="${loginedMemberId != -1 }">
          <div class="w-9/12 mx-auto flex justify-end my-3">
            <a class="btn btn-sm" href="write">글쓰기</a>       
          </div>
        </c:if>
      </div>
</section>