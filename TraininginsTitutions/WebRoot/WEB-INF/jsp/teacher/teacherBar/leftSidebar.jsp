<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <div class="left-side-menu">

			<div class="slimscroll-menu" id="left-side-menu-container">

				<!-- LOGO -->
				<a href="index.html" class="logo text-center"> <span
					class="logo-lg"> <img src="${Path }/static/images/logo.png"
						alt="" height="16">
				</span> <span class="logo-sm"> <img
						src="${Path }/static/images/logo_sm.png" alt="" height="16">
				</span>
				</a>

				<!--- Sidemenu -->
				<ul class="metismenu side-nav">

					<li class="side-nav-title side-nav-item">基础设置</li>

					<li class="side-nav-item"><a href="javascript: void(0);"
						class="side-nav-link"> <i class="dripicons-meter"></i> <span
							class="badge badge-success float-right">8</span> <span>校区信息
						</span>
					</a>
						<ul class="side-nav-second-level" aria-expanded="false">
						
							<li><a href="javascript:void(0)" onclick="Teacher()">教师信息</a></li>
							<li><a href="javascript:void(0)"onclick="">课程信息</a></li>
							<li><a href="javascript:void(0)"onclick="">班级信息</a></li>
							<li><a href="javascript:void(0)"onclick="">学员信息</a></li>
						</ul></li>
					<li class="side-nav-item"><a href="javascript: void(0);"
						class="side-nav-link"> <i class="dripicons-view-apps"></i> <span>
								班级管理</span> <span class="menu-arrow"></span>
					</a>
						<ul class="side-nav-second-level" aria-expanded="false">
							<li><a href="javascript:void(0)"onclick="">学员信息管理 </a></li>
							<li><a href="javascript:void(0)"onclick="">学员班级管理 -->分班</a></li>
							<li><a href="ajavascript:void(0)"onclick="">上课登记</a></li>
							<li><a href="javascript:void(0)"onclick="">上课批量登记</a></li>

						</ul></li>
					
					

					<li class="side-nav-item"><a href="javascript: void(0);"
						class="side-nav-link"> <i class="dripicons-view-apps"></i> <span>
								系统维护</span> <span class="menu-arrow"></span>
					</a>
						<ul class="side-nav-second-level" aria-expanded="false">
							<li><a href="javascript:void(0)"onclick="operatorChilk()">修改密码</a></li>
						</ul></li>
				</ul>

				<!-- End Sidebar -->
				
				<div class="clearfix"></div>

			</div>

            <!-- Sidebar -left -->

        </div>
