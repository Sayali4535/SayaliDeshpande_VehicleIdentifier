package com.vehicle.identifier.config;

import java.io.File;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;

public class VehicleConfig {
	
	private final String VEHICLE_IDENT_SCHEMA_FILENAME = "vehicle-identifier-config.xsd";
	
	private static VehicleConfig vehicleConfig;
	private List<Vehicle> vehicleList;
	
	private VehicleConfig() {
		
	}
	
	public static VehicleConfig getInstance() {
		if( vehicleConfig == null ) {
			vehicleConfig = new VehicleConfig();
		}
		return vehicleConfig;
	}
	
	public void load( File vehicleIdentfile ) throws Exception {

		try {
			JAXBContext jc = JAXBContext.newInstance( Vehicles.class );
			Unmarshaller um = jc.createUnmarshaller();

			// Step-1: Validate input config file
			String configDirPath = vehicleIdentfile.getParent();
			File schemaFile = new File( configDirPath, VEHICLE_IDENT_SCHEMA_FILENAME );
			SchemaFactory schemaFactory = SchemaFactory.newInstance(
					XMLConstants.W3C_XML_SCHEMA_NS_URI );
			javax.xml.validation.Schema dfSchema = schemaFactory.newSchema( schemaFile );
			um.setSchema( dfSchema );

			// Step-2: Read object from file
			Vehicles vehicles = (Vehicles) um.unmarshal( vehicleIdentfile );

			// Step-3: Store all vehicle objects into list
			vehicleList =  vehicles.getVehicle();
			
		} catch (Exception e) {
			throw new Exception("Error while reading configuration file "
					+ "[" + vehicleIdentfile  + "]");
		}
	}

	public List<Vehicle> getVehicleList(){
		return vehicleList;
	}
}