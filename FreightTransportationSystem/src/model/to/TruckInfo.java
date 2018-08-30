package model.to;

public class TruckInfo {

    private String truckno;
    private String chassisno;
    private float capacity;
    private float weight;

    public String getTruckno() {
        return truckno;
    }

    public void setTruckno(String truckno) {
        this.truckno = truckno;
    }

    public String getChassisno() {
        return chassisno;
    }

    public void setChassisno(String chassisno) {
        this.chassisno = chassisno;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return truckno;
    }
    
}
