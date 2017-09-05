package br.keep;
import java.util.List;

public class Notes {
	private int id;
	private String content;
	private int color;
	private List<Integer> tags;
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public void setTags(List<Integer> tags) {
		this.tags = tags;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public int getColor() {
		return this.color;
	}
	
	public List<Integer> getTags() {
		return this.tags;
	}
	
	
}
