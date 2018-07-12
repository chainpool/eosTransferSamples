package client.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lxg on 2017/9/28.
 */
public class LLogger {
    private Logger logger;

    public LLogger(Class clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public LLogger(String name) {
        logger = LoggerFactory.getLogger(name);
    }

    public String getName() {
        return logger.getName();
    }

    public void trace(String string) {
        logger.trace(getExpendString() + string);
    }

    public void trace(String string, Object... objects) {
        logger.trace(getExpendString() + string, objects);
    }

    public void debug(String string) {
        logger.debug(getExpendString() + string);
    }

    public void debug(String string, Object... objects) {
        logger.debug(getExpendString() + string, objects);
    }

    public void info(String string) {
        logger.info(getExpendString() + string);
    }

    public void info(String string, Object... objects) {
        logger.info(getExpendString() + string, objects);
    }

    public void error(String string) {
        logger.error(getExpendString() + string);
    }

    public void error(String string, Object... objects) {
        logger.error(getExpendString() + string, objects);
    }

    public void warn(String string) {
        logger.warn(getExpendString() + string);
    }

    public void warn(String string, Object... objects) {
        logger.warn(getExpendString() + string, objects);
    }

    public String getExpendString() {
        return "uuid:" + ThreadLocalUtils.get() + " ";
    }
}
