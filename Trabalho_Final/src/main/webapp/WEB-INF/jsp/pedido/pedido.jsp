<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>


	<div class="container">
		<div class="panel panel-default">
			<c:if test="${pedidoFinalizado eq 'True'}">
				<div class="alert alert-success">
					<strong>Pedido Finalizado com Sucesso!!!</strong>
				</div>
			</c:if>
			<c:if test="${pedidoFinalizado eq 'False'}">
				<div class="alert alert-danger">
					<strong>Problemas ao finalizar o Pedido</strong>
				</div>
			</c:if>
			<c:if test="${not empty pedidoCancelado}">
				<div class="alert alert-success">
					<strong>${pedidoCancelado}</strong>
				</div>
			</c:if>

			<div class="panel-heading">
				<h3 class="panel-title" align="center">Emissão de Pedidos</h3>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="container-fluid spacePanelButtons">
				<div class="row">
					<div class="col-md-8">
						<span class="label label-default"><sec:authentication
								property="principal.username" /></span>
					</div>
					<div class="col-md-2">
						<span class="label label-default">Valor Total Pedido: <fmt:formatNumber
								value="${valorTotal}" type="currency" /></span>
					</div>
					<div class="col-md-2">
						<a href="/pedido/AtualizaStatusPedidoFechado"
							class="btn btn-success btn-block" type="button">Finalizar
							Pedido</a> <a href="/pedido/cancelarPedido"
							class="btn btn-danger btn-block" type="button">Cancelar
							Pedido</a>
					</div>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="container-fluid">
				<div class="row text-center">
					<c:forEach items="${produtos}" var="produto">
						<div class="col-md-4 spacePanel">
							<div class="thumbnail">
								<img class="tamanhoFoto" alt="Livro" src="${produto.foto}">
								<p align="center">${produto.nome}-
									<fmt:formatNumber value="${produto.valor}" type="currency" />
								</p>
								<a href="/pedido/adicionarProduto/${produto.codigo}"
									class="btn btn-success" type="button">Comprar</a>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
		<div class="panel-footer"></div>
	</div>
</body>
</html>