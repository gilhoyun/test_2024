<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<%@ include file="/WEB-INF/jsp/common/header.jsp"%>

<script>
	const doWriteForm_onSubmit = function(form) {
		form.title.value = form.title.value.trim();
		form.body.value = form.body.value.trim();

		if (form.title.value.length == 0) {
			alert('제목을 입력해주세요.');
			form.title.focus();
			return;
		}

		if (form.body.value.length == 0) {
			alert('내용을 입력해주세요.');
			form.body.focus();
			return;
		}

		form.submit();
	}
</script>


<section class="mt-8">
	<div class="container mx-auto">
		<form action="/usr/article/doWrite" method="post"
			onsubmit="doWriteForm_onSubmit(this); return false;">
			<div class="w-9/12 mx-auto">
				<table class="table table-lg">
					<tr>
						<th>제목</th>
						<td><input class="input input-bordered w-full max-w-xs"
							type="text" name="title" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea class="textarea textarea-bordered w-full max-w-xs"  type="text" name="body" /></textarea></td>
					</tr>
				</table>
				<div class="flex justify-center mt-6">
					<button class="btn btn-wide" type="submit">등록</button>
				</div>
		</form>

	</div>
	</div>
</section>