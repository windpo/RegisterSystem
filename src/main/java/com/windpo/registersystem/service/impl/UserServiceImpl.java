package com.windpo.registersystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.windpo.registersystem.common.enums.ErrorEnum;
import com.windpo.registersystem.entity.Student;
import com.windpo.registersystem.entity.StudentTeamManager;
import com.windpo.registersystem.entity.Team;
import com.windpo.registersystem.exception.LocalRunTimeException;
import com.windpo.registersystem.mapper.StudentMapper;
import com.windpo.registersystem.mapper.StudentTeamManagerMapper;
import com.windpo.registersystem.mapper.TeamMapper;
import com.windpo.registersystem.service.UserService;
import com.windpo.registersystem.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import response.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 风之诗
 * @version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    StudentMapper studentMapper;


    @Override
    @Transactional
    public Map<String,Object> register(List<Student> studentList) {
        String uuid = UUIDUtil.getUUID();
        //判断输入信息是否合理(验证学号是否有重复)
        ArrayList<String> sids = new ArrayList<>();
        for (Student s :
                studentList) {
            sids.add(s.getStudentId());
        }
        HashSet<String> set = new HashSet<>(sids);
        if(set.size()!=sids.size()){
            throw new LocalRunTimeException(ErrorEnum.ERROR2);
        }

        //遍历传入的学生
        for (Student s :
                studentList) {
            //判断是否有已经加入的学生，若存在，则该人员重复参加,报错
            Student stuRes = studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getStudentId,s.getStudentId()));
            if(stuRes!=null){
                throw new LocalRunTimeException(ErrorEnum.ERROR1);
            }
            //插入学生记录（事务,方法执行结束插入完成）
            s.setTeamId(uuid);
            studentMapper.insert(s);
        }
        return getResultMap(Result.success(null));
    }

    @Override
    public void download(String message, HttpServletResponse response) {
        try {

            String path = null;
            path = "";
            if(message.equals("新生试题")){
                path="src/main/resources/static/ContestMessage.txt";
            } else if (message.equals("其它试题")) {
                path="src/main/resources/static/FreshmanTestQuestions.txt";
            } else if (message.equals("比赛信息")) {
                path="src/main/resources/static/OtherTestQuestions.txt";
            }

            //读取本地文件
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            //返回本地文件

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            String fileName = file.getName();
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String,Object> getResultMap(Result result){
        HashMap<String, Object> res = new HashMap<>();
        res.put("success",result.getSuccess());
        res.put("errCode",result.getErrCode());
        res.put("errMsg",result.getErrMsg());
        res.put("data",result.getData());
        return res;
    }

}
