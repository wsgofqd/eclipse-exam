<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述2个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->


<title>在线考试系统</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="styles/styles.css" rel="stylesheet">


</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">

				<a class="navbar-brand" href="#">在线考试系统</a>
			</div>
			<div id="navbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">退出系统</a></li>
				</ul>

			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a class='ajax-link' href="teacher/list.do">教师管理</a></li>
					<li><a class='ajax-link' href="#">科目管理</a></li>
					<li><a class='ajax-link' href="question/list.do">考题管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			</div>
		</div>
	</div>
	<!-- 注意：</script> 不能省略 -->
	<script type="text/javascript" src="jquery/jquery.js"></script>
	<script type="text/javascript">
		//下面两种写法效果一样，都是在页面装载完毕后执行那个作为参数的function
		//  $(function(){});
		jQuery(function($) {
			window.$main = $('div.main');

			var s = $('div.abc');
			if (s.length) {
				alert('aaaaaaaaaaaa')
			}
			//$('a.ajax-link')
			//处理超链接异步加载
			$('body').on('click', 'a.ajax-link', function(event) {
				event.preventDefault();
				$main.load($(this).attr('href'));
				//$.get(url,function(rt){$main.html(rt)})
			});
			//处理表单异步提交
			$('body').on('submit', 'form.ajax-form', function(event) {
				event.preventDefault();
				var fm = $(this)
				var data = fm.serialize(), action = fm.attr('action');
				$.post(action, data, function(rt) {
					$main.html(rt);
				});
			});

		});
	</script>
</body>
</html>
