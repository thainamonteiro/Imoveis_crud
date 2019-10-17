package service;

import model.Clientes;
import persistence.Dao;

public class SeguradoServiceImpl implements SeguradoService{

	Dao dao = new Dao();
	
	@Override
	public void salvar(Clientes clientes) throws Exception {
		
		Clientes clientesObject = this.buscarPorCpf(clientes);
		
		if (clientesObject == null) {
			dao.create(clientes);
		}else {
			throw new Exception("Usuario já existe");
		}

		
	}

	@Override
	public Clientes buscarPorCpf(Clientes clientes) {

		Clientes clientesObject =	dao.buscarClientesPorCpf(clientes.getCpf());

		return clientesObject;
	}

}
