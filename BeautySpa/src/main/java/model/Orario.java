package model;

import java.sql.Time;
import java.util.ArrayList;


public class Orario {
	
	public ArrayList<Time> orari;
	
	//Orari disponibili
	@SuppressWarnings("deprecation")
	public Orario() {
		
		orari = new ArrayList<Time>();
		
		for (int i=0; i<4; i++)
		{
			Time t = new Time(8+i, 0, 0);
			orari.add(t);
		}
		
		for (int i=0; i<4; i++)
		{
			Time t = new Time(15+i, 0, 0);
			orari.add(t);
		}
	}
	
	
}
