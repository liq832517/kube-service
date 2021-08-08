package com.koe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "pod_detail")
public class PodDetail implements Serializable {
    private static final long serialVersionUID = -8723572241993981374L;
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * pod IP
     */

    private String podIp;

    /**
     * 重启策略:Always,OnFailure,Never
     */

    private String restartPolicy;

    /**
     * pod重启次数
     */

    private Integer restartCount;

    /**
     * 数据卷
     */
    private String volumes;

    private String version;
    private String ready;
    private String replicas;
    private String replicas_ready;
    private String node_selector;
    private String toleration;
    private String controller_kind;
    private String pod_ip;
}
