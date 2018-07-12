package client.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by lxg on 2017/9/28.
 */
public class LLoggerFactory {
    private static final ConcurrentMap<Class, LLogger> loggers = new ConcurrentHashMap<>();
    private static final ConcurrentMap<String, LLogger> loggerName = new ConcurrentHashMap<>();

    public static LLogger getLogger(Class clazz) {
        if (loggers.containsKey(clazz)) {
            return loggers.get(clazz);
        } else {
            LLogger logger = new LLogger(clazz);
            loggers.put(clazz, logger);
            return logger;
        }
    }

    public static LLogger logger(Class clazz) {
        return getLogger(clazz);
    }

    public static LLogger getLogger(String name) {
        if (loggerName.containsKey(name)) {
            return loggerName.get(name);
        } else {
            LLogger logger = new LLogger(name);
            loggerName.put(name, logger);
            return logger;
        }
    }
}
