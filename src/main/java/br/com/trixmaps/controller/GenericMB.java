package br.com.trixmaps.controller;

import java.io.Serializable;

/**
 * @author Davi Mustafa
 * @email mustafadavi@gmail.com,
 * @date 22/11/2014
 */
public class GenericMB implements Serializable{

	private static final long serialVersionUID = 8145146605592749852L;
	
	protected final static String STATE_EDITAR = "EDITAR";
	protected final static String STATE_NOVO = "NOVO";
	protected final static String STATE_LISTAR = "LISTAR";
	protected String currentState;
	
	//Controle das paginas
	
	public void preparar(String state){
		this.currentState = state;
	}
	
	public boolean isStCadastrar() {
		return STATE_NOVO.equals(currentState);
	}
	
	public boolean isStEditar() {
		return STATE_EDITAR.equals(currentState);
	}

	public boolean isStListar() {
		return STATE_LISTAR.equals(currentState);
	}
	
	
	
}
