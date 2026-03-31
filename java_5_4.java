import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    StackApp.run();
  }
}

interface Stack {
  int length();      // 현재 스택에 저장된 개수
  int capacity();    // 스택의 전체 저장 가능한 개수
  String pop();      // 스택의 톱(top)에 저장된 실수 리턴
  boolean push(String val); // 스택의 톱(top)에 실수 저장
}

class StringStack implements Stack {
  private String[] stack;
  private int top;

  public StringStack(int capacity) {
    stack = new String[capacity];
    top = 0;
  }

  public int length() {
    return top;
  }

  public int capacity() {
    return stack.length;
  }

  public boolean push(String val) {
    if (top == stack.length) {
      return false; 
    }
    stack[top++] = val;
    return true;
  }

  public String pop() {
    if (top == 0) {
      return null; 
    }
    return stack[--top];
  }
}

class StackApp {
  public static void run() {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();

    StringStack stack = new StringStack(size);

    while (true) {
      String str = sc.next();

      if (str.equals("그만"))
        break;

      if (!stack.push(str)) {
        System.out.println("스택이 꽉 차서 푸시 불가!");
      }
    }

    System.out.print("스택에 저장된 모든 문자열 팝 : ");
    while (stack.length() > 0) {
      System.out.print(stack.pop() + " ");
    }

    sc.close();
  }
}
