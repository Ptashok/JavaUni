package lab1.initialization;

public enum FileName {
    MC("resources/data/MC.txt"),
    MX("resources/data/MX.txt"),
    MD("resources/data/MD.txt"),
    B("resources/data/B.txt"),
    D("resources/data/D.txt");

    private final String fileName;

    FileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
