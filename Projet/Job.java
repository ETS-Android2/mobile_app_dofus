public class Job {
	
	private String name;
	private int level;
	
	public Job(String name, int level){
		this.name = name;
		this.level = level;
	}
	
	public Job(Job p){
		this.name = p.name;
		this.level = p.level;
	}
}