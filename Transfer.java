package com.example.zelletransfer.controller;

import com.example.zelletransfer.model.Transfer;
import com.example.zelletransfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<Transfer> initiateTransfer(@Valid @RequestBody Transfer transfer) {
        Transfer savedTransfer = transferService.initiateTransfer(transfer);
        return ResponseEntity.ok(savedTransfer);
    }
}