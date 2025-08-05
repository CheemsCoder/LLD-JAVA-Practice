package org.example.RateLimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiterService service = new RateLimiterService();

        service.registerUser("user_1", "fixed", 5, 10L);
        service.registerUser("user_2", "sliding", 3, 5L);
        service.registerUser("user_3", "token-bucket", 5, 10L);
        service.registerUser("user_4", "leaky-bucket", 3, 4L);

        for (int i = 0; i < 7; i++) {
            System.out.println("User 1 Request " + (i + 1) + " : " + service.allowRequest("user_1"));
            System.out.println("User 2 Request " + (i + 1) + " : " + service.allowRequest("user_2"));
            System.out.println("User 3 Request " + (i + 1) + " : " + service.allowRequest("user_3"));
            System.out.println("User 4 Request " + (i + 1) + " : " + service.allowRequest("user_4"));
            Thread.sleep(1000);
        }
    }
}
