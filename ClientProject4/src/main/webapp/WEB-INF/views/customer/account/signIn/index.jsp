<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<section class="vh-100" style="background-color: #9A616D;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-xl-10">
					<div class="card" style="border-radius: 1rem;">
						<div class="row g-0">
							<div class="col-md-6 col-lg-5 d-none d-md-block">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
									alt="login form" class="img-fluid"
									style="border-radius: 1rem 0 0 1rem;" />
							</div>
							<div class="col-md-6 col-lg-7 d-flex align-items-center">
								<div class="card-body p-4 p-lg-5 text-black">

									<s:form method="post" modelAttribute="login"
										action="${pageContext.request.contextPath }/customer/account/signIn">

										<div class="d-flex align-items-center mb-3 pb-1">
											<i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
											<span class="h1 fw-bold mb-0">Logo</span>
										</div>

										<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign
											into your account</h5>
										<p class="text-danger">${msg}</p>
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example17">Email
												address</label> <s:input path="email" type="email" id="form2Example17"
												class="form-control form-control-lg" required="required" />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">Password</label>
											<s:input path="password" type="password" id="form2Example27"
												class="form-control form-control-lg" required="required" />

										</div>

										<div class="pt-1 mb-4">
											<button class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
										</div>

										<a class="small text-muted" href="#!">Forgot password?</a>
										<p class="mb-5 pb-lg-2" style="color: #393f81;">
											Don't have an account? <a
												href="${pageContext.request.contextPath }/customer/account/register"
												style="color: #393f81;">Register here</a>
										</p>
										<a href="#!" class="small text-muted">Terms of use.</a> <a
											href="#!" class="small text-muted">Privacy policy</a>
									</s:form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
