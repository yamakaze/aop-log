package dan.dirty.aoplog.annotation;

import dan.dirty.aoplog.enums.IdNameEnum;
import dan.dirty.aoplog.enums.TableNameEnum;
import dan.dirty.aoplog.enums.TypeNameEnum;

import java.lang.annotation.*;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 10:09 2021/11/17
 * @Modified By:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 操作方式 默认unknown
     */
    TypeNameEnum type() default TypeNameEnum.UNKNOWN;
    /**
     * 操作的表名 默认unknown
     */
    TableNameEnum table() default TableNameEnum.UNKNOWN;
    /**
     * 实体类的主键名 默认unknown
     */
    IdNameEnum id() default IdNameEnum.UNKNOWN;

}
