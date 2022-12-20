<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse"  style="position: fixed; height: 100%" >
	<div class="position-sticky pt-3 sidebar-sticky">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link"
				aria-current="page" href="../vendor/dashboard?id=${sessionScope.storeId}"> <span data-feather="home"
					class="align-text-bottom"></span> Dashboard
			</a></li>
			<li class="nav-item"><a class="nav-link" href="../vendor/order"> <span
					data-feather="file" class="align-text-bottom"></span> Đơn hàng
			</a></li>
			<li class="nav-item"><a class="nav-link" href="../vendor/product"> <span
					data-feather="shopping-cart" class="align-text-bottom"></span>
					Sản phẩm
			</a></li>
			<li class="nav-item"><a class="nav-link" href="../vendor/staff"> <span
					data-feather="users" class="align-text-bottom"></span> Nhân viên
			</a></li>
			
			<li class="nav-item"><a class="nav-link" href="../vendor/store-edit"> <span
					data-feather="user" class="align-text-bottom"></span> Chỉnh sửa thông tin
			</a></li>			
		</ul>
	</div>
</nav>
