package com.ashokit;
import java.util.List;
import com.ashokit.model.*;
public interface ContactService {

	public String       getNameById(Integer id);
	public List<String> getAllContactNames();
	public Contact getById(Integer id);
	
}
