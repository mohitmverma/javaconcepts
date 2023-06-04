package test;

public class RateLimiter {
    private int maxQPS;                     // Maximum queries per second
    private int lastTimestamp;              // Timestamp of the last call to can_execute
    private int count;

    public RateLimiter(int maxQPS) {
        this.maxQPS = maxQPS;
        this.lastTimestamp = -1;            // Initialize with an invalid timestamp
        this.count  =0;
    }

    public int can_execute(int request_relative_millis) {
//        int currentTimestamp = request_relative_millis / 1000; // Convert to seconds
//
//        // Check if the current call violates the rate limit
//        if (lastTimestamp != -1 && currentTimestamp == lastTimestamp) {
//            if (currentTimestamp * maxQPS <= request_relative_millis) {
//                return request_relative_millis % maxQPS;
//            } else {
//                return (currentTimestamp + 1) * maxQPS - request_relative_millis;
//            }
//        }
//
//        lastTimestamp = currentTimestamp;   // Update the last timestamp


        int curTimestamp = request_relative_millis;

        if(curTimestamp/1000 != lastTimestamp/1000) {
            lastTimestamp = curTimestamp;
            count=0;
            return 0;
        } else {
            lastTimestamp = curTimestamp;
            count = count+1;
            if(count>maxQPS) {
                return 1000-curTimestamp%1000;
            }else {
                return 0;
            }
        }

       // return 0;                           // The request can be executed immediately
    }
}
