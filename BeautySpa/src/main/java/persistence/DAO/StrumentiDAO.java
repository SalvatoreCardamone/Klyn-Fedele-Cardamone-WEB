package persistence.DAO;

import model.Utente;

public interface StrumentiDAO 
{
	public Utente login(String email, String password);
}
