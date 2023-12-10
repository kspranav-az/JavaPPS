package Number;

public class Number {
    private double num1;
    private double num2;

    public Number(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double sum() {
        return num1 + num2;
    }

    public double difference() {
        return num1 - num2;
    }

    public double product() {
        return num1 * num2;
    }

    public double division() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("Cannot divide by zero.");
            return Double.NaN;
        }
    }

    public double power() {
        return Math.pow(num1, num2);
    }

    public double sqrt() {
        if (num1 >= 0) {
            return Math.sqrt(num1);
        } else {
            System.out.println("Cannot calculate square root of a negative number.");
            return Double.NaN;
        }
    }
}
