package kg.apc.cmdtools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FilterResultsInstaller {
    public static void main(String[] argv) throws IOException {
        writeOut("/kg/apc/cmdtools/FilterResults.bat", false);
        writeOut("/kg/apc/cmdtools/FilterResults.sh", true);
    }

    private static void writeOut(String resName, boolean executable) throws IOException {
        File self = new File(FilterResultsInstaller.class.getProtectionDomain().getCodeSource().getLocation().getFile());
        File src = new File(resName);
        String home = self.getParentFile().getParentFile().getParent();
        File dest = new File(home + File.separator + "bin" + File.separator + src.getName());

        InputStream is = FilterResultsInstaller.class.getResourceAsStream(resName);
        Files.copy(is, dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        dest.setExecutable(executable);
    }
}
