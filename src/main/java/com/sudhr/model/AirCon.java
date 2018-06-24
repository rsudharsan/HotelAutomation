package com.sudhr.model;

public class AirCon implements IDevice {
	
	private int unit = 10;
	private boolean switchOn ;

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getPwr() {
		if (this.switchOn){
			return unit;
		}
		return 0;
	}


	public boolean isSwitchOn() {
		return switchOn;
	}

	public void setSwitchOn(boolean switchOn) {
		this.switchOn = switchOn;
	}

}
