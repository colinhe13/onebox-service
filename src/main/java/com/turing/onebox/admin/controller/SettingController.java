package com.turing.onebox.admin.controller;

import cn.hutool.json.JSONArray;
import com.turing.onebox.admin.service.SettingService;
import com.turing.onebox.common.model.result.ReSettingItem;
import com.turing.onebox.common.model.result.SettingItem;
import com.turing.onebox.common.utils.AjaxJson;
import com.turing.onebox.common.model.dto.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/setting")
@CrossOrigin
public class SettingController {

    @Autowired
    private SettingService settingService;

    /**
     * 获取文件分类表
     * @return AjaxJson<List<SettingItem>>
     */
    @PostMapping("/class")
    public AjaxJson<List<ClassInfo>> list(){
        List<ClassInfo> classInfoList = settingService.getClassList();
        return AjaxJson.getSuccessData(classInfoList);
    }

    /**
     * 保存设置
     */
    @PostMapping("/save")
    public AjaxJson<?> saveAllSetting(@RequestBody Map<String,Object> map){
        System.out.println(map);
        List<ClassInfo> classInfos = new ArrayList<>();
        for (String key: map.keySet()){
            List<String> classes = (List<String>) map.get(key);
            for (String ext:classes){
                classInfos.add(new ClassInfo(key,ext));
            }
        }

        if (settingService.updateClassList(classInfos)){
            return AjaxJson.getSuccess("保存成功");
        } else {
            return AjaxJson.getError("保存失败");
        }
    }

    // 每次修改设置后前端都返回整个文件分类表
    // }

//    /**
//     * 添加后缀
//     */
//   @P
//      ostMapping("/ext/add")
//    public AjaxJson<?> addExt(Integer id, String newExt){
//        return null;
//    }
//
//    /**
//     * 删除后缀
//     */
//    @PostMapping("/ext/delete")
//    public AjaxJson<?> deleteExt(Integer id, String newExt){
//        return null;
//    }


}
