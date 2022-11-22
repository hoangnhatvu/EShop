<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<table class="table table-striped table-bordered table-hover"
											id="sample_2">

											<thead>

												<tr>

													<th>Ảnh đại diện</th>

													<th>Tên danh mục</th>

													<th>Code</th> 

													<th>Trạng thái</th>

													<th>Hành động</th>

												</tr>

											</thead>

											<tbody>

												<c:forEach var="item" items="${categorys}"> 

													<tr class="odd gradeX"> 

														<td><c:url value="/image?fname=category/${item.images!=null?item.images:'uploads/abc.jpg'}"
																var="imgUrl"></c:url> <img width="50px" height="50px"
															src="${imgUrl}"></td>

														<td>${item.categoryname }</td>

														<td>${item.categorycode }</td>

														<td><c:if test="${item.status == true}">

																<span class="label label-sm label-success"> Hoạt động </span>

															</c:if> <c:if test="${item.status ==false}">

																<span class="label label-sm label-warning"> Khóa </span>

															</c:if></td>

														<td><a
															href="<c:url value='/admin-category/edit?categoryId=${item.categoryId }'/>"
															class="center">Edit</a> | <a
															href="<c:url value='/admin-category/delete?categoryId=${item.categoryId }'/>"
															class="center">Delete</a></td>

													</tr>

												</c:forEach>

											</tbody>

										</table>
	
</div>
