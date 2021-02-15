package persistence.DAO;

import java.util.ArrayList;

import model.Trattamento;

public interface TrattamentoDAO 
{
	public ArrayList<Trattamento> listaTrattamenti();
	public Trattamento trovaNomeTrattamento(String nomeTrattamento);
}
