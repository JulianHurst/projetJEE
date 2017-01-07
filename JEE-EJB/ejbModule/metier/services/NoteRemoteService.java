package metier.services;

import javax.ejb.Remote;

@Remote
public interface NoteRemoteService {
	public String affichage();
	public double soustraction(double n1, double n2);
}
