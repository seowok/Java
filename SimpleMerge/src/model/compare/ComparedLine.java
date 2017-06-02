package model.compare;

public class ComparedLine extends Line{
	
	public ComparedLine(String str){
		this.line = str;
	}
	
	/*
	 * Tag :
	 * { space : showing gray line }
	 * { equal : showing white line }
	 * { notequal : showing yellow line }
	 */
	public enum Tag{
		space, equal, notequal
	}
	
	public Tag tag;
	
}