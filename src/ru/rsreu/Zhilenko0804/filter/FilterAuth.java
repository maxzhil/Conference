package ru.rsreu.Zhilenko0804.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ru.rsreu.Zhilenko0804.data.UserType;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;

public class FilterAuth implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");

		if (type == null) {
			type = UserType.GUEST.toString();
			session.setAttribute("type", type);
			RequestDispatcher dispatcher = request
					.getServletContext()
					.getRequestDispatcher(
							ConfigurationManager.getProperty("path.page.login"));

			dispatcher.forward(request, response);
			return;
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
