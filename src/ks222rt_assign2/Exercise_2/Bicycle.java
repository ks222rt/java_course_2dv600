package ks222rt_assign2.Exercise_2;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class Bicycle extends Vehicle {
    final int MAX_PASSENGERS = 1;

    public Bicycle(int p) {
        if (rightAmountOfPassengers(p, MAX_PASSENGERS)){
            this.fee = 40;
            this.feeForPassengers = 0;
            this.space = 0.2;
            this.passengers = p;
            this.type = "Bicycle";
        }else{
            System.err.println("To many people on the bike..");
        }
    }
}
