package Tasks;

public class ArithmeticalOperations {
    int summand1;
    int summand2;

    int summation(int summand1, int summand2){
        return summand1 + summand2;
    }

    int someOperation(int summand1, int summand2, int divider) {
        return (summand1 + summand2) / divider;
    }

    ArithmeticalOperations(int summand1, int summand2) {
        this.summand1 = summand1;
        this.summand2 = summand2;
    }
}
