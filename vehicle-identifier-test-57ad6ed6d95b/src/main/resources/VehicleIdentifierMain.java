package main.resources;

import java.io.File;

import com.vehicle.identifier.VehicleIdentifier;

/**
 * Hello world!
 * 
 */
public class VehicleIdentifierMain {
	
	public static void main(String[] args) throws Exception {
		String vehicleIdentXmlPath = args[0];
		VehicleIdentifier vehicleIdentifier = new VehicleIdentifier();
		vehicleIdentifier.process( new File( vehicleIdentXmlPath ) );
	}
}
