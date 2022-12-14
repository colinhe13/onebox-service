package com.turing.onebox.common.model.dto;

import lombok.Data;

/**
 * @ClassName StarredInfo
 * @Description TODO
 * @Author Colin
 * @Date 2022/8/13 17:04
 * @Version 1.0
 */
@Data
public class StarredInfo {

    private Integer id;

    private String name;

    private Integer dir;

    private String type;

    private String ext;

    private Integer size;

    private String realPath;

    private Integer inRecycled;

    private String createTime;

}
