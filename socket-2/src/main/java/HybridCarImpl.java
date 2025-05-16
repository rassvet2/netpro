public class HybridCarImpl implements ICar, IElectricCharge, INavigation, Cloneable {
    private String name;
    private String destination;
    private int batteryLevel = 50;
    private int speed = 5;

    public HybridCarImpl(String name) {
        this.name = name;
    }


	@Override
	public void chargeBattery(int b) {
		this.batteryLevel = b;
	}

	@Override
	public int getAllBattery() {
		return batteryLevel;
	}

	@Override
	public int consumeBattery(int b) {
		this.batteryLevel-= b;
		return this.batteryLevel;
	}

	@Override
	public void setSpeed(int sp) {
		this.speed = sp;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void printCarName() {
		System.out.println(this.name + " " + this.speed + "km");
	}


    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }


    @Override
    public void printRoute() {
        System.out.println("destination: " + destination);
    }


	@Override
	protected HybridCarImpl clone() throws CloneNotSupportedException {
		return (HybridCarImpl) super.clone();
	}


}
