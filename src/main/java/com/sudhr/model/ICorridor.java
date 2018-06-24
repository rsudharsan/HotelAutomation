package com.sudhr.model;

public interface ICorridor {
	
	public Light getLight();
	
	public void setLight(Light light) ;
	
	public AirCon getAc() ;
	
	public void setAc(AirCon ac) ;
	
	public boolean isLightAlwaysOn();
	
	public int getPwr();

}
