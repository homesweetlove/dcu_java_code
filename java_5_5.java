import java.util.Scanner;

public class Main {
  public static void main (String args[]) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    String op = sc.next();

    Calc calc = null;

    switch(op) {
      case "+":
        calc = new Add();
        break;
      case "-":
        calc = new Sub();
        break;
      case "*":
        calc = new Mul();
        break;
      case "/":
        calc = new Div();
        break;
      default:
        System.out.println("잘못된 연산자입니다.");
        sc.close();
        return; 
    }

    calc.setValue(a, b);

    try {
      System.out.println(calc.calculate());
    } catch (ArithmeticException e) {
      System.out.println("계산할 수 없습니다.");
    }

    sc.close();
  }
}

abstract class Calc {
  int a, b;

  void setValue(int a, int b) {
    this.a = a;
    this.b = b;
  }

  abstract int calculate();
}

class Add extends Calc {
  int calculate() {
    return a + b;
  }
}

class Sub extends Calc {
  int calculate() {
    return a - b;
  }
}

class Mul extends Calc {
  int calculate() {
    return a * b;
  }
}

class Div extends Calc {
  int calculate() {
    if (b == 0) {
      throw new ArithmeticException(); 
    }
    return a / b;
  }
}
