

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.prefs.Preferences;

public class Os {
public static void main(String[]args){
    String str = System.getProperty("os.name");

    Map<String, String> map1 = null;
    try {
        map1 = RegeditUtil.valuesForPath("Software\\Classes\\Local Settings\\Software\\Microsoft\\Windows\\Shell\\MuiCache");
        for(String key : map1.keySet()) {
            if (!key.contains("$") && !key.contains("desktop")) {
                String str1 = key.substring(0, key.indexOf(".FriendlyAppName"));
                System.out.println(str1);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        }
        }

@SuppressWarnings("all")
class RegeditUtil {

//    private static final Logger logger = LoggerFactory.getLogger(RegeditUtil.class);

    private static final int REG_SUCCESS = 0;
    private static final int KEY_READ = 0x20019;
    //    public static final int HKEY_CLASSES_ROOT = 0x80000000;
    public static final int HKEY_CURRENT_USER = 0x80000001;
    //    public static final int HKEY_LOCAL_MACHINE = 0x80000002;
//    private static final String CURRENT_USER = "HKEY_CURRENT_USER";
    private static Preferences userRoot = Preferences.userRoot();
    private static Class<? extends Preferences> userClass = Preferences.userRoot().getClass();
    private static Method regOpenKey = null;
    private static Method regCloseKey = null;
    private static Method regQueryValueEx = null;
    private static Method regEnumValue = null;
    private static Method regQueryInfoKey = null;

    static {
        try {
            regOpenKey = userClass.getDeclaredMethod("WindowsRegOpenKey", new Class[] {int.class, byte[].class, int.class});
            regOpenKey.setAccessible(true);
            regCloseKey = userClass.getDeclaredMethod("WindowsRegCloseKey", new Class[] {int.class});
            regCloseKey.setAccessible(true);
            regQueryValueEx = userClass.getDeclaredMethod("WindowsRegQueryValueEx", new Class[] {int.class, byte[].class});
            regQueryValueEx.setAccessible(true);
            regEnumValue = userClass.getDeclaredMethod("WindowsRegEnumValue", new Class[] {int.class, int.class, int.class});
            regEnumValue.setAccessible(true);
            regQueryInfoKey = userClass.getDeclaredMethod("WindowsRegQueryInfoKey1", new Class[] {int.class});
            regQueryInfoKey.setAccessible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> valuesForPath(String path)
            throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException {
        return valuesForPath(userRoot, HKEY_CURRENT_USER, path);
    }

    // 检索指定路径的所有数据(以键和值的形式)
    private static Map<String,String> valuesForPath(Preferences root, int hkey, String path)
            throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException {
        HashMap<String, String> results = new HashMap<String,String>();
        int[] handles = (int[]) regOpenKey.invoke(root, new Object[] {new Integer(hkey), toCstr(path), new Integer(KEY_READ)});
        if (handles[1] != REG_SUCCESS)
            throw new IllegalArgumentException("The system can not find the specified path: '"+HKEY_CURRENT_USER+"\\"+path+"'");
        int[] info = (int[]) regQueryInfoKey.invoke(root, new Object[] {new Integer(handles[0])});
        int count = info[2];                            // Fixed: info[0] was being used here
        int maxlen = info[4];                           // while info[3] was being used here, causing wrong results
        for(int index=0; index<count; index++) {
            byte[] valb = (byte[]) regEnumValue.invoke(root, new Object[] {new Integer(handles[0]), new Integer(index), new Integer(maxlen + 1)});
            String vald = parseValue(valb);
            if (vald.contains("dbeaver.exe")) {
                if(valb == null || vald.isEmpty())
                    return queryValuesForPath(hkey, path);
                results.put(vald, valueForKey(root, hkey, path, vald));
            }
        }
        regCloseKey.invoke(root, new Object[] {new Integer(handles[0])});
        return results;
    }

    private static String valueForKey(Preferences root, int hkey, String path, String key)
            throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException {
        int[] handles = (int[]) regOpenKey.invoke(root, new Object[] {new Integer(hkey), toCstr(path), new Integer(KEY_READ)});
        if (handles[1] != REG_SUCCESS)
            throw new IllegalArgumentException("The system can not find the specified path: '"+HKEY_CURRENT_USER+"\\"+path+"'");
        byte[] valb = (byte[]) regQueryValueEx.invoke(root, new Object[] {new Integer(handles[0]), toCstr(key)});
        regCloseKey.invoke(root, new Object[] {new Integer(handles[0])});
        return (valb != null ? parseValue(valb) : queryValueForKey(hkey, path, key));
    }

    private static String queryValueForKey(int hkey, String path, String key) throws IOException {
        return queryValuesForPath(hkey, path).get(key);
    }

    private static Map<String, String> queryValuesForPath(int hkey, String path) throws IOException {
        String line;
        StringBuilder builder = new StringBuilder();
        Map<String, String> map = new HashMap<String, String>();
        Process process = Runtime.getRuntime().exec("reg query \""+HKEY_CURRENT_USER+"\\" + path + "\"");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while((line = reader.readLine()) != null) {
            if(!line.contains("REG_"))
                continue;
            StringTokenizer tokenizer = new StringTokenizer(line, " \t");
            while(tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if(token.startsWith("REG_"))
                    builder.append("\t ");
                else
                    builder.append(token).append(" ");
            }
            String[] arr = builder.toString().split("\t");
            map.put(arr[0].trim(), arr[1].trim());
            builder.setLength(0);
        }
        return map;
    }

    private static byte[] toCstr(String str) {
        if(str == null)
            str = "";
        return (str += "\0").getBytes();
    }

    private static String parseValue(byte buf[]) {
        if(buf == null)
            return null;
        String ret = new String(buf);
        if(ret.charAt(ret.length()-1) == '\0')
            return ret.substring(0, ret.length()-1);
        return ret;
    }
}
