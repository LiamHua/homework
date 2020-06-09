<%@ page import="per.liam.service.ProductService" %>
<%@ page import="per.liam.domain.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>商城首页</title>

		<!-- 引入Bootstrap核心样式文件 -->
		<link rel="stylesheet" href="static/css/bootstrap.css" />
		<!-- 引入jQuery核心js文件 -->
		<script type="text/javascript" src="static/js/jquery-1.11.3.min.js"></script>
		<!-- 引入BootStrap核心js文件 -->
		<script type="text/javascript" src="static/js/bootstrap.js"></script>
	</head>
	<body>
		<div class="container-fluid">
			<div class="col-md-12">
				<h2>热门商品&nbsp;&nbsp;<img src="static/img/hot/title2.jpg"/></h2>
			</div>
			<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
				<img src="static/img/hot/big01.jpg" width="205" height="404" style="display: inline-block;"/>
			</div>
			<div class="col-md-10">
				<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
					<a href="product_info.htm">
						<img src="static/img/hot/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
					</a>
				</div>

				<% ProductService productService = new ProductService();
					List<Product> products = productService.getProducts();
					if (products != null) {
				for (Product product : products) { %>
			
				<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
					<a href="product_info.htm">
						<img src="static/<%=product.getPimage()%>" width="130" height="130" style="display: inline-block;">
					</a>
					<p><a href="product_info.html" style='color:#666'><%=product.getPname()%>></a></p>
					<p><font color="#E4393C" style="font-size:16px"><%=product.getShopPrice()%></font></p>
				</div>

				<% } } %>

			</div>
		</div>
	</body>
</html>
