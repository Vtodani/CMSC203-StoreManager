
public class ManagementCompany {
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	public int MAX_PROPERTY=5;
	private String taxID;
	private int MGMT_WIDTH=10;
	private int MGMT_DEPTH=10;
	private Plot plot;
	ManagementCompany(String name, String taxID, double mgmFee){
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		properties=new Property[MAX_PROPERTY];
		plot=new Plot(0,0,10,10);
	
	}
	ManagementCompany(){
		this.name="";
		this.taxID="";
		this.mgmFeePer=0;
		properties=new Property[MAX_PROPERTY];
		plot=new Plot(0,0,10,10);
	
	}
	
	ManagementCompany(String name, String taxID, double mgmFee,int x, int y, int width, int depth){
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		properties=new Property[MAX_PROPERTY];
		plot=new Plot(x,y,width,depth);
	
	}
	ManagementCompany(ManagementCompany otherCompany){
		name=otherCompany.name;
		taxID=otherCompany.taxID;
		mgmFeePer=otherCompany.mgmFeePer;
		properties=otherCompany.properties;
		plot=otherCompany.plot;
		
	}
	public int addProperty(Property property) {
		if(property==null) {
			return-2;
		}
		if(plot.encompasses(property.getPlot())==false) {
			return-3;
		}
		for(int i=0;i<properties.length;i++) {
			if(properties[i]==null){
				properties[i]=property;
				return i;
				}
			else {
			if(properties[i].getPlot().overlaps(property.getPlot())) {
				return-4;
			  }
			}
		}
		//if last index of array is not empty, the array is full
		if(properties[MAX_PROPERTY-1]!=null) {
			return -1;
		}
		return 0;	
	}
	public int addProperty(String name, String city, double rent,String owner) {
		int test;
		test=addProperty(new Property(name,city,rent,owner));
		return test;
		
	}
	public int addProperty(String name, String city, double rent, String owner ,int x, int y, int width, int depth) {
		int test;
		test=addProperty(new Property(name,city,rent,owner,x,y,width,depth));
		return test;
		
	}
	
	public String getName() {
		return name;
	}
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	public Plot getPlot() {
		return plot;
	}

	public double totalRent() {
		double tot=0;   
			for(int i=0;i<properties.length;i++) {
				//only increment total if properties is not null
				if(properties[i]!=null) {
				tot=tot+properties[i].getRentAmount();
				}
			}
		return tot;
	}
	
	private int maxRentPropertyIndex() {
		int maxI=0;
		double max=0;
		for(int i=0;i<properties.length;i++) {
			//only increment total if properties is not null
			if(properties[i]!=null) {
		    //if rent amount in index i of properties is greater than max, it becomes new max
			//as well as maxI taking the index 
			if(properties[i].getRentAmount()>max) {
				maxI=i;
				max=properties[i].getRentAmount();
			}
		}}
		return maxI;	
	}
	public double maxRentProp() {
		double max;
		max=properties[maxRentPropertyIndex()].getRentAmount();
		return max;
		
	}
	public String DisplayPropertyAtIndex(int index) {
		String out="";
		out=properties[index].toString();
		return out;
	}
	@Override
	public String toString() {
		String out="";
		//holds details of properties
		String propOut="";
		//Final return string
		String FinalString="";
		out="List of properties for "+name+", taxID: "+taxID+"\n____________________\n";
		for(int i=0;i<properties.length;i++) {
			//only attempt to increment property output if the property is not empty
			if(properties[i]!=null) {
			propOut=propOut+properties[i].toString();
			}
		}
		FinalString=out+propOut
				+"\n____________________\n"
				+"total fee: "+((mgmFeePer/100)*totalRent());
		return FinalString;
	}
	
}
