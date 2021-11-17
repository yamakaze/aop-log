package dan.dirty.aoplog.dao;

import dan.dirty.aoplog.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 10:32 2021/11/17
 * @Modified By:
 */
@Mapper
@Repository
public interface LogMapper {
    /**
     * 插入操作日志
     * @param sysLog
     * @return 受影响行数
     */
    Integer insertLog(SysLog sysLog);
}
