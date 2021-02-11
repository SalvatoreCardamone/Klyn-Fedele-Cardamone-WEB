package persistence.DAO.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import model.Utente;
import persistence.DBSource;
import persistence.DAO.UtenteDAO;

public class UtenteDAOJDBC implements UtenteDAO
{
	
	DBSource dbSource;
	
	public UtenteDAOJDBC(DBSource dbSource)
	{
		this.dbSource=dbSource;
	}

	@Override
	public void save(Utente utente) {
		Connection conn;
		try
		{
		conn= dbSource.getConnection();
		String quetyUpdate= "INSERT INTO utente values(?,?,?,?,?,?)";
		PreparedStatement st= conn.prepareStatement(quetyUpdate);
		
		st.setString(1, utente.getEmail());
		st.setString(2, utente.getPassword());
		st.setString(3, utente.getNome());
		st.setString(4, utente.getCognome());
		st.setBoolean(5, utente.isConvalidato());
		st.setString(6, utente.getNumero());
		
		st.executeUpdate();
		System.out.println("Utente e stato aggiunto con sucesso");
		}
		catch(Exception e)
		{
			System.out.println("Non riesco a fare la query di save");
		}
	}

	@Override
	public Utente findByPrimaryKey(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utente studente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utente studente) {
		// TODO Auto-generated method stub
		
	}

}
