package com.koe.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("Pod列表")
public class GetPodsReq {
    @ApiModelProperty("pod名称")
    private List<String> name;

    @ApiModelProperty("命名空间")
    private List<String> namespace;
    @ApiModelProperty("集群")
    private List<String> cluster;
    @ApiModelProperty("状态")
    private List<String> status;


    @ApiModelProperty("页码")
    private Integer pageNumber=1;
    @ApiModelProperty("页展示数量")
    private Integer pageSize=10;
}
