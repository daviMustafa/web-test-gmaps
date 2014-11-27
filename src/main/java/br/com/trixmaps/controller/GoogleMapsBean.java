package br.com.trixmaps.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.trixmaps.dao.LocationDao;
import br.com.trixmaps.model.Location;
import br.com.trixmaps.utils.FacesUtils;

@ManagedBean
@ViewScoped
public class GoogleMapsBean implements Serializable{
	
	private static final long serialVersionUID = -7131779288998064551L;

	private List<Location> locations;
	
	@ManagedProperty("#{locationDao}")
	private LocationDao locationDao;
	
	private Location location;
	
	private String latlng = "";
	
	@PostConstruct
	public void init(){
		locations = new ArrayList<Location>();
		location = new Location();
		listarLocations();
	}
	
	public void locationSelected(){
		if(location != null){
			latlng = location.getLatitude().toString()+","+location.getLongitude().toString();
			new FacesUtils().adicionaMensagemDeSucesso("Localização selecionada - Nome: " +location.getName()+ " / Latitude: "+location.getLatitude()+" / Longitude: "+location.getLongitude());
		} else {
			new FacesUtils().adicionaMensagemDeErro("Nenhuma localização selecionada");
		}
	}
	
	public void listarLocations(){
		locations = locationDao.listAll(); 
	}
	
	
	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLatlng() {
		return latlng;
	}

	public void setLatlng(String latlng) {
		this.latlng = latlng;
	}
	
}
