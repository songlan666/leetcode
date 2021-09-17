import java.io.File;
import java.util.HashMap;

public class Path {
    public static void main(String[] args) {
//        String s = "/city.josn";
//        File file = new File(this.getClass().getResource(s).getPath());
        String[] path = findFile("win.zip");
        System.out.println(path[0]);
        System.out.println(path[1]);

    }

    private static String[] findFile(String name) {
        File file = new File(".//untitled1");

        File[] tempFile = file.listFiles();
        String[] path = new String[2];
        for(int i = 0; i < tempFile.length; i++){
            if(tempFile[i].getName().startsWith("dbeaver")){
                if(tempFile[i].getName().endsWith(name)){
                    path[0] = tempFile[i].getName();
                    path[1] = tempFile[i].getPath();
                    return path;
                }
            }
        }
        return null;
    }
}
