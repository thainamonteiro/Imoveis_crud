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

public class ImoveisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImoveisController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao<Imoveis> dao = new Dao<Imoveis>();

		try {
			Imoveis imoveis = new Imoveis();

			imoveis.setNome(request.getParameter("nome"));
			imoveis.setCep(request.getParameter("cpf"));
			imoveis.setCidade(request.getParameter("cidade"));
			imoveis.setRua(request.getParameter("rua"));
			imoveis.setUf(request.getParameter("uf"));
			imoveis.setComodos(request.getParameter("comodos"));
			imoveis.setPreço(Double.parseDouble(request.getParameter("preco")));


			if (request.getParameter("id") == null) {
				dao.create(imoveis);
				listarImoveis(request, dao);
				request.setAttribute("mensagem", "Cadastrado com sucesso! :)");
				
			} else {
				String id = request.getParameter("id");
				imoveis.setId(Integer.parseInt(id));
				dao.alterar(imoveis);
				listarImoveis(request, dao);
			}
			
			getServletContext().getRequestDispatcher("/seguro/listarimoveis.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensagem", "Não foi cadastrado! :" + e.getMessage());
			getServletContext().getRequestDispatcher("/seguro/cadastrarimoveis.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Imoveis> dao = new Dao<Imoveis>();
		String acao = request.getParameter("acao");

		if (acao != null && "cadastrarimoveis".equalsIgnoreCase(acao)) {
			
			listarImoveis(request, dao);
			getServletContext().getRequestDispatcher("/seguro/cadastrarimoveis.jsp").forward(request, response);

		} else if (acao != null && "listarimoveis".equalsIgnoreCase(acao)) {

			listarImoveis(request, dao);
			getServletContext().getRequestDispatcher("/seguro/listarseguro.jsp").forward(request, response);

		} else if (acao != null && "excluirimoveis".equalsIgnoreCase(acao)) {

			String id = request.getParameter("id");
			dao.remove(Imoveis.class, Integer.parseInt(id));
			listarImoveis(request, dao);
			getServletContext().getRequestDispatcher("/seguro/listarimoveis.jsp").forward(request, response);

		} else if (acao != null && "alterarimoveis".equalsIgnoreCase(acao)) {

			String id = request.getParameter("id");
			Imoveis imoveis = (Imoveis) dao.findById(Imoveis.class, Integer.parseInt(id));
			request.setAttribute("imoveis", imoveis);
			getServletContext().getRequestDispatcher("/seguro/updimoveis.jsp").forward(request, response);

		}
	}
	
	public void listarImoveis(HttpServletRequest request, Dao<Imoveis> dao) {
		List<Imoveis> listaImoveis = new ArrayList<>();
		listaImoveis = dao.listaImoveis();
		request.setAttribute("imoveis", listaImoveis);
	}

}
