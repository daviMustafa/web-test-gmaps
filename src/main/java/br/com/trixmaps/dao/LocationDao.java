package br.com.trixmaps.dao;

import java.util.List;

import br.com.trixmaps.model.Location;

public interface LocationDao {
	
	public void insert(Location location);
	
	public Location searchById(Integer id);
	
	public List<Location> listAll();
	
	public void remove(Location location);
	
	public void update(Location location);
}
