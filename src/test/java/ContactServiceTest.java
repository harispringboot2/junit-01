import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ashokit.ContactDao;
import com.ashokit.ContactServiceImpl;
import com.ashokit.Exception.NoDataFoundException;
import com.ashokit.model.Contact;

public class ContactServiceTest {

	static ContactServiceImpl service = null;

	@BeforeClass
	public static void init() {
		ContactDao daoProxy = EasyMock.createMock(ContactDao.class);

		EasyMock.expect(daoProxy.findNameById(101)).andReturn("ashok");
		EasyMock.expect(daoProxy.findNameById(102)).andReturn("ashok it");
		
		               Contact c=new Contact();
		                  c.setContactId(101);
		                  c.setContactName("hari");
		                  c.setContactNumber(234654354);
		
		EasyMock.expect(daoProxy.findById(101)).andReturn(c);
		EasyMock.expect(daoProxy.findById(201)).andReturn(null);
		EasyMock.replay(daoProxy);
		List<String> names = new ArrayList<String>();
		names.add("rama");
		names.add("krishna");
		names.add("ramya");

		EasyMock.expect(daoProxy.findNames()).andReturn(names);

		service = new ContactServiceImpl();
		service.SetContactDao(daoProxy);
	}

	@Test
	@Ignore
	public void testgetNameById_01() {

		String name = service.getNameById(101);
      	assertNotNull(name);
	}

	@Test
	public void testgetAllNames_01() {

		List<String> names2 = service.getAllContactNames();
		System.out.println(names2);
		assertNotNull(names2);
	}
   @Test
   @Ignore
    public void testgetById()
    {
         Contact contact= service.getById(102);
         if(contact==null)
         {
        	 throw new NoDataFoundException("exception");
         }
         
         assertNotNull(contact);
    }
   @Test(expected = NoDataFoundException.class)
   @Ignore
   public void testgetContestById()
   {
	       service.getById(201);
	      
   }
}
