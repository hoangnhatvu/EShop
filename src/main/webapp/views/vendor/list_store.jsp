<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<table class="table table-striped table-bordered table-hover"
											id="sample_2">

											<thead>

												<tr>

													<th>Ảnh đại diện</th>

													<th>Tên cửa hàng</th>

													<th>Mô tả</th> 

													<th>Trạng thái</th>

													<th>Hành động</th>

												</tr>

											</thead>

											<tbody>

												<c:forEach var="item" items="${storeList}"> 

													<tr class="odd gradeX"> 

														<td><c:url value="/image?fname=category/${item.avatar}"
																var="imgUrl"></c:url> <img width="50px" height="50px"
															src="${imgUrl}"></td>

														<td>${item.name }</td>

														<td>${item.bio }</td>

														<td><c:if test="${item.isActive == true}">

																<span class="label label-sm label-success"> Hoạt động </span>

															</c:if> <c:if test="${item.isActive ==false}">

																<span class="label label-sm label-warning"> Khóa </span>

															</c:if></td>

														<td><a															
															href="<c:url value='/admin-category/delete?categoryId=${item.id }'/>"
															class="center">Delete</a></td>

													</tr>

												</c:forEach>

											</tbody>

										</table>
	
</div>
