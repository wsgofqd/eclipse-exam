<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h3>添加考题</h3>
	<div class="row">
		<div class="col-sm-6">
			<form action="question/add.do" method="post" class="form-horizontal ajax-form">
				<div class="form-group">
					<label for="subject-id" class="col-sm-2 control-label">科目名称</label>
					<div class="col-sm-10">
						<select name="subject.id" class="form-control" id='subject-id'>
							<c:forEach items="${subjects }" var="sub">
								<option value="${sub.id }">${sub.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">考题内容</label>
					<div class="col-sm-10 ">
						<input type="text" name="title" class="form-control" id="title" />
					</div>

				</div>
				<div class="form-group field-type">
					<label for="type" class="col-sm-2 control-label">类型</label>
					<div class="col-sm-10">
						<label class="radio-inline"> <input type="radio" name="type" value="1"
							checked>单选
						</label> <label class="radio-inline"> <input type="radio" name="type" value="2">多选
						</label>
					</div>
				</div>
				<fieldset>
					<c:forEach begin="1" end="4" step="1" var="i">
						<div class="form-group">
							<label for="item${i }" class="col-sm-2 control-label">选项${i }</label>
							<div class="col-sm-10">
								<div class="input-group">
									<input type="text" name="item${i }" class="form-control" id="item${i }">
									<span class="input-group-addon"> <input type='radio' value='${i }'
										name="answer" class='field-answer'>
									</span>
								</div>
							</div>

						</div>
					</c:forEach>
				</fieldset>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<input type="submit" class="btn btn-primary" value="保存">
					</div>
				</div>

			</form>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('div.field-type :radio').on('click', function() {
				if ($(this).val() == '1')
					$('.field-answer').attr('type', 'radio');
				else
					$('.field-answer').attr('type', 'checkbox');
			});
		});
	</script>
</div>
