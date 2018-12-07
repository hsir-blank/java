import java.io.File;

public class TestFile {
    public static void main(String[] args) {

        rdirs("D:\\java_t");

    }

    public static void rdirs(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            File[] files = file.listFiles();  // 返回路径名接口
            if (files.length == 0) {
                System.out.println("空文件夹");
                return;
            } else {
                for (File f : files) {
                    if (f.isDirectory()) {
                        System.out.println(f.getAbsolutePath());
                        rdirs(f.getAbsolutePath());
                    } else {
                        System.out.println(f.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在");
        }
    }
}
