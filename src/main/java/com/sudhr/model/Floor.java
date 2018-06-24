package com.sudhr.model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
	
	private final List<MainCorridor> mainCrdr = new ArrayList<MainCorridor>();
	private final List<SubCorridor> subCrdr = new ArrayList<SubCorridor>();
	public List<MainCorridor> getMainCrdr() {
		return mainCrdr;
	}
	
	public List<SubCorridor> getSubCrdr() {
		return subCrdr;
	}
	
	public int getPwr(){
		int pwr = 0 ;
		 for(MainCorridor mc  : this.getMainCrdr()){
			 pwr += mc.getPwr();
		 }
		 for(SubCorridor sc  : this.getSubCrdr()){
			 pwr += sc.getPwr();
		 }
		 return pwr;
	}
	
	
	

}
