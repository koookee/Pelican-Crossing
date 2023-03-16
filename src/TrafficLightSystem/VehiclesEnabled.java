/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 * 
 * The parent class responsible for handling the
 * vehicle related traffic light states
 */
public class VehiclesEnabled implements TrafficLightState {
	
	protected Context trafficLight;
	protected int timeToWait;
	protected Thread timerThread;
	
	public VehiclesEnabled(Context trafficLight) {
		System.out.println("-------------------------------------");
		this.trafficLight = trafficLight;
		this.timeToWait = 0;
		printCurrentState();
	}
	
	/**
	 * The behaviour executed when the state is entered
	 */
	public void stateEntry() {
		signalPedestrians(PedestrianLight.DONT_WALK);
		trafficLight.trafficLightState = new VehiclesGreen(trafficLight);
	}
	
	/**
	 * The behaviour executed when the state is exited
	 */
	public void stateExit() {
		// Nothing specific for vehicles enabled
	}

	/**
	 * Spins up a timer thread for the state 
	 * @param timeToWait the int time in seconds
	 */
	@Override
	public void setTimer(int timeToWait) {
		timerThread = new Thread(new Timer(trafficLight, timeToWait));
		timerThread.start();
	}
	
	/**
	 * Signals that a pedestrian is waiting to cross
	 */
	@Override
	public void pedestrianWaiting() {
		trafficLight.pedestrianIsWaiting = true;
	}

	/**
	 * Changes the traffic light for the pedestrians
	 */
	@Override
	public void signalPedestrians(PedestrianLight pedestrianLight) {
		trafficLight.pedestrianLight = pedestrianLight;
		System.out.println("Pedstrian lights turned to " + pedestrianLight);
	}

	/**
	 * Changes the traffic light for the vehicles
	 */
	@Override
	public void signalVehicles(VehicleLight vehicleLight) {
		trafficLight.vehicleLight = vehicleLight;
		System.out.println("Vehicle lights turned to " + vehicleLight);
	}

	/**
	 * Prints the state that the traffic light is in
	 */
	@Override
	public void printCurrentState() {
		System.out.println("In Vehicle Enabled state");
	}
	
	/**
	 * Gets the time that the state is supposed to wait
	 * @return the int of the time to wait in seconds
	 */
	@Override
	public int getTimeToWait() {
		return timeToWait;
	}
	
}
