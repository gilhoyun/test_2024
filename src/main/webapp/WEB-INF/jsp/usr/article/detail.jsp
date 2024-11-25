<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>


<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<script>
	const doWriteForm_onSubmit = function(form) {
		form.name.value = form.name.value.trim();


		if (form.name.value.length == 0) {
			alert('이름을 입력해주세요.');
			form.name.focus();
			return;
		}

		form.submit();
	}
	
	
	const replyForm_onSubmit = function(form) {
		form.body.value = form.body.value.trim();


		if (form.body.value.length == 0) {
			alert('내용을 입력해주세요.');
			form.body.focus();
			return;
		}

		form.submit();
	}
</script>


<section class="mt-8">
	<div class="container mx-auto border-b-2 border-slate-200">
		<div class="w-9/12 mx-auto">
				<table class="table table-lg">
					<tr>
						<th>번호</th>
						<td>${article.id }</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>${article.regDate }</td>
					</tr>
					<tr>
						<th>수정일</th>
						<td>${article.updateDate }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${article.title }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${article.body }</td>
					</tr>
			</table>
		</div>
	</div>
</section>


<section class="my-5">
	<div class="container mx-auto px-4 text-base">
		<div class="text-lg">댓글</div>
		<div>
		  <c:forEach var="reply" items="${replies }">
		    <div class="py-2 border-b-2 border-slate-200">
               <div>${reply.name }</div>		
		       <div>${reply.body }</div>
		       <div>${reply.regDate }</div>
		     </div>
		  </c:forEach>
		</div>
	</div>
</section>	


<section>
	<div>
		<div>
		  <c:if test="${loginedMemberId != -1 }">
			<form action="/usr/reply/doWrite" method="post" onsubmit="replyForm_onSubmit(this); return false;">
				<input type="hidden" name="relTypeCode" value="article" />
				<input type="hidden" name="relId" value="${article.id }" />
					<textarea class="textarea textarea-bordered textarea-md w-full" name="body"></textarea>
					<div class="flex justify-end mb-2">
						<button class="btn btn-active btn-sm">작성</button>
					</div>
			</form>
		  </c:if>
		</div>
	</div>
</section>