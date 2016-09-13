package ks222rt_assign2.Exercise_2;

import java.util.ArrayList;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public abstract class Vehicle {
    protected Passenger passengers;
    protected double space;
    protected int fee;
    protected int feeForPassengers;
    private ArrayList<Vehicle> listOfVehicles = new ArrayList<>();

    protected boolean rightAmountOfPassengers(int aPassengers, int max){
        if (aPassengers <= max){
            return true;
        }
        return false;
    }

    public int getPassengers(){
        return this.passengers.getAmount();
    }

    public int getFeeForPassengers(){
        return this.feeForPassengers;
    }

    public int getFee(){
        return this.fee;
    }

    public double getSpace(){
        return this.space;
    }
}
