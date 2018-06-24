package com.sudhr.criteria;

import com.sudhr.model.Floor;

public interface ICriteria {

	public boolean hasCriteriaFailed (Floor floor);
	public void rebalanceON(Floor floor);
	public void rebalanceOFF(Floor floor);
}
