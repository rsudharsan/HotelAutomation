package com.sudhr.model;

public class MainCorridor implements ICorridor {
	
	private Light light;
	private AirCon ac;
	private boolean lightAlwaysOn = true;
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
	
	public MainCorridor() {
		this.light = new Light();
		this.ac = new AirCon();
		this.light.setSwitchOn(true);
		this.ac.setSwitchOn(true);
	}
	public boolean isLightAlwaysOn(){
		 return lightAlwaysOn;
	}
	
	public int getPwr(){
		return this.light.getPwr() + this.ac.getPwr();
	}
	

}
