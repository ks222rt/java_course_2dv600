package ks222rt_assign2.Exercise_2;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class Lorry extends Vehicle {
    final int MAX_PASSENGERS = 2;

    public Lorry(int p) {
        if (rightAmountOfPassengers(p, MAX_PASSENGERS)){
            this.feeForPassengers = 15;
            this.fee = 300;
            this.space = 8;
            this.passengers = p;
            this.type = "Lorry";
        }else{
            System.err.println("To many people in the lorry");
        }
    }
}
