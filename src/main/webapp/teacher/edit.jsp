<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<h3>修改教师信息</h3>
	<form action="teacher/update.do" method="post" class="form-horizontal ajax-form">
		<input type="hidden" name="id" value="${teacher.id }">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-10">
				<input type="text" name="name" class="form-control" id="name"
					value="${teacher.name }">
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">电子邮件</label>
			<div class="col-sm-10">
				<input type="email" name="email" class="form-control" id="email"
					value="${teacher.email }">
			</div>
		</div>
		<div class="form-group">
			<label for="phone" class="col-sm-2 control-label">电话</label>
			<div class="col-sm-10">
				<input type="text" name="phone" class="form-control" id="phone"
					value="${teacher.phone }">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-8">
				<input type="submit" class="btn btn-default" value="保存">
			</div>
		</div>

	</form>
</div>
