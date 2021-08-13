package db;
import entity.employeeEntity;
import model.Employee;
public class EmployeeMapper {
	
	public static employeeEntity mapEmployee(Employee e) {
		employeeEntity entity=new employeeEntity();
		
		
		
		entity.setName(e.getName());
		entity.setEmail(e.getEmail());
		entity.setPassword(e.getPassword());
		entity.setType(e.getType());
		entity.setAddress(e.getAddress());
		entity.setDepartment(e.getDepartment());
		entity.setDesignation(e.getDesignation());
		entity.setMobile(e.getMobile());
		return entity;
		
	}

}
