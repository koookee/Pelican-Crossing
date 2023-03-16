/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 * The class responsible for handling events 
 * in the Pedestrians Enabled state. Transitions to the first sub state 
 * on entry
 */
public class PedestriansEnabled implements TrafficLightState{
	protected Context trafficLight;
	protected int timeToWait;
	protected Thread timerThread;
	
	public PedestriansEnabled(Context trafficLight) {
		System.out.println("-------------------------------------");
		this.trafficLight = trafficLight;
		this.timeToWait = 0;
		printCurrentState();
	}
	
	/**
	 * The behaviour executed when the state is entered
	 */
	public void stateEntry() {
		signalVehicles(VehicleLight.RED);
		trafficLight.trafficLightState = new PedestriansWalk(trafficLight);
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
		System.out.println("Pedestrian pressed the waiting button");
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
		System.out.println("In Pedestrians Enabled state");
	}
}
