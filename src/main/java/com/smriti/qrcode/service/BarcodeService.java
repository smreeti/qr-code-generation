package com.smriti.qrcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.smriti.qrcode.utils.QRUtils.*;

/**
 * @author smriti on 2019-10-10
 */
@Service
public class BarcodeService {
    public void generateBarcode() {

        String text = "Name: Smriti, Address: Bhaktapur";
        String name = "Smriti";

        String path = getBarcodePath(name);
        try {
            Files.createDirectories(Paths.get(path));
            generateBarcodeImage(text, barCodeHeight, barCodeWidth, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateBarcodeImage(String text, int width, int height, String filePath) throws IOException,
            WriterException {

        BitMatrix bitMatrix = new Code128Writer().encode(text, BarcodeFormat.CODE_128, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    private String getBarcodePath(String name) {
        return "./Barcode/" + name + ".png";
    }
}
