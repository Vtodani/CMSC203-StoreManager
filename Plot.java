
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot(){
		x=0;
		y=0;
		width=0;
		depth=0;
	}
	public Plot(int x,int y,int width,int depth){
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}
	Plot(Plot p){
		x=p.x;
		y=p.y;
		width=p.width;
		depth=p.depth;
	}
	
	public boolean overlaps(Plot plot) {
		
	
		if(x+width>plot.getX()) {
			if(x<plot.getX()+plot.getWidth()){
				if((y<(plot.getY()+plot.getDepth()))) {
					if((y+depth)>plot.getY()) {
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	public boolean encompasses(Plot plot) {
		int count=0;
		//***
		int pDepth=plot.getDepth();
		int pWidth=plot.getWidth();
		int pX=plot.getX();
		int pY=plot.getY();
	
		if((x<=pX) && (pX<=(x+width))) {
			if((y<=pY) && (pY<=(y+depth))) {
				if((x<=pX+pWidth) && ((pX+pWidth)<=(pX+width))) {
					if((y<=pY+pDepth) && ((pY+pDepth)<=(pY+pDepth))) {
						return true;
					}
				}
				
			}
		
		}
		return false;}
		
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String toString() {
		String out="";
		out="Upper left: ("+x+","+y+"); Width: "+width+" Depth: "+depth;
		return out;
	}
	
}
