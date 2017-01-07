package metier.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@LocalBean
@Singleton
public class CreditsService implements CreditLocalService{
	private Properties properties;	
	
	public CreditsService(){
		this.properties=new Properties();
		try{
			FileInputStream is = new FileInputStream("/META-INF/credits.properties");
			this.properties.load(is);
			is.close();
		}
		catch(FileNotFoundException e){}
		catch(IOException e){}
	}
	
	public CreditsService(Properties properties){
		this.properties=properties;
	}
	
	public Properties getProperties(){
		return properties;
	}
	
	public String getVersion(){
		return this.properties.getProperty("version");
	}
}
