import java.util.Scanner;

public class PalindromeAlphabetCheck {
  public static void main(String[] args) {
    PalindromeAlphabetCheck T = new PalindromeAlphabetCheck();
    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine();
    System.out.println(T.solution(str));
  }

  // 해결방법
  // 입력받은 문자열에서 알파벳을 제외한 문자 제거
  // 알파벳만 남은 문자열을 뒤집은 문자가 기존과 같은지 확인
  public String solution(String str) {
    String answer = "NO";

    // 모든 알파벳을 대문자로 바꾸고 알파벳이 아닌 것은 아무것도 없는 문자로 바꿈
    str = str.toUpperCase().replaceAll("[^A-Z]", "");
    // 바꾼 문자열의 뒤집은 문자열을 저장
    String tmp = new StringBuilder(str).reverse().toString();
    // 뒤집은 문자열과 같은 지 확인
    if (str.equals(tmp))
      answer = "YES";
    return answer;
  }
}
