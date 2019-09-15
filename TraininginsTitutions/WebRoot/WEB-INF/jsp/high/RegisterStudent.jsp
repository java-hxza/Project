<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set scope="request" value="${pageContext.request.contextPath }"
	var="Path" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Hyper - Responsive Bootstrap 4 Admin Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta
	content="A fully featured admin theme which can be used to build CRM, CMS, etc."
	name="description" />
<meta content="Coderthemes" name="author" />
<!-- App favicon -->
<link rel="shortcut icon" href="assets/images/favicon.ico">
<!-- App css -->
<link href="${Path }/static/css/icons.min.css" rel="stylesheet"
	type="text/css" />
<link href="${Path }/static/css/app.min.css" rel="stylesheet"
	type="text/css" />

</head>

<body>

	<!-- Begin page -->
	<div class="wrapper">

		<!-- ========== Left Sidebar Start ========== -->
		<%@include file="/WEB-INF/jsp/leftSidebar/leftSidebar.jsp"%>
		<!-- Left Sidebar End -->
		<div class="content-page">
			<div class="content">
				<!-- Topbar Start -->
				<div class="navbar-custom">
					<ul class="list-unstyled topbar-right-menu float-right mb-0">


						<li class="dropdown notification-list"><a
							class="nav-link dropdown-toggle nav-user arrow-none mr-0"
							data-toggle="dropdown" href="#" role="button"
							aria-haspopup="false" aria-expanded="false"> <span
								class="account-user-avatar"> <img
									src="${Path }/static/images/avatar-1.jpg" alt="user-image"
									class="rounded-circle">
							</span> <span> <span class="account-user-name">${user.loginName }
								</span> <span class="account-position">管理员</span>
							</span>
						</a>
							<div
								class="dropdown-menu dropdown-menu-right dropdown-menu-animated topbar-dropdown-menu profile-dropdown">
								<!-- item-->
								<div class=" dropdown-header noti-title">
									<h6 class="text-overflow m-0">欢迎 !</h6>
								</div>

								<!-- item-->
								<a href="javascript:void(0);" class="dropdown-item notify-item">
									<i class="mdi mdi-account-circle mr-1"></i> <span>我的账户</span>
								</a>

								<!-- item-->
								<a href="javascript:void(0);" class="dropdown-item notify-item"
									onclick="switchingAccounts()"> <i
									class="mdi mdi-account-edit mr-1"></i> <span>切换账号 </span>
								</a>

								<!-- item-->
								<a href="javascript:void(0);" class="dropdown-item notify-item">
									<i class="mdi mdi-lifebuoy mr-1"></i> <span>设置 </span>
								</a>


							</div></li>

					</ul>
					<button class="button-menu-mobile open-left disable-btn">
						<i class="mdi mdi-menu"></i>
					</button>
					<div class="app-search">
						<form>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="mdi mdi-magnify"></span>
								<div class="input-group-append">
									<button class="btn btn-primary" type="submit">Search</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- end Topbar -->

				<!-- Start Content-->
				<div class="container-fluid">
					<!-- start page title -->
					<div class="row">
						<div class="col-12">
							<div class="page-title-box">
								<div class="page-title-right">
									<ol class="breadcrumb m-0">
										<li class="breadcrumb-item"><a
											href="javascript: void(0);">培训收费</a></li>
										<li class="breadcrumb-item"><a
											href="javascript: void(0);">注册学生</a></li>
									</ol>
								</div>
								<h4 class="page-title">注册学生</h4>
							</div>
						</div>
					</div>
					<!-- end page title -->

					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">

									<!-- Checkout Steps -->
									<ul class="nav nav-pills bg-nav-pills nav-justified mb-3">
										<li class="nav-item"><a href="#billing-information"
											data-toggle="tab" aria-expanded="false"
											class="nav-link rounded-0 active"> <i
												class="mdi mdi-account-circle font-18"></i> <span
												class="d-none d-lg-block">请录入学员信息</span>
										</a></li>

									</ul>

									<!-- Steps Information -->
									<div class="tab-content">

										<!-- Billing Content-->
										<div class="tab-pane show active" id="billing-information">
											<div class="row">
												<div class="col-lg-8">
													<input type="button" class="btn btn-danger mb-2" value="连接"
														onclick="connect()"> <input type="button"
														class="btn btn-danger mb-2" value="读卡"
														onclick="readCert()"> <input type="button"
														class="btn btn-danger mb-2" value="断开"
														onclick="disconnect()">
													<h4 class="mt-2" style="text-align: center;">少儿学员信息录入</h4>
													<form novalidate>
														<div class="row">
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-first-name">姓名</label> <input
																		class="form-control studentName" type="text"
																		placeholder="学员姓名" id="studentName" /> <span
																		class="${schoolTypes }" id="LX" style="display: none;"></span>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-last-name">性别</label> <select
																		class="form-control studentSex" id="example-select">
																		<option value="1">男</option>
																		<option value="0">女</option>
																	</select>
																</div>
															</div>
														</div>
														<!-- end row -->
														<div class="row">
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-email-address">家长姓名<span
																		class="text-danger">*</span></label> <input
																		class="form-control parentName" type="email"
																		placeholder="家长姓名" id="parentName" />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label>手机号</label> <input type="text"
																		class="form-control telephone"
																		data-toggle="input-mask"
																		data-mask-format="000-0000-0000"> <span
																		class="font-13 text-muted">例如： "xxx-xxxx-xxxx"</span>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col-12">
																<div class="form-group">
																	<label for="billing-address">出生日期</label> <input
																		class="form-control studentBirth" type="date"
																		placeholder="出生日期" id="studentBirth">
																</div>
															</div>
														</div>
														<!-- end row -->
														<div class="row">
															<div class="col-6">
																<div class="form-group">
																	<label for="billing-address">家庭住址</label> <input
																		class="form-control familyAddress" type="text"
																		placeholder="家庭住址" id="familyAddress">
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-last-name">身份证号</label> <input
																		type="text" class="form-control studentIDCard"
																		data-toggle="input-mask"
																		data-mask-format="00000000000000000"
																		data-reverse="true">
																</div>
															</div>
														</div>
														<!-- end row -->
														<div class="row">
															<div class="col-md-4">
																<div class="form-group">
																	<label for="billing-town-city">学校</label> <input
																		class="form-control school" type="text"
																		placeholder="在读学校" id="school" />
																</div>
															</div>
															<div class="col-md-4">
																<div class="form-group">
																	<label for="billing-state">报名渠道</label> <input
																		class="form-control registrationChannels" type="text"
																		placeholder="报名渠道" id="registrationChannels" />
																</div>
															</div>
															<div class="col-md-4">
																<div class="form-group">
																	<label for="billing-zip-postal">报名老师</label> <input
																		class="form-control registrationConsultant"
																		type="text" placeholder="报名老师"
																		id="registrationConsultant" />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-zip-postal">接送人</label> <input
																		class="form-control theSurrogate" type="text"
																		placeholder="接送人" id="registrationConsultant" />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-zip-postal">报名时间</label> <input
																		class="form-control startTime" type="date"
																		placeholder="默认是当前时间" id=startTime />
																</div>
															</div>
															<div class="col-md-6 classType1">
																<div class="form-group">
																	<label for="billing-zip-postal">班级类别</label> <select
																		class="form-control classType">
																		<option value="0">---请选择---</option>
																		<option value="1">课时班</option>
																		<option value="2">VIP课时班</option>
																		<option value="3">速成班</option>
																		<option value="4">VIP速成班</option>
																	</select>
																</div>
															</div>
															<div class="col-md-6 classes1">
																<div class="form-group">
																	<label for="billing-zip-postal">班级选择</label> <select
																		class="form-control classes">
																	</select>
																</div>
															</div>
														</div>

														<div class="row">
															<div class="col-12">

																<div class="form-group mt-3">
																	<label for="example-textarea">备注</label>
																	<textarea class="form-control remarks" rows="3"
																		placeholder="Write some note.."></textarea>
																</div>
															</div>
														</div>

														<div class="row hour" style="display: none;">
															<div class="col-md-12">
																<h4 style="text-align:center">按课时收费</h4>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">学员名称</label> <input
																		class="form-control studentNames" type="text"
																		id="studentName" disabled />

																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-last-name">收费日期</label> <input
																		class="form-control dates" type="text"
																		id="billing-last-name" disabled />
																</div>
															</div>

															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-number">收费金额</label> <input
																		class="form-control moneys" id="example-number"
																		type="number" name="number">
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-number">本次新增课时</label> <input
																		type="text" class="form-control hours"
																		data-toggle="input-mask"
																		data-mask-format="00000000000000000"
																		data-reverse="true" value="0">
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">交费方式</label> <select
																		class="form-control paymentmethodIds"
																		id="example-select">
																		<c:forEach items="${paymentMethod }" var="p">
																			<option value="${p.paymentmethodId }">${p.paymentmethodName}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-number">本次赠送课时</label> <input
																		type="text" class="form-control hourses"
																		data-toggle="input-mask"
																		data-mask-format="00000000000000000"
																		data-reverse="true" value="0">
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">核算项目</label> <select
																		class="form-control feecateIds" id="example-select">
																		<c:forEach items="${feeCategory }" var="f">
																			<option value="${f.chargeTypeId }"
																				name="${f.chargeMoney }">${f.chargeTypeName}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">课程名称</label> <input
																		class="form-control departmentofpediatricsIds"
																		type="text" id="billing-last-name" disabled />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">赠品名称</label> <select
																		class="form-control giftNames" id="example-select">
																		<option value="0">---请选择---</option>
																		<c:forEach items="${gift }" var="g">
																			<option value="${g.giftId }" name="${g.giftNumber }">${g.giftName}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-last-name">赠品数量</label> <input
																		type="text" class="form-control giftNumbers"
																		data-toggle="input-mask"
																		data-mask-format="00000000000000000"
																		data-reverse="true">
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">积分</label> <input
																		class="form-control integrals" id="example-number"
																		type="number" name="number">
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-last-name">备注信息</label> <input
																		class="form-control remarks2" type="text"
																		id="billing-last-name" />
																</div>
															</div>
															<div class="col-md-12">
																<div class="form-group">
																	<select class="form-control teacherIds"
																		style="text-align: center; text-align-last: center;"
																		id="example-select">
																		<option value="0">招生老师</option>
																		<c:forEach items="${teacher }" var="t">
																			<option value="${t.teacherId }">${t.teacherName}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
														</div>

														<div class="row charge" style="display: none;">
															<div class="col-md-12">
																<h4 style="text-align:center">按时间段收费</h4>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">学员</label> <input
																		class="form-control studentName2" type="text"
																		id="studentName" disabled />
																</div>
															</div>
															<c:forEach items="${feeCategory }" var="f">
																<div class="col-md-6">
																	<div class="form-group mb-3">
																		<label for="example-select">${f.chargeTypeName}</label>
																		<input class="form-control feecateIds2"
																			id="example-number" type="number" name="number"
																			chargeTypeId="${f.chargeTypeId }"
																			value="${f.chargeMoney }">

																	</div>
																</div>
															</c:forEach>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">收款方式</label> <select
																		class="form-control paymentmethodId2"
																		id="example-select">
																		<c:forEach items="${paymentMethod }" var="p">
																			<option value="${p.paymentmethodId }">${p.paymentmethodName}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">课程名称</label> <input
																		class="form-control departmentofpediatricsIds2"
																		type="text" id="billing-last-name" disabled />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-last-name">收款日期</label> <input
																		class="form-control date2" type="text"
																		id="billing-last-name" disabled />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-date">起始日期</label> <input
																		class="form-control firstdate" id="example-date"
																		type="date" name="date">
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-date">截止日期</label> <input
																		class="form-control lastdate" id="example-date"
																		type="date" name="date">
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-number">收费总金额</label> <input
																		class="form-control dpMoney" id="example-number"
																		type="number" name="number">
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">积分</label> <input
																		class="form-control integral2" id="example-number"
																		type="number" name="number">
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">赠品名称</label> <select
																		class="form-control giftName2" id="example-select">
																		<option value="0">---请选择---</option>
																		<c:forEach items="${gift }" var="g">
																			<option value="${g.giftId }" name="${g.giftNumber }">${g.giftName}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-last-name">赠品数量</label> <input
																		type="text" class="form-control giftNumber2"
																		data-toggle="input-mask"
																		data-mask-format="00000000000000000"
																		data-reverse="true" disabled>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-first-name">责任人</label> <input
																		class="form-control personliable2" type="text"
																		id="billing-first-name" />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="billing-last-name">备注</label> <input
																		class="form-control remarks3" type="text"
																		id="billing-last-name" />
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-select">活动名称</label> <select
																		class="form-control feecateId3 " id="example-select">
																		<option value="0">---请选择---</option>
																		<c:forEach items="${activity }" var="a">
																			<option value="${a.activityId }"
																				activityMoneylast="${a.activityMoneylast }"
																				discount="${a.discount }">
																				<c:choose>
																					<c:when test="${a.activityMoneyfirst == null }">${a.discount }折</c:when>
																					<c:otherwise>满&nbsp;${a.activityMoneyfirst }&nbsp;减&nbsp;${a.activityMoneylast }</c:otherwise>
																				</c:choose>
																			</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group mb-3">
																	<label for="example-number">打折后金额</label> <input
																		class="form-control dpMoneyActivity"
																		id="example-number" type="number" name="number"
																		disabled>
																</div>
															</div>
															<div class="col-md-12">
																<div class="form-group">
																	<select class="form-control teacherId2"
																		style="text-align: center; text-align-last: center;"
																		id="example-select">
																		<option value="0">招生老师</option>
																		<c:forEach items="${teacher }" var="t">
																			<option value="${t.teacherId }">${t.teacherName}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>

														</div>

														<div class="col-md-12">
															<div class="form-group">
																<button type="button"
																	class="btn btn-block btn-primary TiJiao">提交</button>
															</div>
														</div>
														<!-- end col -->
													</form>
												</div>
												<!-- end row -->

											</div>
										</div>
										<!-- End Billing Information Content-->
									</div>
									<!-- end tab content-->

								</div>
								<!-- end card-body-->
							</div>
							<!-- end card-->
						</div>
						<!-- end col -->
					</div>
					<!-- end row-->

				</div>
				<!-- container -->

			</div>
			<!-- content -->

			<table border="0" width="50%" cellpadding="0" cellspacing="0"
				style="padding-left:100px;display: none;">
				<tr>
					<td><input type="button" value="连接aaa" onclick="connect()"></td>
					<td><input type="button" value="状态" onclick="getStatus()"></td>
					<td><input type="button" value="版本" onclick="getVerSion()"></td>
					<td><input type="button" value="SamID" onclick="getSamId()"></td>
					<td><input type="button" value="读卡" onclick="readCert()"></td>
					<td><input type="button" value="断开" onclick="disconnect()"></td>
				</tr>
			</table>
			<br />
			<table border="0" width="100%" cellpadding="0" cellspacing="10"
				style="display: none;">
				<tr>
					<td align="right">读卡时间：</td>
					<td><input type="text" id="timeElapsed" size="49"
						style="width:400px;" readonly="readonly"></td>
				</tr>

				<tr>
					<td align="right">姓名：</td>
					<td><input type="text" id="partyName" size="49"
						style="width:400px;" readonly="readonly">(要求中间，两头都没有空格)</td>
					<td><img id="PhotoStr" src="" alt="Base64 image" /></td>
				</tr>
				<tr>
					<td align="right">中文姓名：</td>
					<td><input type="text" id="chineseName" size="49"
						style="width:400px;" readonly="readonly">(外国人居留证专有项)</td>
					<td><img id="Img1" src="" alt="Base64 image" /></td>
				</tr>
				<tr>
					<td align="right">性别：</td>
					<td><input type="text" id="gender" size="49"
						style="width:400px;" readonly="readonly">(取值为“1”（表示“男”）或“0”（表示“女”）)</td>
				</tr>
				<tr>
					<td align="right">民族/国籍：</td>
					<td><input type="text" id="nation" size="49"
						style="width:400px;" readonly="readonly">(居民民族或外国人居留证国籍，港澳台无此项)</td>
				</tr>
				<tr>
					<td align="right">出生日期：</td>
					<td><input type="text" id="bornDay" size="49"
						style="width:400px;" readonly="readonly">(要求格式为:yyyyMMdd，长度为8)</td>
				</tr>
				<tr>
					<td align="right">住址：</td>
					<td><input type="text" id="certAddress" size="49"
						style="width:400px;" readonly="readonly"></td>
				</tr>
				<tr>
					<td align="right">证件类型：</td>
					<td><input type="text" id="certType" size="49"
						style="color:#FF0000;width:400px;" readonly="readonly">(证件类型)</td>
				</tr>
				<tr>
					<td align="right">证件号码：</td>
					<td><input type="text" id="certNumber" size="49"
						style="color:#FF0000;width:400px;" readonly="readonly">(证件号码)</td>
				</tr>
				<td align="right">港澳台通行证号码：</td>
				<td><input type="text" id="passportNo" size="49"
					style="color:#FF0000;width:400px;" readonly="readonly">(港澳台通行证号码)</td>
				</tr>
				<td align="right">港澳台签注次数：</td>
				<td><input type="text" id="signNum" size="49"
					style="color:#FF0000;width:400px;" readonly="readonly">(港澳台签注次数)</td>
				</tr>
				<tr>
					<td align="right">签发机关：</td>
					<td><input type="text" id="certOrg" size="49"
						style="width:400px;" readonly="readonly"></td>
				</tr>
				<tr>
					<td align="right">开始期限：</td>
					<td><input type="text" id="effDate" size="49"
						style="width:400px;" readonly="readonly">(要求格式为:yyyyMMdd，长度为8)</td>
				</tr>
				<tr>
					<td align="right">结束期限：</td>
					<td><input type="text" id="expDate" size="49"
						style="width:400px;" readonly="readonly">(要求格式为:yyyyMMdd，长度为8，或者是“长期”)</td>
				</tr>
				<tr>
					<td align="right">结果：</td>
					<td><textarea id="result" rows="8" cols="47"
							style="width:400px;" readonly="readonly"></textarea></td>
				</tr>

				<tr>
					<td align="right">jpg路径：</td>
					<td><input type="text" id="inputJpgPath" size="49"
						style="width:400px;"></td>
				</tr>

				<tr>
					<td align="right">base64数据：</td>
					<td><textarea id="outputBase64File" rows="8" cols="47"
							style="width:400px;"></textarea><input type="button" value="转码"
						onclick="conv2base64()"></td>
				</tr>

				<td align="right">base64数据：</td>
				<td><textarea id="base64Input" rows="8" cols="47"
						style="width:400px;"></textarea></td>
				</tr>

				<tr>
					<td align="right">解码jpg路径：</td>
					<td><input type="text" id="decodeJpgPath" size="49"
						style="width:400px;"><input type="button" value="解码"
						onclick="convBase64ToJpg()"></td>
				</tr>


			</table>

			<!-- Footer Start -->
			<footer class="footer">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6">2018 - 2019 Â© Hyper - Coderthemes.com</div>
						<div class="col-md-6">
							<div class="text-md-right footer-links d-none d-md-block">
								<a href="javascript: void(0);">About</a> <a
									href="javascript: void(0);">Support</a> <a
									href="javascript: void(0);">Contact Us</a>
							</div>
						</div>
					</div>
				</div>
			</footer>
			<!-- end Footer -->

		</div>

		<!-- ============================================================== -->
		<!-- End Page content -->
		<!-- ============================================================== -->


	</div>
	<!-- END wrapper -->


	<!-- Right Sidebar -->


	<div class="rightbar-overlay"></div>
	<!-- /Right-bar -->


	<!-- third party js -->
	<%@include file="/WEB-INF/jsp/importJsFoot/foot.jsp"%>
	<script type="text/javascript"
		src="${Path }/static/js/highes/leftSidebar.js"></script>
	<script type="text/javascript"
		src="${Path }/static/js/highes/RegisterStudent.js"></script>
	<!-- third party js ends -->
	<object id="CertCtl" type="application/cert-reader" width="0"
		height="0">
		<p style="color:#FF0000;">控件不可用，可能未正确安装控件及驱动，或者控件未启用。</p>
	</object>
</body>
</html>
