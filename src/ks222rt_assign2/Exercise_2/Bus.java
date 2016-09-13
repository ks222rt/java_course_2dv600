package ks222rt_assign2.Exercise_2;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class Bus extends Vehicle {
    final int MAX_PASSENGERS = 20;

    public Bus(int p) throws Exception {
        if (rightAmountOfPassengers(p, MAX_PASSENGERS)){
            this.passengers = new Passenger(p);
            this.feeForPassengers = 10 * this.passengers.getAmount();
            this.fee = 200;
            this.space = 4;
        }else{
            throw new Exception("To many people in the car");
        }
    }
}
