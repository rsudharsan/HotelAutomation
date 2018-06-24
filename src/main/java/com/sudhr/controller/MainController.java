package com.sudhr.controller;

import java.util.ArrayList;
import java.util.List;

import com.sudhr.criteria.ICriteria;
import com.sudhr.factory.CriteriaGenerator;
import com.sudhr.factory.FloorGenerator;
import com.sudhr.model.Floor;
import com.sudhr.model.SubCorridor;

public class MainController {
	
	private final List<Floor> floors = new ArrayList<Floor>();
	
	public List<Floor> getFloors() {
		return floors;
	}

public void init(int noOfFloors, int noOfMc, int noOfSc){
	floors.clear();
	for(int i=0;i<noOfFloors;i++){
		Floor currFloor = FloorGenerator.getNewFloor(noOfMc,noOfSc);
		floors.add(currFloor);
	}
}


private void applyCriteria(Floor floor,boolean toggle) {
ICriteria criteria = CriteriaGenerator.getCurrentCriteria();
if (toggle == true) criteria.rebalanceON(floor);
else criteria.rebalanceOFF(floor);
}

public void toggleSensor(int floorIndex, int corIndex, boolean toggle){
	
	SubCorridor corr = floors.get(floorIndex).getSubCrdr().get(corIndex);
	corr.getLight().setSwitchOn(toggle);
	applyCriteria(floors.get(floorIndex),toggle);
}


}
