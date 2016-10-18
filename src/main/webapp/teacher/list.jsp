<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h2>教师列表</h2>
	<table class='table table-striped table-bordered'>
		<thead>
			<tr>
				<th>姓名</th>
				<th>电子邮件</th>
				<th>电话</th>
				<th>职称</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${teachers }" var="t">
				<tr>
					<td>${t.name }</td>
					<td>${t.email }</td>
					<td>${t.phone }</td>
					<td>${t.duty }</td>
					<td><a class='ajax-link' href="teacher/update.do?id=${t.id }">修改</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

