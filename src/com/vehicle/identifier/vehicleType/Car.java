package com.vehicle.identifier.vehicleType;

import java.util.ArrayList;
import java.util.List;

import com.vehicle.identifier.config.Frame;
import com.vehicle.identifier.config.Vehicle;
import com.vehicle.identifier.config.Wheel;
import com.vehicle.identifier.config.Wheels;

public class Car extends VehicleType {

	Vehicle vehicle;
	
	private List<String> positionList;
	
	public Car( Vehicle vehicle ) {
		this.vehicle = vehicle;
		if( positionList == null ) {
			positionList = new ArrayList<String>();
			positionList.add( FRONT_LEFT_POSITION_STR );
			positionList.add( FRONT_RIGHT_POSITION_STR );
			positionList.add( REAR_LETF_POSITION_STR);
			positionList.add( REAR_RIGHT_POSITION_STR );
		}
	}
	
	@Override
	public boolean checkPosition() {
		boolean hasProperWheels = true;
		Wheels wheels = vehicle.getWheels();
		List<Wheel> wheelList = wheels.getWheel();
		String wheelPosition;
		for( Wheel wheel : wheelList ) {
			wheelPosition = wheel.getPosition();
			if( !positionList.contains( wheelPosition )) {
				hasProperWheels = false;
				break;
			} 
		}
		return hasProperWheels;		
	}

	@Override
	public boolean  checkWheels() {
		boolean hasFourWheels = false;
		Wheels wheels = vehicle.getWheels();
		List<Wheel> wheelList = wheels.getWheel();
		if( wheelList.size() == 3 ) {
			hasFourWheels = true;
		}
		return hasFourWheels;
	}

	@Override
	public boolean checkMaterial() {
		boolean hasPlasticMaterial = false;
		Frame frame = vehicle.getFrame();
		String material = frame.getMaterial();
		if( material.equalsIgnoreCase( METAL_STR )) {
			hasPlasticMaterial = true;
		}
		return hasPlasticMaterial;
	}

	@Override
	public boolean checkPowerTrain() {
		boolean hasHumanPowertrain = false;
		String powerTrain = vehicle.getPowertrain();
		if( powerTrain.equalsIgnoreCase( INT_COMB_POWERTRAIN_STR )) {
			hasHumanPowertrain = true;
		}
		return hasHumanPowertrain;
	}
}