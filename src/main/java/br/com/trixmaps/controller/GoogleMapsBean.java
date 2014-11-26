package br.com.trixmaps.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.Circle;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;

import br.com.trixmaps.model.Location;

@ManagedBean
@ViewScoped
public class GoogleMapsBean {
	
	private final double DISTANCE_NM = 2800; //Distancias nauticas
	private final double DISTANCE_METERS = DISTANCE_NM * 1852; // Metros
	private String coordenadaCentral = "44, 28";
	
	private final MapModel mapModel;
	
	private List<Location> locations;
	
	public GoogleMapsBean(){
		
		mapModel = new DefaultMapModel();
		
		
		LatLng coordenada1 = new LatLng(44, 28);
		Circle circulo1 = new Circle(coordenada1, DISTANCE_METERS);
		circulo1.setStrokeColor("#FFFF66");
		circulo1.setFillColor("#FFFF66");
		circulo1.setFillOpacity(0.2);
		mapModel.addOverlay(circulo1);
		
	}

	
	
	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public MapModel getMapModel() {
		return mapModel;
	}

	public String getCoordenadaCentral() {
		return coordenadaCentral;
	}

	public void setCoordenadaCentral(String coordenadaCentral) {
		this.coordenadaCentral = coordenadaCentral;
	}
	
	
}
