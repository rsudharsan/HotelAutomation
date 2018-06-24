package com.sudhr.criteria;

import com.sudhr.model.Floor;
import com.sudhr.model.SubCorridor;

public class SubCorridorCriteria implements ICriteria{
	
	public boolean hasCriteriaFailed (Floor floor){
		
		int maxConsumption = floor.getMainCrdr().size()*15 + floor.getSubCrdr().size()*10;
		int currentConsumption = floor.getPwr();
		if(currentConsumption <= maxConsumption) return false; 
		return true;
	}
	
	public void rebalanceON(Floor floor){
		
		// in case movement detected switch off other acs until consumption is under max limit
		while(hasCriteriaFailed(floor)) {
			for(SubCorridor subC : floor.getSubCrdr()){
				if(!subC.getLight().isSwitchOn()) {
					subC.getAc().setSwitchOn(false);
					continue;
				}
			}
		}
	}

	public void rebalanceOFF(Floor floor) {
		//switch on any of the acs which were off before to rebalance
		for(SubCorridor subC : floor.getSubCrdr()){
			if(!subC.getLight().isSwitchOn() && !subC.getAc().isSwitchOn()) {
				subC.getAc().setSwitchOn(true);
				continue;
			}
		}
	}
}
