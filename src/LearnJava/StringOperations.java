package LearnJava;

public class StringOperations {
    public static void main(String args[]) {
        String csrfToken = "csrf-token=9db318cc-902f-450c-be7c-d2fb069c67c5; path=/; domain=qa.mgmresorts.com";
        System.out.println(csrfToken.substring(csrfToken.toString().indexOf("csrf-token=") + 11, csrfToken.indexOf(";", 1)));
    }
}