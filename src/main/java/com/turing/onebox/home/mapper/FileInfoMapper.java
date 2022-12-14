package com.turing.onebox.home.mapper;

import com.turing.onebox.common.model.dto.FileInfo;
import com.turing.onebox.common.model.dto.Folder;
import com.turing.onebox.common.model.dto.RecycledInfo;
import com.turing.onebox.common.model.dto.StarredInfo;
import com.turing.onebox.common.model.result.FileItem;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(FileInfo record);

    FileInfo selectByPrimaryKey(Integer id);

    List<FileInfo> selectAll();

    int updateByPrimaryKey(FileInfo record);


    /**
     * 获取文件列表
     * @param dir 当前文件夹
     * @return
     */
    List<FileInfo> selectFileByDir(Integer dir);

    /**
     * 获取星标文件列表
     * @return
     */
    List<StarredInfo> starredList();

    /**
     * 根据Id修改文件Dir属性
     */
    int updateDirByFileId(Integer sourceId,Integer targetId);
    /**
     * 新建文件夹
     * @param folder
     * @return
     */
    @Insert("insert into folder values(#{id}, #{name}, #{dir}, #{secret}, 0, #{password}, 0)")
    Integer newFolder(Folder folder);



    /**
     * 根据文件夹id删除文件
     */
    @Delete("delete from file where dir = #{dir}")
    Integer deleteFileByDirId(Integer dir);

    /**
     * 获取原先文件名，与重命名相关联
     * @param id
     * @return
     */
    @Select("select `name` from file where id=#{id}")
    String getFileNameById(Integer id);

    /**
     * 文件重命名
     * 如果文件名没变，不做任何操作
     * @param id
     * @param
     * @return
     */
    @Update("update file set name=#{newName} where id=#{id}")
    Integer renameFile(Integer id, String newName);

    /**
     * 获取原先 文件夹 名，与重命名相关联
     * @param id
     * @return
     */
    @Select("select `name` from folder where id=#{id}")
    String getFolderNameById(Integer id);

    /**
     * 重命名文件夹
     * @param newName
     * @return
     */
    @Update("update folder set name=#{newName} where id=#{id}")
    Integer renameFolder(Integer id, String newName);

    /**
     * 根据文件夹名查找文件夹
     */
    @Select("select * from folder where name = #{name} and dir = #{dir};")
    Integer selectFolderByNameAndDir (Folder folder);

    /**
     * 设置星标文件
     * @param fileInfo
     * @return
     */
    @Insert("insert into starred values(#{id}, #{name}, #{dir}, #{type}, #{ext}, #{size}, #{realPath}, #{inRecycled}, #{createTime})")
    Integer starredFile(FileInfo fileInfo);

    /**
     * 删除星标文件记录
     */
    @Delete("delete from starred where id = #{id}")
    Integer unStarredFile(Integer id);

    /**
     * @Author HuangYuhan
     * @param fileName
     * @param dir
     * @return
     */
    int selectFileByFileNameAndDir(@Param("fileName") String fileName,@Param("dir") Integer dir);

    List<FileInfo> getFileInfoByDirId(Integer id);

    int editFileRecycledByFileId(Integer id);

    int editFileRecycledByFolderId(Integer id);
    List<FileInfo> selectFileByType(String type);
}