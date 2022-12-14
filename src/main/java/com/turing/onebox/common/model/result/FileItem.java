package com.turing.onebox.common.model.result;

import com.turing.onebox.common.model.dto.FileInfo;
import com.turing.onebox.common.model.dto.Folder;
import com.turing.onebox.common.model.dto.StarredInfo;
import lombok.Data;

/**
 * 文件查询结果类
 */
@Data
public class FileItem {

    private Integer id;

    private String name;

    private String ext;

    private Integer size;

    private String type; // audio video folder sercetFolder

    private Integer star;

    private String createTime;

    public FileItem(){}

    public FileItem(FileInfo fileInfo){
        this.id = fileInfo.getId();
        this.name = fileInfo.getName();
        this.ext = fileInfo.getExt();
        this.size = fileInfo.getSize();
        this.type = fileInfo.getType();
        this.star = fileInfo.getStar();
        this.createTime = fileInfo.getCreateTime();
    }

    public FileItem(Folder folder){
        this.id = folder.getId();
        this.name = folder.getName();
        this.ext = null;
        this.size = null;
        this.createTime = folder.getCreateTime();
        if (folder.getSecret() == 0){
            this.type = "folder";
        } else {
            this.type = "secretFolder";
        }
        this.star = folder.getStar();
    }

    public FileItem(StarredInfo fileInfo) {
        this.id = fileInfo.getId();
        this.name = fileInfo.getName();
        this.ext = fileInfo.getExt();
        this.size = fileInfo.getSize();
        this.type = fileInfo.getType();
        this.star = 1;
    }
}
