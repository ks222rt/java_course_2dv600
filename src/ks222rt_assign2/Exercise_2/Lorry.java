package ks222rt_assign2.Exercise_2;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class Lorry extends Vehicle {
    final int MAX_PASSENGERS = 2;

    public Lorry(int p) throws Exception {
        if (rightAmountOfPassengers(p, MAX_PASSENGERS)){
            this.passengers = new Passenger(p);
            this.feeForPassengers = 15 * this.passengers.getAmount();
            this.fee = 300;
            this.space = 8;
        }else{
            throw new Exception("To many people in the car");
        }
    }
}
