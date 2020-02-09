package cn.huizhi.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.User;

@Component
public class CustomInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();

		// UTL:除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
		if (uri.indexOf("/userLogin") >= 0) {
			return true;
		}
		Integer loginType = (Integer) request.getSession().getAttribute("loginType");
		if(loginType == null) {
			response.sendRedirect("login");
			return false;
		}
		if (loginType == 1) {
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				response.sendRedirect("login");
				return false;
			}
		}

		if (loginType == 2) {
			Teacher teacher = (Teacher) request.getSession().getAttribute("user");
			if (teacher == null) {
				// 不符合条件的给出提示信息，并转发到登录页面
				response.sendRedirect("login");
				return false;
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
