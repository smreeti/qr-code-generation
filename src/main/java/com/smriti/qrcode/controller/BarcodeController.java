package com.smriti.qrcode.controller;

import com.smriti.qrcode.service.BarcodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author smriti on 2019-10-10
 */
@RestController
public class BarcodeController {

    private final BarcodeService barcodeService;

    public BarcodeController(BarcodeService barcodeService) {
        this.barcodeService = barcodeService;
    }

    @GetMapping("/barcode")
    public void  generateBarCode() {
        barcodeService.generateBarcode();
    }
}
