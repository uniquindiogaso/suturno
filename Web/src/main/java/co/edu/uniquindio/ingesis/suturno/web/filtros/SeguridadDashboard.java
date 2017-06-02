package co.edu.uniquindio.ingesis.suturno.web.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.uniquindio.ingesis.suturno.web.bean.SeguridadBean;

/**
 * Filtro de Seguridad Dashboard Aplicacion suturno
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 06/05/2017
 * @version 1.0
 *
 */
@WebFilter("/views/*")
public class SeguridadDashboard implements Filter{

	public SeguridadDashboard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Permitir el filtrado de las peticiones que se realizan sobre el
	 * recurso protegido y de acuerdo a si tiene permisos hacer la redireccion correspondiente
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String loginURL = request.getContextPath() + "/login.xhtml";
		SeguridadBean seguridadBean = (SeguridadBean) ((HttpServletRequest) request).getSession()
				.getAttribute("seguridadBean");
		boolean autenticado = seguridadBean != null && seguridadBean.isAutenticado();
		if (autenticado) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(loginURL);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
