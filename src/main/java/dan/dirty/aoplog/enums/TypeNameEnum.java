package dan.dirty.aoplog.enums;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 15:45 2021/11/16
 * @Modified By:
 */
public enum TypeNameEnum {

    UNKNOWN("unknown"),
    INSERT("insert"),
    UPDATE("update"),
    DELETE("delete");

    private final String name;

    TypeNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
