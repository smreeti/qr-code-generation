package com.smriti.qrcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.smriti.qrcode.utils.QRUtils.qrHeight;
import static com.smriti.qrcode.utils.QRUtils.qrWidth;

/**
 * @author smriti on 2019-10-10
 */

@Service
public class QRCodeService {

    public void generateQRCode() throws IOException {
        String text = "test QR code";
        String name = "smriti";

        String path = getQRPath(name);
        Files.createDirectories(Paths.get(path));
        try {
            generateQRCodeImage(text, qrWidth, qrHeight, path);
        } catch (Exception e) {
            System.out.println("Unable to generate QR Code, WriterException :: " + e.getMessage());
        }
    }

    private String getQRPath(String name) {
        return "./QR/" + name + ".png";
    }

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws Exception {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
