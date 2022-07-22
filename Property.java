
public class Property {
	private String owner;
	private String city;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	public Property(String propertyName,String city,double rentAmount,String owner){
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		this.city=city;
		this.owner=owner;
		this.plot=new Plot();
	}
	public Property(String propertyName,String city,double rentAmount,String owner,int x,int y,int width,int depth){
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		this.city=city;
		this.owner=owner;
		this.plot=new Plot(x,y,width,depth);
	}
	Property(Property p){
		city=p.city;
		owner=p.owner;
		propertyName=p.propertyName;
		rentAmount=p.rentAmount;
		plot=new Plot (p.plot);
	}
	public Property(){
		rentAmount=0;
		propertyName="";
		city="";
		owner="";
		plot=new Plot();
		
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner=owner;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName=propertyName;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount=rentAmount;
	}
	public Plot getPlot() {
		return plot;
	}
	public Plot setPlot(int x,int y, int width, int depth) {
		Plot nPlot=new Plot(x,y,width,depth);
		return nPlot;
	}
	public String toString() {
		String out="";
		out="Property Name: "+propertyName+"\nLocated in "+city+"\nBelonging to: "+owner+"\nRent Amount: "+rentAmount+" ";
		return out;
	}
	
	
}
