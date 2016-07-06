package com.vehicle.identifier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.vehicle.identifier.config.Vehicle;
import com.vehicle.identifier.config.VehicleConfig;
import com.vehicle.identifier.config.Wheel;
import com.vehicle.identifier.config.Wheels;
import com.vehicle.identifier.vehicleType.Bicycle;
import com.vehicle.identifier.vehicleType.BigWheel;
import com.vehicle.identifier.vehicleType.Car;
import com.vehicle.identifier.vehicleType.HangGlider;
import com.vehicle.identifier.vehicleType.Motorcycle;

public class VehicleIdentifier{
	
	private final String REPORT_FILE_NAME = "vehicleIdentificationReport.csv";
	private List<String> bigWheelList;
	private List<String> bicycleList;
	private List<String> motorCycleList;
	private List<String> handGliderList;
	private List<String> carList;
	private List<String> invalidFormatList;
	
	public VehicleIdentifier() {
		bigWheelList = new ArrayList<String>();
		bicycleList = new ArrayList<String>();
		motorCycleList = new ArrayList<String>();
		handGliderList = new ArrayList<String>();
		carList = new ArrayList<String>();
		invalidFormatList = new ArrayList<String>();
	}
	
	public void process( File vehicleIdentXmlPath ) throws Exception {
		try {
			// Step-1: Read input xml file 
			loadConfiguration( vehicleIdentXmlPath );

			// Step-2: Identify Vehicle types depending on their no of wheels
			identifyVehicleType();

			// Step-3: Generate report that lists each vehicle id and its type and 
			// summary saying how many vehicles of each type are in the XML.
			generateReport( vehicleIdentXmlPath );
		} catch (Exception e) {
			throw new Exception( e );
		}
	}
	
	/*
	 * This method loads input into memory.
	 */
	private void loadConfiguration( File vehicleIdentXmlPath ) throws Exception {
		VehicleConfig vehicleConfig = VehicleConfig.getInstance();
		vehicleConfig.load( vehicleIdentXmlPath );
	}

	/*
	 * This method identifies vehicle types and store their ids into respective list
	 */
	private void identifyVehicleType() {
		VehicleConfig vehicleConfig = VehicleConfig.getInstance();
		// STep-1: Take all vehicles present in input xml file.
		List<Vehicle> vehicleList = vehicleConfig.getVehicleList();
		String vehicleId;
		int wheelSz;
		Wheels wheels;
		List<Wheel> wheelList;
		for( Vehicle vehicle : vehicleList ) {
			vehicleId = vehicle.getId();
			wheels = vehicle.getWheels();
			wheelList = wheels.getWheel();
			if( wheelList == null || wheelList.size() == 0 ) {
				wheelSz = 0;
			} else {
				wheelSz = wheelList.size();
			}
			// Step-2: Identify no of wheels of vehicle and according to wheel no identify vehicle type
			switch( wheelSz ) {
			case 0: 
					// Step-2.1: If no of wheels = 0 then identify whether vehicle is of Hand Glider type
					identifyHandGlider( vehicle );
					break;
			case 2: 
					// Step-2.2: If no of wheels = 2 then identify whether vehicle is of bicycle or motorcycle
					idetifyBicycleOrMotorCycle( vehicle );
					break;
			case 3: 
					// Step-2.3: If no of wheels =3 then identify whether vehicle is of Big Wheel 
					identifyBigWheel( vehicle );
					break;
			case 4: 
					// Step-2.4: If no of vehicle = 4 then identify whether it is car
					identifyCar( vehicle );
					break;
			default:
					// Step-2.5: It is invalid format of vehicle, add vehicle id into invali format list
					invalidFormatList.add( vehicleId );
			}
		}
		// Step-3: Print all vehicle ids from invalid format list 
		for( String invalidVehicleId : invalidFormatList ) {
			System.out.println("Please provide proper details of vehicle [" + invalidVehicleId + "]");
		}
	}
	
	/*
	 * This method identifies whether input vehicle is of type car or not
	 */
	private void identifyCar(Vehicle vehicle) {
		String vehicleId = vehicle.getId();
		Car car = new Car( vehicle );
		if( car.validate() ) {
			carList.add( vehicleId );
		} else {
			invalidFormatList.add( vehicleId );
		}		
	}

	/*
	 * This method identifies whether input vehicle is of type Big wheel or not
	 */
	private void identifyBigWheel(Vehicle vehicle) {
		String vehicleId = vehicle.getId();
		BigWheel bigWheel = new BigWheel( vehicle );
		if( bigWheel.validate() ) {
			bigWheelList.add( vehicleId );
		} else {
			invalidFormatList.add( vehicleId );
		}
		
	}
	
	/*
	 * This method identifies whether input vehicle is of bicycle or motor type
	 */
	private void idetifyBicycleOrMotorCycle(Vehicle vehicle) {
		String vehicleId = vehicle.getId();
		Bicycle bicyle = new Bicycle( vehicle );
		if( bicyle.validate() ) {
			bicycleList.add( vehicleId );
		} else {
			Motorcycle motorcycle = new Motorcycle( vehicle );
			if( motorcycle.validate() ) {
				motorCycleList.add( vehicleId );
			} else {
				invalidFormatList.add( vehicleId );
			}
		}		
	}

	/*
	 * This method identifies whether input vehicle is of hand glider type or not 
	 */
	private void identifyHandGlider(Vehicle vehicle) {
		String vehicleId = vehicle.getId();
		HangGlider hangGlinder = new HangGlider( vehicle ) ;
		if( hangGlinder.validate() ) {
			handGliderList.add( vehicle.getId() );
		} else {
			invalidFormatList.add( vehicleId );
		}
	}

	/*
	 * This method generates "vehicleIdentificationReport.csv" at the same location
	 * where input xml file is present
	 */
	private void generateReport( File inputFile ) throws Exception {
		String filePath = inputFile.getParent();
		File report = new File( filePath, REPORT_FILE_NAME );
		BufferedWriter bw = null;
		try {
			// Step-1: Initialize buffer writer
			bw = new BufferedWriter( new FileWriter( report ) );
			
			// Step-2: Print no of vehicle of each type
			bw.write( "No Of Big Wheel, No Of Bicycle, No Of Motorcycle, No of Hand Glider, No Of Cars \n");
			String noOfVehicles = bigWheelList.size() + "," + bicycleList.size() + "," + motorCycleList.size() + "," + 
									handGliderList.size() + "," + carList.size() + "\n" ; 
			bw.write(noOfVehicles );
			
			bw.newLine();
			bw.newLine();
			
			// Step-3: Print vehicle id of each type
			writeReport( bw, "Big Wheel", bigWheelList );
			writeReport( bw, "Bicycle", bicycleList );
			writeReport( bw, "Motorcycle", motorCycleList );
			writeReport( bw, "Hand Glider", handGliderList );
			writeReport( bw, "Car", carList );
		} catch (IOException e) {
			throw new IOException( "Ërror while writing report", e );
		} finally {
			if( bw != null ) {
				try {
					// Step-4: Close buffered writer
					bw.flush();
					bw.close();
					System.out.println("Report is generated at [" +report + "]");
				} catch (IOException e) {
					throw new IOException( "Ërror while writing report", e );				}
			}
		}
	}

	/*
	 * This method prints ids from input vehicleIdList under ïnput header.
	 */
	private void writeReport(BufferedWriter bw, String header, List<String> vehicleIdList ) throws IOException {
		bw.write( header );
		for( String vehicleId : vehicleIdList ) {
			bw.write("," + vehicleId );
		}
		bw.newLine();
	}
	
	public int getNoOfCars(){
		return carList.size();
	}
	
	public int getNoOfBigWheel(){
		return bigWheelList.size();
	}
	
	public int getNoOfBycle(){
		return bicycleList.size();
	}
	
	public int getNoOfmotorCycle(){
		return motorCycleList.size();
	}
	
	public int getNoOfhandGlider(){
		return handGliderList.size();
	}
	
	public int getNoOfinvalidFormat(){
		return invalidFormatList.size();
	}
}