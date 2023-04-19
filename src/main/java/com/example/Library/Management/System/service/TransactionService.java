package com.example.Library.Management.System.service;

import com.example.Library.Management.System.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.IssueBookResponseDto;

public interface TransactionService {

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
    public String returnBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
