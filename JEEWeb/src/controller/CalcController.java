package controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


import metier.services.CalculetteLocalService;

@ManagedBean(name="calculette")
@SessionScoped
public class CalcController {
	
	@EJB
	private CalculetteLocalService ejb;
	
	private Double nb1;
	private Double nb2;
	private Double res;
	
	public String additionner(){
		this.res=this.ejb.addition(this.nb1,this.nb2);
		return "";
	}
	
	public String soustraire(){
		this.res=this.ejb.soustraction(this.nb1,this.nb2);
		return "calculette.success";
	}
	
	public String multiplier(){
		this.res=this.ejb.multiplication(this.nb1,this.nb2);
		return "calculette.success";
	}
	
	public String diviser(){
		this.res=this.ejb.division(this.nb1,this.nb2);
		return "calculette.success";
	}

	public CalculetteLocalService getEjb() {
		return ejb;
	}

	public void setEjb(CalculetteLocalService ejb) {
		this.ejb = ejb;
	}

	public Double getNb1() {
		return nb1;
	}

	public void setNb1(Double nb1) {
		this.nb1 = nb1;
	}

	public Double getNb2() {
		return nb2;
	}

	public void setNb2(Double nb2) {
		this.nb2 = nb2;
	}

	public Double getRes() {
		return res;
	}

	public void setRes(Double res) {
		this.res = res;
	}

}
