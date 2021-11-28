import IFileRepository;

public class FileServer {
    private readonly IFileRepository repostory;
    private readonly FileSystemSavingOptions savingOptions;
}

public class TestFileSystem {
    public static void main(String[] args) {
        System.out.println("Working");
    }
}
