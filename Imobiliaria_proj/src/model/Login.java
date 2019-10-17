package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import persistence.Dao;

@Entity
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // Define que o atributo é um identificador único
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String usuario;
	private String senha;

	public Login() {
		super();
	}

	public Login(Integer id, String usuario, String senha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", usuario=" + usuario + ", senha=" + senha + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

//	public Login logar(String usuario, String senha) throws Exception {
//		if (usuario == null) {
//			System.out.println("Usuario invalido! :(");
//		} else if (senha == null) {
//			System.out.println("Senha invalida! :(");
//		} else if (usuario.length() < 3 & senha.length() < 3) {
//			System.out.println("Dados invalidos! :(");
//		}
//
////		Dao dao = new Dao();
////		dao = buscarLogin.stream().filter(a -> (a.getEmail().equals(login) && a.getSenha().equals(senha))).findAny()
////				.orElseThrow(() -> new Exception());
////		return resp;
//	}

}
