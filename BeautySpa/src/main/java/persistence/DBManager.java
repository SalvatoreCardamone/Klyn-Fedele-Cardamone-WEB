package persistence;

import persistence.DAO.UtenteDAO;
import persistence.DAO.RecensioneDAO;
import persistence.DAO.TrattamentoDAO;
import persistence.DAO.PrenotazioneDAO;
import persistence.DAO.JDBC.PrenotazioneDAOJDBC;
import persistence.DAO.JDBC.RecensioneDAOJDBC;
import persistence.DAO.JDBC.TrattamentoDAOJDBC;
import persistence.DAO.JDBC.UtenteDAOJDBC;

public class DBManager 
{
	private static DBManager instance;
	static DBSource dataSource;
	
	static {
		try {
		Class.forName("org.postgresql.Driver");
		//questi vanno messi in file di configurazione!!!
																 //Nome DB		ok		password
		dataSource=new DBSource("jdbc:postgresql://localhost:5432/BeautySpaDB","postgres","admin");
		}
		catch (Exception e) {
		//System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
		//e.printStackTrace();
			System.out.println("Si e verificato un errore di connesione al database");
		}
	}
	
	public static DBManager getInstance()
	{
		if(instance==null)
			instance= new DBManager();
		return instance;
	}
	
	private DBManager()
	{
		
	}
	
	public static DBSource getDataSource()
	{
		return dataSource;
	}
	
	public void verificaConnesione()
	{
		System.out.println("conesso");
	}
	
	public UtenteDAO UtenteDAO()
	{
		return new UtenteDAOJDBC(dataSource);
	}
	
	public PrenotazioneDAO PrenotazioneDAO()
	{
		return new PrenotazioneDAOJDBC(dataSource);
	}
	
	public TrattamentoDAO TrattamentoDAO()
	{
		return new TrattamentoDAOJDBC(dataSource);
	}
	public RecensioneDAO RecensioneDAO()
	{
		return new RecensioneDAOJDBC(dataSource);
	}
}