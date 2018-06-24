package com.sudhr.factory;

import com.sudhr.criteria.ICriteria;
import com.sudhr.criteria.SubCorridorCriteria;

public class CriteriaGenerator {
	
	public static ICriteria getCurrentCriteria (){
		
		ICriteria curr = new SubCorridorCriteria();
		return curr;
	}

}
