package FileUtils;

import java.io.IOException;
import java.nio.file.*;

public class RenameFolders {

    /**
     * 对指定目录下的文件夹进行重命名
     *
     * @param directoryPath 指定目录的路径
     */
    public static void renameFolders(String directoryPath) {
        // 将路径转换为Path对象
        Path directory = Paths.get(directoryPath);

        // 检查路径是否存在且是一个目录
        if (!Files.exists(directory) || !Files.isDirectory(directory)) {
            System.out.println("指定路径不存在或不是一个目录！");
            return;
        }

        // 获取目录下的所有文件和文件夹
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path path : stream) {
                // 只处理文件夹
                if (Files.isDirectory(path)) {
                    String folderName = path.getFileName().toString();
                    String newFolderName = renameFolderName(folderName);
                    if (!newFolderName.equals(folderName)) {
                        // 构造新的文件夹路径
                        Path newPath = directory.resolve(newFolderName);
                        // 重命名文件夹
                        Files.move(path, newPath);
                        System.out.println("重命名：" + folderName + " -> " + newFolderName);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据规则重命名文件夹名
     *
     * @param folderName 原始文件夹名
     * @return 新的文件夹名
     */
    private static String renameFolderName(String folderName) {
        // 忽略前3个字符
        String prefix = folderName.substring(0, Math.min(3, folderName.length()));
        String suffix = folderName.substring(Math.min(3, folderName.length()));

        // 使用正则表达式匹配大写字母，并在其前插入下划线（如果之前不是下划线）
        String newSuffix = suffix.replaceAll("(?<!_)([A-Z])", "_$1");

        // 返回拼接后的文件夹名
        return prefix + newSuffix;
    }

    public static void main(String[] args) {
        // 示例：指定目录路径
        String directoryPath = "LeetCode/go";
        renameFolders(directoryPath);
    }
}