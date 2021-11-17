package dan.dirty.aoplog.service.impl;

import dan.dirty.aoplog.dao.LogMapper;
import dan.dirty.aoplog.entity.SysLog;
import dan.dirty.aoplog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 14:10 2021/11/17
 * @Modified By:
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void insertLog(SysLog sysLog) {
        if (logMapper.insertLog(sysLog) > 0){
            System.out.println("日志插入成功");
            return;
        }
        System.out.println("日志插入失败");
    }
}
