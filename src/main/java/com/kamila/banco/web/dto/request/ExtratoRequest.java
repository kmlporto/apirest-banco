package com.kamila.banco.web.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ExtratoRequest implements Serializable {

    @ApiModelProperty(position = 1, required = true, example = "2020-01-13")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;

    @ApiModelProperty(position = 2, required = true, example = "2021-01-13")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFim;

}
