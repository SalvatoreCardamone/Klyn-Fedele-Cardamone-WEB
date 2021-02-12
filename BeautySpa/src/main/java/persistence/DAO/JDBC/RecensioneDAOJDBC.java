package persistence.DAO.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.Recensione;
import persistence.DBSource;
import persistence.DAO.RecensioneDAO;

public class RecensioneDAOJDBC implements RecensioneDAO
{
	
	DBSource dbSource;
	
	public RecensioneDAOJDBC(DBSource dbSource)
	{
		this.dbSource=dbSource;
	}
	 

	@Override
	public void save(Recensione recensione) 
	{
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			String query="INSERT INTO recensione values(?,?,?,?,?)";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setInt(1, recensione.getIdRecensione());
			st.setString(2,recensione.getDescrizione());
			st.setDate(3, recensione.getData());
			st.setString(4, recensione.getScrittoDa());
			st.setInt(5, recensione.getVoto());
			
			st.executeUpdate();
			System.out.println("Recensione e stata aggiunta");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Recensione> mieRecensioni(String emailUtente) {
		Connection conn;
		ArrayList<Recensione> lista= new ArrayList<Recensione>();
		try
		{
			conn= dbSource.getConnection();
			String query="SELECT * FROM recensione WHERE recensione.scrittoDa=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			
			st.setString(1, emailUtente);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				Integer idRecensione=rs.getInt("idRecensione");
				String descrizione=rs.getString("descrizione");
				Date date=rs.getDate("data");
				String scrittoDa=rs.getString("scrittoDa");
				Integer voto= rs.getInt("voto");
				
				Recensione passa= new Recensione(idRecensione, descrizione,date, scrittoDa, voto);
				lista.add(passa);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}


	@Override
	public void delete(Integer idRecensione, String scrittoDa) {
		Connection conn;
		try
		{
			conn=dbSource.getConnection();
			String query= "DELETE FROM recensione WHERE idRecensione=? and scrittoDa=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setInt(1, idRecensione);
			st.setString(2,scrittoDa);
			
			st.executeUpdate();
			System.out.println("Recensione eliminata");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
