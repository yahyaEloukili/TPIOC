package ext;

import dao.IDao;

public class DaoImpl2 implements IDao {

	@Override
	public double getData() {
		/*
		 * version ws
		 * 
		 */
		System.out.println("versio ws");
		double data = 12;
		return data;
	}


	
}
