public class Job {

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////				Attributes		                 ////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	
	private JobEnum name;
	private int level;

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////					Constructors                  ///////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Job(JobEnum name, int level){
		this.name = name;
		this.level = level;
	}
	
	public Job(Job p){
		this.name = p.name;
		this.level = p.level;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////					Getters and Setters                  ////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public JobEnum getName() {
		return name;
	}
	
	public void setName(JobEnum name) {
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
}