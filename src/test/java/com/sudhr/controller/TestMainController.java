package com.sudhr.controller;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.sudhr.model.Floor;
import com.sudhr.model.MainCorridor;
import com.sudhr.model.SubCorridor;

public class TestMainController {
	
	private MainController ctrl;

	@Before
	public void initialize(){
		ctrl = new MainController();
	}
	
	//test init condition
	@Test
	public void testInit() {
		System.out.println("**testing init with 2 floors each with 1 main and 1 sub corridor");
		ctrl.init(2, 1, 1);
		printStatus();
		for(Floor floor : ctrl.getFloors()){
			Assert.assertTrue(floor.getPwr() == 25);
		}
	}
	
	//---1 floor, 1 main corridor, 2 sub corridors 
	//movement in 2nd subcorridor
	@Test
	public void testMovement(){
		System.out.println("**testing rebalance with 1 floors each with 1 main and 2 sub corridor");
		ctrl.init(1, 1, 2);
		Floor floor = ctrl.getFloors().get(0);
		SubCorridor secondSubCorridor = floor.getSubCrdr().get(1);
		//check for initial power consumption = maincrdr 15 and subcor 2*10 20 - total 35
		Assert.assertTrue(floor.getPwr()<= 35);
		//sensing movement in first floor, second subcorridor 
		ctrl.toggleSensor(0,1,true);
		//check light on and rebalanced power is <=35
		Assert.assertTrue(secondSubCorridor.getLight().isSwitchOn());
		Assert.assertTrue(floor.getPwr()<= 35);
		printStatus();
		// movement sensing stopped in first floor, second subcorridor
		ctrl.toggleSensor(0,1,false);
		//check light off and rebalanced power is <=35
		Assert.assertFalse(secondSubCorridor.getLight().isSwitchOn());
		Assert.assertTrue(floor.getPwr()<= 35);
		printStatus();
	}
	
	private void printStatus(){
		
		for (Floor floor : ctrl.getFloors()){
			System.out.println("Status for floor "+ ctrl.getFloors().indexOf(floor));
			List<MainCorridor> mainCrdr = floor.getMainCrdr();
			List<SubCorridor> subCrdr = floor.getSubCrdr();
			for(MainCorridor mc : mainCrdr){
				System.out.println("Main corridor "+ mainCrdr.indexOf(mc) +" light is "+ mc.getLight().isSwitchOn() + " and ac is "+ mc.getAc().isSwitchOn());
			}
			for(SubCorridor sc: subCrdr){
				System.out.println("Sub corridor "+ subCrdr.indexOf(sc) +" light is "+ sc.getLight().isSwitchOn() + " and ac is "+ sc.getAc().isSwitchOn());
			}
			System.out.println("power consumption is "+ floor.getPwr());
		
		}
	}
  
}
