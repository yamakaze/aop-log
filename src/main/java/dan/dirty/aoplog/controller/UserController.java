package dan.dirty.aoplog.controller;

import dan.dirty.aoplog.annotation.Log;
import dan.dirty.aoplog.entity.SysUser;
import dan.dirty.aoplog.enums.TableNameEnum;
import dan.dirty.aoplog.enums.TypeNameEnum;
import dan.dirty.aoplog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 15:47 2021/11/16
 * @Modified By:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取一位用户信息
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping("/user/{userId}")
    public Map<String, Object> getByPrimaryKey(
            @PathVariable("userId") Long userId) {
        return userService.getByPrimaryKey(userId);
    }


    /**
     * 修改一位用户信息
     * @param sysUser
     * @param userId userId 用户id
     * @return
     */
    @PutMapping("/user/{userId}")
    @Log(table = TableNameEnum.USER, type = TypeNameEnum.UPDATE)
    public Map<String, Object> updateByPrimaryKey(
            @RequestBody SysUser sysUser,
            @PathVariable("userId") Long userId
            ) {
        sysUser.setOId(userId);
        return userService.updateByPrimaryKey(sysUser);
    }
    /**
     * 删除一位用户信息
     * @param userId userId 用户id
     * @return
     */
    @DeleteMapping("/user/{userId}")
    @Log(table = TableNameEnum.USER,type = TypeNameEnum.DELETE)
    public Map<String, Object> deleteByPrimaryKey(
            @PathVariable("userId") Long userId
    ) {
        return userService.deleteByPrimaryKey(userId);
    }

}
