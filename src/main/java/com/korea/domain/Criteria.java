package com.korea.domain;

import lombok.Data;

@Data
public class Criteria {
	
    private int start; //시작번호
    private int end; //끝 번호
	private String keyword;
	
    public Criteria(int start, int end) {
    	this.start = start;
    	this.end = end;
    }
    
    public Criteria() {
    	this(1, 10);
    }
}
