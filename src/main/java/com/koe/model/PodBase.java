package com.koe.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@Table(name = "pod_base")
public class PodBase implements Serializable {
    private static final long serialVersionUID = -8723572241993981374L;
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * pod名称
     */
    private String name;

    /**
     * 命名空间
     */
    private String namespace;

    /**
     * 集群名称
     */

    private String clusterName;

    /**
     * 节点名称
     */

    private String nodeIp;

    /**
     * pod所属应用名
     */

    private String appName;

    /**
     * pod状态
     */
    private String status;

    /**
     * 创建时间
     */

    private Long creationTime;
}
