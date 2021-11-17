package dan.dirty.aoplog.aspect;

import dan.dirty.aoplog.annotation.Log;
import dan.dirty.aoplog.entity.SysLog;
import dan.dirty.aoplog.enums.IdNameEnum;
import dan.dirty.aoplog.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 10:20 2021/11/17
 * @Modified By:
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(dan.dirty.aoplog.annotation.Log)")
    public void pointcutLog() {
    }

    @AfterReturning("pointcutLog()")
    public void afterReturning(JoinPoint joinPoint) {
        insertLog(joinPoint);
    }

    /**
     * 进行插入日志
     *
     * @param joinPoint
     */
    private void insertLog(JoinPoint joinPoint) {
        // 获取切点方法上的注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Log annotation = method.getAnnotation(Log.class);

        // 获取表名和操作类型
        SysLog sysLog = new SysLog();
        sysLog.setTableName(annotation.table().getName());
        sysLog.setOperType(annotation.type().getName());

        // 获取当前用户id
        /*
         */
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        Object userIdObject = requestAttributes.getRequest().getAttribute("currentUserId");
//        Long currentUserId = Long.valueOf(String.valueOf(userIdObject));
//        sysLog.setOid(currentUserId);

        // 模拟获取当前用户
        sysLog.setUserId(10086L);

        // 获取当前时间
        sysLog.setOperTime(new Timestamp(System.currentTimeMillis()));

        //获取方法参数值(按方法定义参数的顺序：google查询)
        Object[] args = joinPoint.getArgs();

        //获取Controller中传入参数(按方法定义参数的顺序：手动测试)
        LocalVariableTableParameterNameDiscoverer
                nameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = nameDiscoverer.getParameterNames(method);

        //获取idName的值
        if (parameterNames != null && args != null) {
            for (int i = 0; i < parameterNames.length; i++) {
                if (IdNameEnum.USERID.getName().equals(parameterNames[i])) {
                    sysLog.setTableId(Integer.valueOf(String.valueOf(args[i])));
                }
            }
        }

        //保存日志
        logService.insertLog(sysLog);
    }
}
