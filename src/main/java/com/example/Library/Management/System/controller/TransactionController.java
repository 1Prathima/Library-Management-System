package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Library.Management.System.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
        return transactionService.issueBook(issueBookRequestDto);
    }

    @DeleteMapping("/return")
    public String returnBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
        return transactionService.returnBook(issueBookRequestDto);
    }
}
