package metier.services;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.EJBAccessException;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.jboss.ejb3.annotation.SecurityDomain;

@SecurityDomain("ecole")
@DeclareRoles({"CE1","CM1"})
@PermitAll
@LocalBean
@Stateless
public class CalculetteService implements CalculetteLocalService{	
@Resource
private SessionContext context;

	public CalculetteService(){}
	
	public double addition(double nb1,double nb2){
		try{
			if(context.isCallerInRole("CE1"))
				return nb1+nb2;
		}catch(EJBAccessException e){
			String texte = "Vous n'êtes pas autorisé à accéder à la ressource !";
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,texte,texte);
			FacesContext.getCurrentInstance().addMessage("resultat", msg);
		}
		return 0;
	}
	
	public double soustraction(double nb1,double nb2){
		try{
			if(context.isCallerInRole("CE1"))
				return nb1-nb2;
		}catch(EJBAccessException e){
			String texte = "Vous n'êtes pas autorisé à accéder à la ressource !";
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,texte,texte);
			FacesContext.getCurrentInstance().addMessage("resultat", msg);
		}
		return 0;
	}
	
	public double multiplication(double nb1,double nb2){
		try{
			if(context.isCallerInRole("CM1"))			
				return nb1*nb2;
		}catch(EJBAccessException e){
			String texte = "Vous n'êtes pas autorisé à accéder à la ressource !";
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,texte,texte);
			FacesContext.getCurrentInstance().addMessage("resultat", msg);
		}
		return 0;
	}
	
	public double division(double nb1,double nb2){
		double div=0;
		try{
			if(context.isCallerInRole("CM1")){				
				try{
					div=nb1/nb2;			
				}
				catch(Exception e){
					System.out.println("Erreur de division : "+e);
				}
			}
		}catch(EJBAccessException e){
			String texte = "Vous n'êtes pas autorisé à accéder à la ressource !";
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,texte,texte);
			FacesContext.getCurrentInstance().addMessage("resultat", msg);
		}
				return div;
	}
}
