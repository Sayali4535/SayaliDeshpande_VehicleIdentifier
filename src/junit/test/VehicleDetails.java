package junit.test;

import java.util.List;

public class VehicleDetails {
	
	private String material;
	private int noOfWheels;
	private String powerTrain;
	private List<String> positionList;

	/**
	 * returns no of wheels of vehicle
	 * @return
	 */
	public int getWheelNo() {
		return noOfWheels;
	}

	/**
	 * set param noOfWheels as a noOfWheels to vehicle
	 * @param noOfWheels
	 */
	public void setWheelNo(int noOfWheels ) {
		this.noOfWheels = noOfWheels;
	}

	/**
	 * returns powertrain of vehicle
	 * @return
	 */
	public String getPowerTrain() {
		return powerTrain;
	}

	/**
	 * set param powertrain to powertrain of vehicle
	 * @param powerTrain
	 */
	public void setPowerTrain(String powerTrain) {
		this.powerTrain = powerTrain;
	}

	/**
	 * return positions of wheels of vehicle
	 * @return
	 */
	public List<String> getPositionList() {
		return positionList;
	}

	/**
	 * set param positionList to positions of wheels of vehicle
	 * @param positionList
	 */
	public void setPositionList(List<String> positionList) {
		this.positionList = positionList;
	}

	/**
	 * returns material of vehicle
	 * @return
	 */
	public String getMaterial() {
		return material;
	}
	
	/**
	 * set param material to material of vehicle
	 * @param powerTrain
	 */
	public void setMaterial( String material ) {
		this.material = material;
	}
}