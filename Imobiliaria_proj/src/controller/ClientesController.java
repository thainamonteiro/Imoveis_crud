package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Clientes;
import model.Imoveis;
import persistence.Dao;
import service.SeguradoService;
import service.SeguradoServiceImpl;

public class ClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClientesController() {
		super();
	}

	SeguradoService seguradoService = new SeguradoServiceImpl();

	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Clientes> dao = new Dao<Clientes>();
		
		try {
			Clientes clientes = new Clientes();
			
			clientes.setNome(request.getParameter("nome"));
			clientes.setBairro(request.getParameter("bairro"));
			clientes.setCep(request.getParameter("cep"));
			clientes.setCidade(request.getParameter("cidade"));
			clientes.setCpf(request.getParameter("cpf"));
			clientes.setLogradouro(request.getParameter("logradouro"));
			clientes.setUf(request.getParameter("uf"));
			clientes.setRg(request.getParameter("rg"));
			clientes.setSexo(request.getParameter("sexo"));
			clientes.setTelefone(request.getParameter("telefone"));
			

			List<Imoveis> listaImoveis = new ArrayList<Imoveis>();

			for (String id : request.getParameterValues("imoveis")) {
				Imoveis imoveis = new Imoveis();
				imoveis.setId(Integer.valueOf(id));
				listaImoveis.add(imoveis);
			}
			clientes.setImoveis(listaImoveis);

			if (request.getParameter("id") == null) {

				seguradoService.salvar(clientes);
				listarClientes(request, dao);
				request.setAttribute("mensagem", "Cadastrado com sucesso! :)");

			} else {

				String id = request.getParameter("id");
				clientes.setId(Integer.parseInt(id));
				dao.alterar(clientes);
				listarClientes(request, dao);
			}
			getServletContext().getRequestDispatcher("/seguro/listarclientes.jsp").forward(request, response);

		} catch (Exception e) {
//			e.printStackTrace();
			request.setAttribute("mensagem", "Não foi cadastrado! :" + e.getMessage());
			getServletContext().getRequestDispatcher("/seguro/cadastrarclientes.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Clientes> dao = new Dao<Clientes>();
		String acao = request.getParameter("acao");

		if (acao != null && "listarclientes".equalsIgnoreCase(acao)) {

			listarClientes(request, dao);

			getServletContext().getRequestDispatcher("/seguro/listarclientes.jsp").forward(request, response);

		} else if (acao != null && "abririmoveis".equalsIgnoreCase(acao)) {

			List<Imoveis> listaImoveis = new ArrayList<>();
			listaImoveis = dao.listaImoveis();
			request.setAttribute("imoveis", listaImoveis);

			getServletContext().getRequestDispatcher("/seguro/cadastrarclientes.jsp").forward(request, response);

		} else if (acao != null && "excluirclientes".equalsIgnoreCase(acao)) {

			String id = request.getParameter("id");
			dao.remove(Clientes.class, Integer.parseInt(id));
			listarClientes(request, dao);

			getServletContext().getRequestDispatcher("/seguro/listarclientes.jsp").forward(request, response);

		} else if (acao != null && "alterarclientes".equalsIgnoreCase(acao)) {

			String id = request.getParameter("id");
			Clientes clientes = (Clientes) dao.findById(Clientes.class, Integer.parseInt(id));
			request.setAttribute("clientes", clientes);

			List<Imoveis> listaImoveis = new ArrayList<>();
			listaImoveis = dao.listaImoveis();
			request.setAttribute("clientes", listaImoveis);

			getServletContext().getRequestDispatcher("/seguro/upd.jsp").forward(request, response);
		}
	}

	public void listarClientes(HttpServletRequest request, Dao<Clientes> dao) {
		List<Clientes> listaClientes= new ArrayList<>();
		listaClientes = dao.listaClientes();
		request.setAttribute("segurados", listaClientes);
	}
}