import java.util.Scanner;

public class Main
{
  public static void main(String[] args) {
    Km2Mile toMile = new Km2Mile(1.6);
    toMile.run();
  }
}

abstract class Converter {
  abstract protected double convert(double src);
  abstract protected String getDestString();

  protected double ratio;

  public void run() {
    Scanner scanner = new Scanner(System.in);
    double val = scanner.nextDouble();
    double res = convert(val);
    System.out.println("변환 결과: " + res + getDestString() + "입니다.");
    scanner.close();
  }
}

class Km2Mile extends Converter {

  public Km2Mile(double ratio) {
    this.ratio = ratio;
  }

  protected double convert(double src) {
    return src / ratio;
  }

  protected String getDestString() {
    return "Mile";
  }
}
