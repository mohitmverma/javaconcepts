package test;

public class Main {
    public static void main(String[] args) {

        RateLimiter rateLimiter = new RateLimiter(1); // Set the maximum QPS to 1

        // Test case 1
        System.out.println(rateLimiter.can_execute(0));    // 0
        System.out.println(rateLimiter.can_execute(600));  // 400
        System.out.println(rateLimiter.can_execute(1200)); // 0

        rateLimiter = new RateLimiter(2); // Set the maximum QPS to 2

        // Test case 2
        System.out.println(rateLimiter.can_execute(0));    // 0
        System.out.println(rateLimiter.can_execute(600));  // 0
        System.out.println(rateLimiter.can_execute(1200));


        rateLimiter = new RateLimiter(3); // Set the maximum QPS to 2

        // Test case 2
        System.out.println(rateLimiter.can_execute(100));    // 0
        System.out.println(rateLimiter.can_execute(500));  // 0
        System.out.println(rateLimiter.can_execute(900));
        System.out.println(rateLimiter.can_execute(1100));    // 0
        System.out.println(rateLimiter.can_execute(1500));  // 0
        System.out.println(rateLimiter.can_execute(1900));
        System.out.println(rateLimiter.can_execute(2100));    // 0
        System.out.println(rateLimiter.can_execute(2500));  // 0
        System.out.println(rateLimiter.can_execute(2900));

    }
}
