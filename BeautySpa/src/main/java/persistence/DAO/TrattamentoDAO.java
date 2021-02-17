package persistence.DAO;

import java.util.ArrayList;

import model.Trattamento;

public interface TrattamentoDAO 
{
	public void save(Trattamento trattamento);
	public ArrayList<Trattamento> listaTrattamenti();
	public Trattamento trovaNomeTrattamento(Integer id);
}
