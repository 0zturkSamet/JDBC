package TechProEd.JdbcExamples;

public class Urun {
	//POJO class Plain old java object= Encupsulation 
	private int id;
	private String isimString;
	private double fiyat;
	public Urun(int id, String isimString, double fiyat) {
		
		this.id = id;
		this.isimString = isimString;
		this.fiyat = fiyat;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsimString() {
		return isimString;
	}
	public void setIsimString(String isimString) {
		this.isimString = isimString;
	}
	public double getFiyat() {
		return fiyat;
	}
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}



	@Override
	public String toString() {
		return "Urun [id=" + id + ", isimString=" + isimString + ", fiyat=" + fiyat + "]";
	}
	
	
	

}
