<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h2>考题列表</h2>
	<table class='table table-striped table-bordered'>
		<thead>
			<tr>
				<th>科目名称</th>
				<th>考题内容</th>
				<th>类型</th>
				<th>学分</th>
				<th>
				<a class="ajax-link" href="question/add.do">添加</a>
				</th>
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

