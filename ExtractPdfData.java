import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class ExtractPdfData {
    public static void main(String[] args) throws IOException {
        PDFTextStripper textStripper = new PDFTextStripper();
        textStripper.setStartPage(1);
        textStripper.setStartPage(3);

        PDDocument pdDocument = PDDocument.load(new File("doc.pdf"));
        System.out.println(textStripper.getText(pdDocument));
    }
}
