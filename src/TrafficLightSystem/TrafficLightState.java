/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 * The interface that defines the common functionality 
 * of all the different traffic light states
 */
public interface TrafficLightState {
	void stateEntry();
	void stateExit();
	void setTimer(int timeToWait);
	void pedestrianWaiting();
	void signalPedestrians(PedestrianLight pedestrianLight);
	void signalVehicles(VehicleLight vehicleLight);
	void printCurrentState();
	int getTimeToWait();
	
}
