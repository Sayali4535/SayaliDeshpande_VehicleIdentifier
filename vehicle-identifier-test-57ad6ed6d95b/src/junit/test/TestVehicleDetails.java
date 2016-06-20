package junit.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestVehicleDetails {

	VehicleDetails vehicleDetails = new VehicleDetails();
	VehicleDetailsBusinessLogic vehicleBusineesLogic = new VehicleDetailsBusinessLogic();
	
	@Test
	public void testMaterial() {
		vehicleDetails.setMaterial( "Plastic" );
		vehicleDetails.setPowerTrain( "human" );
		vehicleDetails.setWheelNo( 2 );
		String material = vehicleBusineesLogic.checkMaterial( vehicleDetails );
		assertEquals( "Plastic", material );
	}

	@Test
	public void testNoOfWheels() {
		vehicleDetails.setMaterial( "Metal" );
		vehicleDetails.setPowerTrain( "Internal Combustion" );
		vehicleDetails.setWheelNo( 4 );
		int noOfWheels = vehicleBusineesLogic.checkNoOfWheels( vehicleDetails );
		assertEquals( 4, noOfWheels );
	}

	@Test
	public void testPowertrain() {
		vehicleDetails.setMaterial( "Plastic" );
		vehicleDetails.setPowerTrain( "Bernoulli" );
		vehicleDetails.setWheelNo( 0 );
		String powertrain = vehicleBusineesLogic.checkPowertrain( vehicleDetails );
		assertEquals( "Bernoulli", powertrain );
	}
	
	@Test
	public void testWheelPositions() {
		vehicleDetails.setMaterial( "Metal" );
		vehicleDetails.setPowerTrain( "human" );
		vehicleDetails.setWheelNo( 2 );
		List<String> positionList = new ArrayList< String >();
		positionList.add( "front" );
		positionList.add( "rear" );
		vehicleDetails.setPositionList( positionList );
		List<String> positions = vehicleBusineesLogic.checkPositionList( vehicleDetails );
		assertEquals( positionList, positions );
	}
}

