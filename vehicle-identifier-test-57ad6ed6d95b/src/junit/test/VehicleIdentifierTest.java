package junit.test;


import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vehicle.identifier.VehicleIdentifier;
import com.vehicle.identifier.config.Frame;
import com.vehicle.identifier.config.Vehicle;
import com.vehicle.identifier.config.VehicleConfig;
import com.vehicle.identifier.config.Wheel;
import com.vehicle.identifier.config.Wheels;
import com.vehicle.identifier.vehicleType.Bicycle;
import com.vehicle.identifier.vehicleType.BigWheel;
import com.vehicle.identifier.vehicleType.Car;
import com.vehicle.identifier.vehicleType.HangGlider;
import com.vehicle.identifier.vehicleType.Motorcycle;

/**
 * Unit test for simple App.
 */
public class VehicleIdentifierTest {

	private File inputFilePath1 = new File( "D:\\workspace\\vehicle-identifier-test-57ad6ed6d95b\\config\\vehicle_identifier1.xml" );;
	
	private File inputFilePath2  = new File( "D:\\workspace\\vehicle-identifier-test-57ad6ed6d95b\\config\\vehicle_identifier2.xml" );
	
	private Vehicle vehicle;
	
	private VehicleIdentifier vehicleIdentifier;
	
	@Test
	public void validateInvalidCarDetails() {
		Frame frame = new Frame();
		frame.setMaterial("metal");
		vehicle.setFrame( frame );
		vehicle.setPowertrain( "Internal Combustion" );
		Wheels wheels = new Wheels();
		Wheel wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("front right");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("front left");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("rear right");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("rear left");
		wheels.getWheel().add(wheel);
		vehicle.setWheels( wheels );
		Car car = new Car(vehicle);
		assertEquals( false, car.validate() );
	}
	
	@Test
	public void validateValidCarDetails() {
		Frame frame = new Frame();
		frame.setMaterial("metal");
		vehicle.setFrame( frame );
		vehicle.setPowertrain( "Internal Combustion" );
		Wheels wheels = new Wheels();
		Wheel wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("right front");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("left front");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("right rear");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("left rear");
		wheels.getWheel().add(wheel);
		vehicle.setWheels( wheels );
		Car car = new Car(vehicle);
		assertEquals( true, car.validate() );
	}
	
	@Test
	public void validateInvalidBigWheelDetails() {
		Frame frame = new Frame();
		frame.setMaterial("metal");
		vehicle.setFrame( frame );
		vehicle.setPowertrain( "Human" );
		Wheels wheels = new Wheels();
		Wheel wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("front");
		wheels.getWheel().add(wheel);
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("right rear");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("left rear");
		wheels.getWheel().add(wheel);
		vehicle.setWheels( wheels );
		BigWheel bigWheel = new BigWheel(vehicle);
		assertEquals( false, bigWheel.validate() );
	}
	
	@Test
	public void validateValidBigWheelsDetails() {
		Frame frame = new Frame();
		frame.setMaterial("plastic");
		vehicle.setFrame( frame );
		vehicle.setPowertrain( "Human" );
		Wheels wheels = new Wheels();
		Wheel wheel = new Wheel();
		wheel.setMaterial("plastic");
		wheel.setPosition("front");
		wheels.getWheel().add(wheel);
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("plastic");
		wheel.setPosition("right rear");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("plastic");
		wheel.setPosition("left rear");
		wheels.getWheel().add(wheel);
		vehicle.setWheels( wheels );
		BigWheel bigWheel = new BigWheel(vehicle);
		assertEquals( true, bigWheel.validate() );
	}
	
	@Test
	public void validateValidBicycleDetails() {
		Frame frame = new Frame();
		frame.setMaterial("metal");
		vehicle.setFrame( frame );
		vehicle.setPowertrain( "Human" );
		Wheels wheels = new Wheels();
		Wheel wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("front");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("rear");
		wheels.getWheel().add(wheel);
		vehicle.setWheels( wheels );
		Bicycle bicycle = new Bicycle(vehicle);
		assertEquals( true, bicycle.validate() );
	}
	
	@Test
	public void validateInvalidBicycleDetails() {
		Frame frame = new Frame();
		frame.setMaterial("metal");
		vehicle.setFrame( frame );
		vehicle.setPowertrain( "Internal Combustion" );
		Wheels wheels = new Wheels();
		Wheel wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("front");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("rear");
		wheels.getWheel().add(wheel);
		vehicle.setWheels( wheels );
		Bicycle bicycle = new Bicycle(vehicle);
		assertEquals( false, bicycle.validate() );
	}
	
	@Test
	public void validateValidMotorCycleDetails() {
		Frame frame = new Frame();
		frame.setMaterial("metal");
		vehicle.setFrame( frame );
		vehicle.setPowertrain( "Internal Combustion" );
		Wheels wheels = new Wheels();
		Wheel wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("front");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("rear");
		wheels.getWheel().add(wheel);
		vehicle.setWheels( wheels );
		Motorcycle motorcycle = new Motorcycle(vehicle);
		assertEquals( true, motorcycle.validate() );
	}
	
	@Test
	public void validateInvalidMotorCycleDetails() {
		Frame frame = new Frame();
		frame.setMaterial("metal");
		vehicle.setFrame( frame );
		vehicle.setPowertrain( "Internal Combustion" );
		Wheels wheels = new Wheels();
		Wheel wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("front");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("rear left");
		wheels.getWheel().add(wheel);
		vehicle.setWheels( wheels );
		Motorcycle motorcycle = new Motorcycle(vehicle);
		assertEquals( false, motorcycle.validate() );
	}
	
	@Test
	public void validateValidHangGliderDetails() {
		Frame frame = new Frame();
		frame.setMaterial("plastic");
		vehicle.setFrame( frame );
		vehicle.setPowertrain( "Bernoulli" );
		Wheels wheels = new Wheels();
		vehicle.setWheels(wheels);
		HangGlider hangGlider = new HangGlider(vehicle);
		assertEquals( true, hangGlider.validate() );
	}
	
	@Test
	public void validateInvalidHangGliderDetails() {
		Frame frame = new Frame();
		frame.setMaterial("plastic");
		vehicle.setFrame( frame );
		vehicle.setPowertrain( "Bernoulli" );
		Wheels wheels = new Wheels();
		Wheel wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("front");
		wheels.getWheel().add(wheel);
		wheel = new Wheel();
		wheel.setMaterial("metal");
		wheel.setPosition("rear");
		wheels.getWheel().add(wheel);
		vehicle.setWheels( wheels );
		HangGlider hangGlider = new HangGlider(vehicle);
		assertEquals( false, hangGlider.validate() );
	}
	
	@Before
	public void setUp() throws Exception {
		vehicle = new Vehicle();
		vehicleIdentifier = new VehicleIdentifier();
	}

	@After
	public void tearDown() throws Exception {
		vehicle = null;
		vehicleIdentifier = null;
	}
	
	@Test
	public void testApp() throws Exception {
		vehicleIdentifier.process( inputFilePath1 );
		assertEquals( 1, vehicleIdentifier.getNoOfBigWheel() );
		assertEquals( 1, vehicleIdentifier.getNoOfBycle() );
		assertEquals( 2, vehicleIdentifier.getNoOfmotorCycle() );
		assertEquals( 1, vehicleIdentifier.getNoOfhandGlider() );
		assertEquals( 1, vehicleIdentifier.getNoOfCars() );
		assertEquals( 1, vehicleIdentifier.getNoOfinvalidFormat() );
	}
	
	@Test
	public void testLoadConfiguration() {
		VehicleConfig vehicleConfig = VehicleConfig.getInstance();
		try {
			vehicleConfig.load( inputFilePath2 );
		} catch (Exception e) {
			String errorMSG = "Error while reading configuration file "
					+ "[" + inputFilePath2  + "]";
			assertEquals( errorMSG, e.getMessage() );
		}
	}
}