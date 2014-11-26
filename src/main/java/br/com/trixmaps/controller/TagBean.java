package br.com.trixmaps.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.orm.jpa.JpaSystemException;

import br.com.trixmaps.dao.TagDao;
import br.com.trixmaps.model.Tag;
import br.com.trixmaps.utils.FacesUtils;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TagBean extends GenericMB implements Serializable {
	
	private Tag tag;
	private List<Tag> tags;
	
	@ManagedProperty("#{tagDao}")
	private TagDao tagDao;
	
	@PostConstruct
	public void init(){
		tag = new Tag();
		tags = new ArrayList<Tag>();
		prepararListar();
	}
	
	public void cadastrar(){
		try{
			tag.setCreated(new Date());
			tagDao.insert(tag);
			new FacesUtils().adicionaMensagemDeSucesso("Tag "+tag.getName()+" adicionada com sucesso");
		}catch (Exception e){
			new FacesUtils().adicionaMensagemDeErro("Falha cadastro da Tag");
		}
	}
	
	public void listar(){
		tags = tagDao.listAll();
	}
	
	public void excluir(Tag tag){
		try{
			tagDao.remove(tag);
			tags.remove(tag);
			prepararListar();
			new FacesUtils().adicionaMensagemDeSucesso("Tag "+tag.getName()+" removida com sucesso");
		}catch(JpaSystemException e){
			new FacesUtils().adicionaMensagemDeErro("Tag "+tag.getName()+" relacionada com uma location. Exclusão abortada.");
		}
			
	}
	
	public void prepararListar(){
		preparar(STATE_LISTAR);
		listar();
	}
	
	public void prepararEditar(Tag tag){
		preparar(STATE_EDITAR);
		this.tag = tag;
	}
	
	public void prepararCadastrar(){
		preparar(STATE_NOVO);
		tag = new Tag();
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}
	
}
