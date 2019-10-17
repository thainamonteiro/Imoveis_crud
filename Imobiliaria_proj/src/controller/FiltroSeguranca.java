package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Login;

public class FiltroSeguranca implements Filter {

	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) req).getSession();

		String login = (String) session.getAttribute("usuario");

		if (login == null) {

			session.setAttribute("msg", "Ops, você não está logado no sistema!");

			req.getRequestDispatcher("../login.jsp").forward(req, res);
/*			((HttpServletResponse) res).sendRedirect("../login.jsp");*/

		} else {

			chain.doFilter(req, res);

		}
	}
	
	  public void destroy() {

      }

}
