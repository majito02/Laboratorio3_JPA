package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.ClienteDAOImpl;
import com.web.model.Cliente;
@ManagedBean (name = "clienteBean")
@RequestScoped
public class ClienteBean {
	
	ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
		List <Cliente> listaClientes = new ArrayList<>();
		
		public List <Cliente> getListaClientes(){
			return clienteDAO.obtenerClientes();
		}
		public void setListaClientes(List<Cliente>listaClientes) {
		this.listaClientes = listaClientes;
		}
		
		public String editar (int id) {
			Cliente oCliente = new Cliente();
			oCliente = clienteDAO.buscar(id);
			System.out.println(oCliente);
			//crear una coleccion de tipo mapa  de javautil
			Map<String,Object>sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			//pasar los datos del cliente
			sessionMap.put("cliente",oCliente);
			return "/faces/editar.xhtml";
		}
		public String actualizar(Cliente cliente) {
			clienteDAO.editar(cliente);
			return "/faces/index.xhtml";
		}
		
		
		public String eliminar(int id) {
			clienteDAO.eliminar(id);
			return "/faces/index.xhtml";
		}
		
		public String nuevo() {
			Cliente oCliente = new Cliente();
			//crear una coleccion de tipo mapa
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
					
			//pasar los datos del cliente
			sessionMap.put("cliente", oCliente);
			return "/faces/crear.xhtml";
		}
		
		public String guardar(Cliente cliente) {
			clienteDAO.guardar(cliente);
			return "/faces/index.xhtml";
		}
		
		/*
		public List <Cliente>obtenerClientes(){
		
		Cliente c1 = new Cliente();
		c1.setIdusuario(1);
		c1.setNombreusuario("Maria Jose");
		c1.setApellidousuario("Parraga");
		c1.setCedulausuario("2300323272");
		c1.setDireccionusuario("Valencia");
		c1.setTelefonousuario("0960089365");
		c1.setCorreousuario("mjparraga2@espe.edu.ec");
		
		Cliente c2 = new Cliente();
		c2.setIdusuario(2);
		c2.setNombreusuario("Elian");
		c2.setApellidousuario("Gualpa");
		c2.setCedulausuario("1710391713");
		c2.setDireccionusuario("Puerto Limon");
		c2.setTelefonousuario("0984847521");
		c2.setCorreousuario("elgualpa@espe.edu.ec");
		
		Cliente c3 = new Cliente();
		c3.setIdusuario(3);
		c3.setNombreusuario("Camila");
		c3.setApellidousuario("Parraga");
		c3.setCedulausuario("2300000789");
		c3.setDireccionusuario("San Miguel");
		c3.setTelefonousuario("0984847522");
		c3.setCorreousuario("camilipa@espe.edu.ec");
		
		listaClientes.add(c1);
		listaClientes.add(c2);
		listaClientes.add(c3);
		
		return listaClientes;
	}*/

}
