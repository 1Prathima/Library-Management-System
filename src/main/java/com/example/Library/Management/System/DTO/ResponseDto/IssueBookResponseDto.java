package com.example.Library.Management.System.DTO.ResponseDto;

import com.example.Library.Management.System.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {
    private String transactionNumber;
    private TransactionStatus transactionStatus;
    private String bookTitle;
}
