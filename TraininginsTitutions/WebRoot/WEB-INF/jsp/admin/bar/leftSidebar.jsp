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
							<li><a href="#" onclick="Accountinformation()">学校账户信息</a></li>
							<li><a href="#" onclick="Incomeitems()">学校收入项目</a></li>
							<li><a href="#" onclick="Expenditureitemses()">学校支出项目</a></li>
							<li><a href="#" onclick="Teacher()">教师信息</a></li>
						</ul></li>
				
					
					<li class="side-nav-item"><a href="javascript: void(0);"
						class="side-nav-link"> <i class="dripicons-view-apps"></i> <span>
								报表统计</span> <span class="menu-arrow"></span>
					</a>
						<ul class="side-nav-second-level" aria-expanded="false">
							<li><a href="apps-calendar.html">资金账余额</a></li>
							<li><a href="apps-calendar.html">收支明细报表</a></li>
							<li><a href="apps-tasks.html">收支汇总报表</a></li>
							<li><a href="apps-calendar.html">教师课时总表</a></li>
							<li><a href="apps-calendar.html">学院课时总表</a></li>
							<li><a href="apps-tasks.html">新增学院报表</a></li>
							<li><a href="apps-tasks.html">教师上课明细</a></li>
						</ul></li>

					<li class="side-nav-item"><a href="javascript: void(0);"
						class="side-nav-link"> <i class="dripicons-view-apps"></i> <span>
								系统维护</span> <span class="menu-arrow"></span>
					</a>
						<ul class="side-nav-second-level" aria-expanded="false">
							<li><a href="apps-calendar.html">操作员</a></li>
							<li><a href="apps-calendar.html">操作员授权</a></li>
							<li><a href="apps-tasks.html">修改密码</a></li>
						</ul></li>
				</ul>

				<!-- End Sidebar -->
				
				<div class="clearfix"></div>

			</div>

            <!-- Sidebar -left -->

        </div>
