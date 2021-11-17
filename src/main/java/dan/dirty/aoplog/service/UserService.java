package dan.dirty.aoplog.service;

import dan.dirty.aoplog.entity.SysUser;

import java.util.Map;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 15:48 2021/11/16
 * @Modified By:
 */
public interface UserService {
    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    Map<String, Object> getByPrimaryKey(Long userId);

    /**
     * 修改用户信息
     * @param sysUser
     * @return
     */
    Map<String, Object> updateByPrimaryKey(SysUser sysUser);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    Map<String, Object> deleteByPrimaryKey(Long userId);

}
