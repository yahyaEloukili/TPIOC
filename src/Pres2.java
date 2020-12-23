import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;


import Metier.IMetier;
import dao.DaoImpl;
import dao.IDao;

public class Pres2 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/*Injection des dependances par instantiation statique
		DaoImpl daoImpl = new DaoImpl();
		MetierImpl metierImpl = new MetierImpl();
		metierImpl.setDao(daoImpl);
		System.out.println(metierImpl.calcule());
		*/
		
		try {
			Scanner scanner = new Scanner(new File("config.txt"));
			String daoClassName = scanner.nextLine();
			Class cDao = Class.forName(daoClassName);
			IDao dao = (IDao) cDao.newInstance();
			System.out.println(dao.getData());
			
			String metierClassName = scanner.nextLine();
			Class cMetier = Class.forName(metierClassName);
			IMetier metier = (IMetier) cMetier.newInstance();	
			Method m = cMetier.getMethod("setDao", IDao.class);
			m.invoke(metier, dao);
		
			System.out.println(metier.calcule());
			
		} catch (FileNotFoundException | ClassNotFoundException  | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

}
