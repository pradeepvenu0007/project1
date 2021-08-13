package db;

import entity.formEntity;
import model.reimbursementform;

public class formMapper {
	public static formEntity map(reimbursementform f)
	{
		formEntity form=new formEntity();
		form.setAmount(f.getAmount());
		form.setDescription(f.getDescription());
		form.setEmployee(f.getEmployee());
		form.setType(f.getType());
		return form;
		
	}

}
