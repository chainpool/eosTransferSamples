package client.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.slf4j.LoggerFactory.getLogger;


/**
 * Created by lxg on 2016/10/21.
 */
public class Utils {
    private static final Logger logger = getLogger(Utils.class);
    public static final ObjectMapper mapper = new ObjectMapper();
    public static final String FULL_DATE = "yyyyMMddHHmmss";
    private static final Random rand = new Random();
    private static final Gson gson = new Gson();
    private static final int DEFAULT_SEED = 10000;
    public static SimpleDateFormat fullDateFormat_no_xxx = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private static final Random random = new Random();
    private static final String pattern_regex_float = "(-?\\d+.?\\d+)";


    public static String toJson(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 获取完整日期
     *
     * @return
     */
    public static String getFullDate() {
        return new SimpleDateFormat(FULL_DATE).format(new Date());
    }

    /**
     * 生成一个随机数字，在种子范围内
     *
     * @param seed
     * @return
     */
    public static int getRandNumber(int seed) {
        return rand.nextInt(seed);
    }

    /**
     * 生成一个随机数字,在10000范围内
     *
     * @return
     */
    public static int getRandNumber() {
        return getRandNumber(DEFAULT_SEED);
    }

    /**
     * 生成一个随机数字, 大于等于seed, 小于等于seed+rand
     *
     * @param seed
     * @param rand
     * @return
     */
    public static int getRandNumber(int seed, int rand) {
        return seed + getRandNumber(rand);
    }

    public static String toJsonByGson(Object o) {
        return gson.toJson(o);
    }

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     * @throws java.io.IOException
     */
    public final static String getIpAddress(HttpServletRequest request) throws IOException {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }

    public static String getCode() {
        return String.format("%04d", random.nextInt(9999));
    }


    public static String match(String patternRegex, String source) {
        Pattern pattern = Pattern.compile(patternRegex);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static float matchFloat(String source) {
        String result = match(pattern_regex_float, source);
        if (result != null) {
            return Float.parseFloat(result);
        }
        return 0;
    }

    public static Date parse(SimpleDateFormat format, String date) {
        try {
            return format.parse(date);
        } catch (ParseException e) {
            logger.error("parse is {}", e);
        }
        return null;
    }

    public static String formatEosBalance(double balance) {
        DecimalFormat fnum = new DecimalFormat("##0.0000");
        return fnum.format(balance);
    }

    public static String getEosBalance(double balance) {
        return formatEosBalance(balance) + " EOS";
    }
}

