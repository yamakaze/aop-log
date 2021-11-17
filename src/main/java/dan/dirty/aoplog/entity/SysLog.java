package dan.dirty.aoplog.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 15:37 2021/11/16
 * @Modified By:
 */
@Data
public class SysLog {
    private Long oid;
    private String tableName;
    private Integer tableId;
    private String operType;
    private Long userId;
    private Timestamp operTime;
}
