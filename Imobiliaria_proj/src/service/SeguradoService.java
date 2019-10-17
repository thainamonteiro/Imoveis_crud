package service;

import model.Clientes;

public interface SeguradoService {
	
	public void salvar(Clientes segurado) throws Exception;
	
	public Clientes buscarPorCpf(Clientes segurado);

}
