package ks222rt_assign2.Exercise_2;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class Bus extends Vehicle {
    final int MAX_PASSENGERS = 20;

    public Bus(int p) {
        if (rightAmountOfPassengers(p, MAX_PASSENGERS)){
            this.feeForPassengers = 10;
            this.fee = 200;
            this.space = 4;
            this.passengers = p;
            this.type = "Bus";
        }else{
            System.err.println("To many passengers on the bus!");
        }
    }
}
