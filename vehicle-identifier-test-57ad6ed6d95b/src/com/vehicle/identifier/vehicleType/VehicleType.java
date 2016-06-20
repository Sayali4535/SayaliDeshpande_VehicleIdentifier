package com.vehicle.identifier.vehicleType;


public abstract class VehicleType {

	protected final String PLASTIC_STR = "Plastic";
	
	protected final String METAL_STR = "Metal";

	protected final String REAR_POSITION_STR = "rear";
	
	protected final String REAR_LETF_POSITION_STR = "left rear";
	
	protected final String REAR_RIGHT_POSITION_STR = "right rear";
	
	protected final String FRONT_POSITION_STR = "front";
	
	protected final String FRONT_LEFT_POSITION_STR = "left front";
	
	protected final String FRONT_RIGHT_POSITION_STR = "right front";
	
	protected final String HUMAN_POWERTRAIN_STR = "human";
	
	protected final String INT_COMB_POWERTRAIN_STR = "Internal Combustion";
	
	protected final String BERN_POWERTRAIN_STR = "Bernoulli";
	
	public abstract boolean checkPosition();
	
	public abstract boolean checkWheels();
	
	public abstract boolean checkMaterial();
	
	public abstract boolean checkPowerTrain();
		
	public boolean validate() {
		boolean isSpecifiedType = checkMaterial();
		if( isSpecifiedType ) {
			isSpecifiedType = checkPowerTrain();
			if( isSpecifiedType ) {
				isSpecifiedType = checkPosition();
			}
		}
		return isSpecifiedType;
	}
}
