package com.sudhr.model;

public class SubCorridor implements ICorridor {
	
	private Light light;
	private AirCon ac;
	private boolean lightAlwaysOn = false;
	
	public SubCorridor(){
		this.light = new Light();
		this.ac = new AirCon();
		this.light.setSwitchOn(false);
		this.ac.setSwitchOn(true);
	}
	public Light getLight() {
		return light;
	}
	public void setLight(Light light) {
		this.light = light;
	}
	public AirCon getAc() {
		return ac;
	}
	public void setAc(AirCon ac) {
		this.ac = ac;
	}
	
	public boolean isLightAlwaysOn(){
		 return lightAlwaysOn;
	}
	
	public int getPwr(){
		return this.light.getPwr() + this.ac.getPwr();
	}

}
