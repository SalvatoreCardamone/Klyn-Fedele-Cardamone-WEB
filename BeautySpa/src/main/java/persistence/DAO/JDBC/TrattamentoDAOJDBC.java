package persistence.DAO.JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

import model.Trattamento;
import persistence.DBSource;
import persistence.DAO.TrattamentoDAO;

public class TrattamentoDAOJDBC implements TrattamentoDAO{

	DBSource dbSource;
	
	public TrattamentoDAOJDBC(DBSource dbSource)
	{
		this.dbSource=dbSource;
	}
	
	@Override
	public ArrayList<Trattamento> listaTrattamenti() {
		Connection conn;
		ArrayList<Trattamento> lista= new ArrayList<Trattamento>();
		try {
		    conn= dbSource.getConnection();
		    String query = "SELECT * FROM trattamento";
		    PreparedStatement st= conn.prepareStatement(query);
		    ResultSet rs = st.executeQuery();
		      while (rs.next()) {
		    	Integer id=rs.getInt("id");
		        String nome = rs.getString("nome");
		        String descrizione= rs.getString("descrizione");
		        
		        Trattamento passa= new Trattamento(id,nome,descrizione);
		        lista.add(passa);
		      }
		    } 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Trattamento trovaTrattamento(Integer id) {
		Connection conn;
		Trattamento trattamento= new Trattamento();
		try
		{
			conn= dbSource.getConnection();
			String query= "SELECT * FROM trattamento WHERE id=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setInt(1, id);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				Integer idP= rs.getInt("id");
				String nome=rs.getString("nome");
				
				String desc= rs.getString("descrizione");
				
				trattamento.setId(idP);
				trattamento.setNome(nome);
				trattamento.setDescrizione(desc);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return trattamento;
	}

	@Override
	public void save(Trattamento trattamento) 
	{
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			String query="INSERT INTO trattamento(nome , descrizione) values(?,?)";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setString(1, trattamento.getNome());
			//st.setString(2,trattamento.getImage());
			//Volendo qui si puo occuopare del tempo facendo
			/*
			 	Calendar calendar = Calendar.getInstance();
				Date date = new Date(calendar.getTime().getTime());
			 	st.setTime(3, date);
			 */
			//st.setTime(3, trattamento.getTempo());
			//Volendo si puo caricare il tempo direttamente qui facendo
			/*
			 	LocalTime localTime = LocalTime.now();
			 	Time time = Time.valueOf(localTime)
			 	st.setDate(4, time);
			 */
			//st.setDate(4, trattamento.getGiorno());
			//st.setBoolean(3, trattamento.isDisponobile());
			st.setString(2, trattamento.getDescrizione());
			
			st.executeUpdate();
			System.out.println("Recensione e stata aggiunta");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
