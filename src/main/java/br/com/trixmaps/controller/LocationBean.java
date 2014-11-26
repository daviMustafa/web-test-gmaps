package br.com.trixmaps.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import br.com.trixmaps.dao.LocationDao;
import br.com.trixmaps.dao.TagDao;
import br.com.trixmaps.model.Location;
import br.com.trixmaps.model.Tag;
import br.com.trixmaps.utils.FacesUtils;

@ManagedBean
@ViewScoped
public class LocationBean extends GenericMB implements Serializable{
	
	private static final long serialVersionUID = 6697328603022991729L;
	
	private Location location;
	private List<Location> locations;
	private List<Tag> tags;
	
	private DualListModel<Tag> listModelTags;
	
	@ManagedProperty("#{locationDao}")
	private LocationDao locationDao;
	
	@ManagedProperty("#{tagDao}")
	private TagDao tagDao;
	
	@PostConstruct
	public void init(){
		location = new Location();
		locations = new ArrayList<Location>();
		tags = new ArrayList<Tag>();
		prepararListar();
	}
	
	public void cadastra(){
		try{
			location.setCreated(new Date());
			location.setTags(listModelTags.getTarget());
			locationDao.insert(location);
			new FacesUtils().adicionaMensagemDeSucesso("Location "+location.getName()+" adicionada com sucesso");
		}catch(Exception e){
			new FacesUtils().adicionaMensagemDeErro("Falha cadastro da Location");
		}
	}
	
	public void excluir(Location location){
		try{
			locationDao.remove(location);
			locations.remove(location);
			prepararListar();
		} catch (Exception e){
			new FacesUtils().adicionaMensagemDeErro("Falha ao excluir uma Location");
		}
	}
	
	public void listar(){
		locations = locationDao.listAll();
	}
	
	public void carregarTags(){
		try{
			tags = tagDao.listAll();
		} catch (Exception e){
			new FacesUtils().adicionaMensagemDeErro("Falha ao carregar as Tag");
		}
	}
	
	public void prepararListar(){
		preparar (STATE_LISTAR);
		listar();
	}
	
	public void prepararEditar(Location location){
		preparar(STATE_EDITAR);
		this.location = location;
	}
	
	public void prepararCadastrar(){
		preparar(STATE_NOVO);
		location = new Location();
		carregarTags();
		List<Tag> tagsTarget = new ArrayList<Tag>();
		
		listModelTags = new DualListModel<Tag>(tags, tagsTarget);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	public DualListModel<Tag> getListModelTags() {
		return listModelTags;
	}

	public void setListModelTags(DualListModel<Tag> listModelTags) {
		this.listModelTags = listModelTags;
	}
	
}
