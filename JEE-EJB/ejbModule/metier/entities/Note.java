package metier.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Note {	
	private long id;
	private double total;
	private Calendar date;
	private Collaborateur c;
	private List<Frais> f=new ArrayList<Frais>();
	
	public Note(long id,Calendar date,double total,Collaborateur c,Frais f){
		this.id=id;
		this.date=date;
		this.total=total;
		this.c=c;
		this.f.add(f);
	}
	
	public Note(long id,Calendar date,double total,Collaborateur c,List<Frais> f){
		this.id=id;
		this.date=date;
		this.total=total;
		this.c=c;
		this.f.addAll(f);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
}
