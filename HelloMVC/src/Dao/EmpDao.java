package Dao;
import Exception.AvailabilityEx;
import Exception.MyException;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Employee;
import model.Location;

public class EmpDao {
	JdbcTemplate template;
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public int save(Employee emp)
	{
		System.out.println("In Dao");
		return 2;
		//return template.update("insert into details values('"+emp.getName()+"','"+emp.getLocation()+"')");
	}
	public String getAvailability(String transferlocation)
	{
		String status="";
		String query="select location from location where location=?";
		String location=template.queryForObject(query, new Object[]{transferlocation},String.class);
		if(location!=null)
		{
			System.out.println("Y");
			status="Y";
		}
		else
		{
			status="N";
			System.out.println("N");
			try {
				throw new MyException("Invalid location");
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return status;
	}
	public void updateEmployeeLocation()
	{
		
	}
}
