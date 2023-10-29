package com.example.response;

import java.util.List;

public class PaginationResponseDto {
    private Integer page;
    private Integer pageSize;
    private Integer totalElements;
    private List<CarResponseDto> items;

    /*      CONSTRUCTORS     */
    public PaginationResponseDto() {

    }

    public PaginationResponseDto(Integer page, Integer pageSize, Integer totalElements, List<CarResponseDto> items) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.items = items;
    }

    /*      GETTERS     */
    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public List<CarResponseDto> getItems() {
        return items;
    }

    /*      SETTERS     */
    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public void setItems(List<CarResponseDto> items) {
        this.items = items;
    }

}
