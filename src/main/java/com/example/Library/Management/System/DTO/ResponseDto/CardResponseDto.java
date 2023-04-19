package com.example.Library.Management.System.DTO.ResponseDto;

import com.example.Library.Management.System.enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardResponseDto {

    private int id;
    private Date issueDate;
    private Date updatedOn;
    private CardStatus status;
    private String validTill;
}
