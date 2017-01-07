package metier.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.ejb3.annotation.SecurityDomain;

import metier.entities.Collaborateur;
import metier.entities.Frais;
import metier.entities.Note;
import metier.entities.Projet;

@SecurityDomain("ApplicationRealm")
@DeclareRoles({"Collaborateur","Directeur"})
@PermitAll
@Stateful
@Remote(NoteRemoteService.class)
public class NoteService implements NoteRemoteService {
	private Collaborateur c;
	@EJB
	private CalculetteService cs;
	@EJB
	private CreditsService credits;
	private List<Note> notes;	
	
	public NoteService(Collaborateur c){
		this.c=c;
		notes=new ArrayList<Note>();
		cs=new CalculetteService();
		credits=new CreditsService();
	}
	
	public NoteService(){
		cs=new CalculetteService();
		credits=new CreditsService();
		c=new Collaborateur();
		notes=new ArrayList<Note>();
	}
	
	public void setCollaborateur(String nom,String prenom){
		c=new Collaborateur(nom,prenom);
	}
	
	public Note createNote(long id,Calendar date,double total,Collaborateur c,Frais f){
		return new Note(id,date,total,c,f);
	}
	
	public Note createNote(long id,Calendar date,double total,Collaborateur c,List<Frais> f){
		return new Note(id,date,total,c,f);
	}
	
	public Frais createFrais(String designation,double montant,byte justificatif){
		return new Frais(designation,montant,justificatif);
	}
	
	public Frais createFrais(String designation,double montant,byte justificatif,Projet p){
		return new Frais(designation,montant,justificatif,p);
	}
	
	public Note saveNote(Note note){
		notes.add(note);
		return notes.get(notes.size()-1);
	}
	
	public Note findNote(long id){
		for(Note note:notes)
			if(note.getId()==id)
				return note;	
		return null;
	}
	
	public List<Note> findNotes(long id){
		List<Note> notes=new ArrayList<Note>();
		for(Note note:this.notes){
			if(note.getId()==id)
				notes.add(note);
		}
		return notes;
	}
	
	public void removeNote(Note note){
		notes.remove(note);
	}
	
	public String getVersion(){
		return credits.getProperties().getProperty("version");
	}

	@Override
	public String affichage() {
		// TODO Auto-generated method stub
		return "ca marche";
	}
	
	public double soustraction(double n1, double n2){
		return cs.soustraction(n1, n2);
	}
}

