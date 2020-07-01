package com.example.demo.service;

import com.example.demo.entry.Volunteer;
import com.example.demo.mapper.VolunteerMapper;
import com.example.demo.util.ResultReturn;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.ReadResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-01
 */
@Service
public class VolunteerService {

    @Resource
    private VolunteerMapper volunteerMapper;

    public ResultReturn add(Volunteer volunteer){
        if (volunteer.getName() == null || "".equals(volunteer.getName())){
            return ResultReturnUtil.fail("名字不能为空");
        }

        Volunteer temp = volunteerMapper.selectByUserName(volunteer.getName());
        if (temp != null)
            return ResultReturnUtil.fail("该义工信息已存在");

        volunteerMapper.add(volunteer);
        return ResultReturnUtil.success("添加成功");
    }

    public ResultReturn update(Volunteer volunteer){
        if (volunteer.getName() == null || "".equals(volunteer.getName())){
            return ResultReturnUtil.fail("名字不能为空");
        }

        Volunteer temp = volunteerMapper.selectByUserName(volunteer.getName());
        if (temp == null)
            return ResultReturnUtil.fail("该义工信息不存在");

        volunteerMapper.update(volunteer);
        return ResultReturnUtil.success("修改成功");
    }

    public ResultReturn delete(int id){

        Volunteer volunteer = volunteerMapper.selectById(id);
        if (volunteer == null){
            return ResultReturnUtil.fail("该义工信息不存在");
        }

        volunteerMapper.delete(id);

        return ResultReturnUtil.success("删除成功");
    }

    public ResultReturn getAll(){

        List<Volunteer> volunteers = volunteerMapper.getAll();
        return ResultReturnUtil.success("查询成功", volunteers);
    }
}
