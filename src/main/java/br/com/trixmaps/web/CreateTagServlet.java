package br.com.trixmaps.web;

import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ManagedProperty;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.trixmaps.dao.TagDao;
import br.com.trixmaps.model.Tag;

@WebServlet("/createTag")
public class CreateTagServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5113683997643827673L;
	
	@ManagedProperty("#{tagDao}")
	private TagDao dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String name = request.getParameter("name");
		
//		Montando uma Tag
		Tag tag = new Tag();
		
		tag.setName(name);
		tag.setCreated(new Date());
		
//		Inserir no banco
		dao.insert(tag);
		
		request.setAttribute("msgSucesso", "Cadastro realizado com sucesso.");
	}
}
