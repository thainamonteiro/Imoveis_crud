package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Clientes;
import persistence.Dao;

public class ListaClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaClientes() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Dao dao = new Dao();

		List<Clientes> listaClientes = new ArrayList<>();
		listaClientes = dao.listaClientes();
		request.setAttribute("clientes", listaClientes);

		getServletContext().getRequestDispatcher("/seguro/listarclientes.jsp").forward(request,response);
	}

}
