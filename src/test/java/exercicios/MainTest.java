package exercicios;

import org.junit.Test;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testMainExecutesWithoutException() {
        Main.main(new String[]{});
    }

    @Test
    public void testPdfIsGenerated() {
        // Executa o Main para garantir a geração do PDF
        Main.main(new String[]{});

        // Monta o nome do arquivo conforme o padrão utilizado no projeto
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd"));
        String nomeArquivo = "doc/" + data + "_Christian_Mulato_Resultado.pdf";
        File pdf = new File(nomeArquivo);

        assertTrue("O PDF de saída não foi gerado!", pdf.exists() && pdf.isFile() && pdf.length() > 0);
    }
}