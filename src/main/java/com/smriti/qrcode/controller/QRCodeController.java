package com.smriti.qrcode.controller;

import com.smriti.qrcode.service.QRCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author smriti on 2019-10-10
 */
@RestController
public class QRCodeController {

    private final QRCodeService qrCodeService;

    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("/qr")
    public void  generateQRCode() throws IOException {
        qrCodeService.generateQRCode();
    }
}
