package dan.dirty.aoplog.service.impl;

import dan.dirty.aoplog.dao.UserMapper;
import dan.dirty.aoplog.entity.SysUser;
import dan.dirty.aoplog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 10:28 2021/11/17
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> getByPrimaryKey(Long userId) {
        return userMapper.getByPrimaryKey(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> updateByPrimaryKey(SysUser sysUser) {
        if (userMapper.updateByPrimaryKey(sysUser) > 0) {
            return userMapper.getByPrimaryKey(sysUser.getOId());
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("result", "修改失败");
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> deleteByPrimaryKey(Long userId) {
        HashMap<String, Object> result = new HashMap<>();

        if (userMapper.deleteByPrimaryKey(userId) > 0) {
            result.put("result", "删除成功");
        } else {
            result.put("result", "删除失败");
        }
        return result;
    }
}
