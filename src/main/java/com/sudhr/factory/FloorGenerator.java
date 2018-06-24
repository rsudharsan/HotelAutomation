package com.sudhr.factory;

import com.sudhr.model.Floor;
import com.sudhr.model.MainCorridor;
import com.sudhr.model.SubCorridor;

public class FloorGenerator {

	public static Floor getNewFloor(int noOfMc, int noOfSc) {

		Floor currFloor = new Floor();
		initCorrs(currFloor, noOfMc, noOfSc);
		return currFloor;
	}
	
private static void initCorrs(Floor floor, int noOfMc, int noOfSc) {
		
		for(int i=0;i<noOfMc; i++){
			MainCorridor mc = new MainCorridor();
			floor.getMainCrdr().add(mc);
		}
		
		for(int i=0;i < noOfSc; i++){
			SubCorridor sc = new SubCorridor();
			floor.getSubCrdr().add(sc);
		}
		
	}

}
