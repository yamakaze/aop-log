package dan.dirty.aoplog.enums;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 15:46 2021/11/16
 * @Modified By:
 */
public enum IdNameEnum {

    UNKNOWN("unknown"),
    USERID("userId"),
    DEPARTMENTID("departmentId");

    private final String name;

    IdNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
