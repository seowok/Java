package controller.compare;

public abstract class Line {
	String line;
}

class NotComparedLine extends Line{
	
	NotComparedLine(String str){
		this.line = str;
	}
	
}

class ComparedLine extends Line{
	
	ComparedLine(String str){
		this.line = str;
	}
	
	/*
	 * Tag :
	 * { space : showing gray line }
	 * { equal : showing white line }
	 * { notequal : showing yellow line }
	 */
	enum Tag{
		space, equal, notequal
	}
	
	Tag tag;
	
}
