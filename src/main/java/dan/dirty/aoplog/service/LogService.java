package dan.dirty.aoplog.service;

import dan.dirty.aoplog.entity.SysLog;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 15:50 2021/11/16
 * @Modified By:
 */
public interface LogService {
    /**
     * 插入日志
     * @param sysLog
     * @return
     */
    void insertLog(SysLog sysLog);
}
