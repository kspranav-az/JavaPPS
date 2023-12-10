import Number.Number;

import java.util.Scanner;

public class QuadraticFormula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coefficients for the quadratic equation ax^2 + bx + c = 0:");

        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        Number quadraticSolver = new Number(b, Math.sqrt(b * b - 4 * a * c));

        double root1 = (-b + quadraticSolver.sqrt()) / (2 * a);
        double root2 = (-b - quadraticSolver.sqrt()) / (2 * a);

        System.out.println("\nRoots of the quadratic equation:");
        System.out.println("Root 1: " + root1);
        System.out.println("Root 2: " + root2);

        scanner.close();
    }
}
