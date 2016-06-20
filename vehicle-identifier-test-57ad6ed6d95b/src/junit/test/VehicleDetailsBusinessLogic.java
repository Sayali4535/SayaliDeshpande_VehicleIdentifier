package junit.test;

import java.util.List;

public class VehicleDetailsBusinessLogic {

	public String checkMaterial( VehicleDetails vehicleDetails ) {
		String material = vehicleDetails.getMaterial();
		return material;
	}
	
	public int checkNoOfWheels( VehicleDetails vehicleDetails ) {
		int noOfWheels = vehicleDetails.getWheelNo();
		return noOfWheels;
	}
	
	public String checkPowertrain( VehicleDetails vehicleDetails ) {
		String powerTrain = vehicleDetails.getPowerTrain();
		return powerTrain;
	}
	
	public List<String> checkPositionList( VehicleDetails vehicleDetails ) {
		List<String> positionList = vehicleDetails.getPositionList();
		return positionList;
	}
}
