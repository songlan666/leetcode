

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//public class RegistryUtil {
//    public static void main(String[] args) {
//        String commond = "reg query HKEY_CLASSES_ROOT\\Local Settings\\Software\\Microsoft\\Windows\\Shell\\MuiCache";
//        try {
//            Process ps = null;
//            ps = Runtime.getRuntime().exec(commond);
//            ps.getOutputStream().close();
//            InputStreamReader i = new InputStreamReader(ps.getInputStream());
//            String line;
//            BufferedReader ir = new BufferedReader(i);
//            while ((line = ir.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册表操作工具类
 * @author 北北
 * @date 2019年6月19日下午8:21:02
 */
public class RegistryUtil {
//    private static Logger logger = LoggerFactory.getLogger(RegistryUtil.class);
    /**
     * <pre>
     * 读取注册表指定节点所有的键值对
     * </pre>
     * @author 北北
     * @date 2019年6月19日下午8:43:56
     * @param nodePath
     * @return
     */
    public static Map<String, String> readNode(String nodePath) {
        Map<String, String> regMap = new HashMap<>();
        try {
            Process process = Runtime.getRuntime().exec("reg query " + nodePath);
            process.getOutputStream().close();
            InputStreamReader isr = new InputStreamReader(process.getInputStream());
            String line = null;
            BufferedReader ir = new BufferedReader(isr);
            while ((line = ir.readLine()) != null) {
                String[] arr = line.split(" ");
                if(arr.length != 4){
                    continue;
                }
                regMap.put(arr[1], arr[3]);
            }
            process.destroy();
        } catch (IOException e) {
//            logger.error("读取注册表失败, nodePath: " + nodePath, e);
            e.printStackTrace();
        }
        return regMap;
    }
    /**
     * <pre>
     * 读取注册表指定节点指定key的值
     * </pre>
     * @author 北北
     * @date 2019年6月19日下午8:43:24
     * @param nodePath
     * @param key
     * @return
     */
    public static String readValue(String nodePath, String key) {
        Map<String, String> regMap = readNode(nodePath);
        return regMap.get(key);
    }
    public static void main(String[] args) {
        String paramValue = RegistryUtil.readValue("reg query HKEY_CLASSES_ROOT\\Local Settings\\Software\\Microsoft\\Windows\\Shell\\MuiCache", "C:\\users\\32163\\desktop\\dbeaver\\dbeaver.exe.FriendlyAppName");
        System.out.println(paramValue);
    }
}