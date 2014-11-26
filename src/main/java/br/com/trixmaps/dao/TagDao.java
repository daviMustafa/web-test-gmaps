package br.com.trixmaps.dao;

import java.util.List;

import br.com.trixmaps.model.Tag;

public interface TagDao {
	
	public void insert(Tag tag);
	
	public Tag searchById(Integer id);
	
	public List<Tag> listAll();
	
	public void remove(Tag tag);
	
	public void update(Tag tag);
}
