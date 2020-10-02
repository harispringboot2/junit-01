package com.ashokit;

import java.util.List;

import com.ashokit.Exception.NoDataFoundException;
import com.ashokit.model.Contact;


public class ContactServiceImpl implements ContactService {

    private ContactDao contactDao;
	
	public void SetContactDao(ContactDao contactDao)
	{
		this.contactDao=contactDao;
				
	}
	public void SetContactDao1()
	{
		//work vnow
		
				
	}


	  public String getNameById(Integer id) {
	  
	  String name = contactDao.findNameById(id);
	  
	  String formattedName = name.toUpperCase();
	  
	 return formattedName;
	 }

	 
	  
	  public List<String> getAllContactNames() {
			
		List<String> names=  contactDao.findNames();
		
		   if(!names.isEmpty())
		   {
			   return names;
		   }
		  
			return null;
		}
	
	  public Contact getById(Integer id) throws NoDataFoundException
	  {
		  System.out.println("h1");
		  System.out.println("22222222");
		  System.out.println("3333333");
		  System.out.println("ok anna");
                  System.out.println("raju modified code");
		  
		 Contact contact =contactDao.findById(id);
		 
		 if(contact==null)
		 {
			 throw new NoDataFoundException("NoDataFoundException ok");
		 }
		 System.out.println("hello");
		return contact;
		  
	  }
}
