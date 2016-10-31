<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Pedidos</title>

<!-- Bootstrap -->
<link href="<c:url value="/static/css/bootstrap.min.css"/>"
	rel="stylesheet">

<link href="<c:url value="/static/css/style.css"/>" rel="stylesheet">

<link href="<c:url value="/static/css/jquery-ui.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/static/css/jquery-ui.structure.min.css"/>"
	rel="stylesheet">


<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel='stylesheet' type='text/css'>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>


	<div class="container">
		<div class="row">

			<div class="col-md-10 col-md-offset-1">

				<div class="panel panel-default panel-table">
					<div class="panel-heading">
						<div class="row">
							<div class="col col-md-6">
								<h5 class="he">
									<sec:authentication property="principal.username" />
								</h5>
							</div>
							<!-- Button -->
							<div class="form-horizontal text-right">

								<div class="form-group">
									<label class="col-md-6 text-right" for="btnFinalizar"></label>
									<div class="col-md-5">
										<button id="btnFinalizar" name="btnFinalizar"
											class="btn btn-primary">Finalizar Compra</button>
									</div>
								</div>

								<!-- Button -->
								<div class="form-group">
									<label class="col-md-6 text-right" for="btnCancelarCompra"></label>
									<div class="col-md-5">
										<button id="btnCancelarCompra" name="btnCancelarCompra"
											class="btn btn-danger">Cancelar Compra</button>
									</div>
								</div>

							</div>
						</div>
					</div>

					<div class="panel-body">
						<table class="table table-striped table-bordered table-list">
							<thead>
								<tr>
									<th class="hidden-xs">C�digo</th>
									<th>Nome</th>
									<th>Valor</th>
									<th><i class="glyphicon glyphicon-shopping-cart"></i></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${produtos}" var="produto">
									<tr>
										<td class="hidden-xs">${produto.codigo}</td>
										<td>${produto.nome}</td>
										<td>${produto.valor}</td>
										<td align="center"><i>
											href="<c:url value=""/>"
											class="btn btn-default">Comprar</i>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer">
						<div class="row">
							<div class="col col-xs-4">Page 1 of 5</div>
							<div class="col col-xs-8">
								<ul class="pagination hidden-xs pull-right">
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
								</ul>
								<ul class="pagination visible-xs pull-right">
									<li><a href="#"></a></li>
									<li><a href="#"></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
	<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/static/js/jquery-ui.min.js"/>"></script>
</body>
</html>