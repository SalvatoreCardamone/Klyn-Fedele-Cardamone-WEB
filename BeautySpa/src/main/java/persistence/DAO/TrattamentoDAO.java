package persistence.DAO;

import java.sql.Date;
import java.util.ArrayList;

import model.Trattamento;

public interface TrattamentoDAO 
{
	public void save(Trattamento trattamento);
	public ArrayList<Trattamento> listaTrattamenti();
	public Trattamento trovaTrattamento(Integer id);
	public void updateTrattamento(Trattamento trattamento);
	public void delete(Integer idTrattamento);
}
