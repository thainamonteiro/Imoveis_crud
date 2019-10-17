package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Imoveis;
import persistence.Dao;

public class ListaImoveis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaImoveis() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Dao dao = new Dao();

		List<Imoveis> listaImoveis = new ArrayList<>();
		listaImoveis = dao.listaImoveis();
		request.setAttribute("imoveis", listaImoveis);
		
		getServletContext().getRequestDispatcher("/seguro/listarimoveis.jsp").forward(request, response);
	}

}


