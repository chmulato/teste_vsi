package exercicios;

import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testMainExecutesWithoutException() {
        Main.main(new String[]{});
    }

    @Test
    public void testPdfIsGenerated() {
        // Execute o Main (caso não tenha sido executado antes)
        Main.main(new String[]{});
        // Verifica se o PDF foi gerado no local esperado
        File pdf = new File("doc/saida.pdf");
        assertTrue("O PDF de saída não foi gerado!", pdf.exists() && pdf.isFile() && pdf.length() > 0);
    }
}