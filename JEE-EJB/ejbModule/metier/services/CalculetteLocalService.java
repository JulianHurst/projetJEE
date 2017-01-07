package metier.services;

import javax.ejb.Local;

@Local
public interface CalculetteLocalService {
	public double addition(double nb1,double nb2);
	public double soustraction(double nb1,double nb2);
	public double multiplication(double nb1,double nb2);
	public double division(double nb1,double nb2);
}
