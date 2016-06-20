package com.vehicle.identifier.vehicleType;

import java.util.List;

import com.vehicle.identifier.config.Frame;
import com.vehicle.identifier.config.Vehicle;
import com.vehicle.identifier.config.Wheel;
import com.vehicle.identifier.config.Wheels;

public class HangGlider extends VehicleType {

	Vehicle vehicle;
	
	public HangGlider( Vehicle vehicle ) {
		this.vehicle = vehicle;
	}
	
	@Override
	public boolean checkPosition() {
		boolean hasProperWheels = false;
		Wheels wheels = vehicle.getWheels();
		List<Wheel> wheelList = wheels.getWheel();
		if( wheelList == null || wheelList.size() == 0) {
			hasProperWheels = true;
		} 
		return hasProperWheels;		
	}

	@Override
	public boolean  checkWheels() {
		boolean hasNoWheels = false;
		Wheels wheels = vehicle.getWheels();
		List<Wheel> wheelList = wheels.getWheel();
		if( wheelList == null || wheelList.size() == 0) {
			hasNoWheels = true;
		} 
		return hasNoWheels;
	}

	@Override
	public boolean checkMaterial() {
		boolean hasPlasticMaterial = false;
		Frame frame = vehicle.getFrame();
		String material = frame.getMaterial();
		if( material.equalsIgnoreCase( PLASTIC_STR )) {
			hasPlasticMaterial = true;
		}
		return hasPlasticMaterial;
	}

	@Override
	public boolean checkPowerTrain() {
		boolean hasHumanPowertrain = false;
		String powerTrain = vehicle.getPowertrain();
		if( powerTrain.equalsIgnoreCase( BERN_POWERTRAIN_STR )) {
			hasHumanPowertrain = true;
		}
		return hasHumanPowertrain;
	}
}