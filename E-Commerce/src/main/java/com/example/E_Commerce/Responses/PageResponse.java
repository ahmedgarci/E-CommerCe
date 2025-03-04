package com.example.E_Commerce.Responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResponse<T> {

    private List<T> Content;
    private Integer size;
    private Integer totalElements;
    private Integer pageNumber;
    private boolean isFirst;
    private boolean isLast;
    
}
