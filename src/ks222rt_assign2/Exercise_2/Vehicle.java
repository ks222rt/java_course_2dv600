package ks222rt_assign2.Exercise_2;

import java.util.ArrayList;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public abstract class Vehicle {
    protected int passengers;
    protected double space;
    protected int fee;
    protected int feeForPassengers;
    protected String regNr;

//    protected ArrayList<Passenger> listOfPassengers = new ArrayList<>();

    protected boolean rightAmountOfPassengers(int aPassengers, int max){
        if (aPassengers <= max){
            return true;
        }
        return false;
    }

    public int getAmountPassengers(){
        return this.passengers;
    }

    public int getFeeForPassengers(){
        return this.feeForPassengers * getAmountPassengers();
    }

    public int getFee(){
        return this.fee;
    }

    public double getSpace(){
        return this.space;
    }

//    protected void addPassenger(Passenger p){
//        this.listOfPassengers.add(p);
//    }
}
