package client.util;

public class ThreadLocalUtils {

	private static ThreadLocal<String> uuidLocal = new ThreadLocal<>();
    private static ThreadLocal<String> userLocal = new ThreadLocal<String>() {
        public String initialValue() {
            return null;
        }
    };

    public static String get() {
        return uuidLocal.get();
    }
    
    public static void remove(){
    	uuidLocal.remove();
    }
    
    public static void set(String uuid){
    	uuidLocal.set(uuid);
    }

    public static String getUserId() {
        return userLocal.get();
    }

    public static void removeUserId(){
        userLocal.remove();
    }

    public static void setUserId(String userId){
        userLocal.set(userId);
    }
}
