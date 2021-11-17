package dan.dirty.aoplog.dao;

import dan.dirty.aoplog.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 10:31 2021/11/17
 * @Modified By:
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    Map<String,Object> getByPrimaryKey(@Param("userId") Long userId);

    /**
     * 修改用户信息
     *
     * @param sysUser
     * @return
     */
    Integer updateByPrimaryKey(SysUser sysUser);

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    Integer deleteByPrimaryKey(@Param("userId") Long userId);

}
