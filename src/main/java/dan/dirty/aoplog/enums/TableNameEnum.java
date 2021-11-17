package dan.dirty.aoplog.enums;

/**
 * @Author: JeanRiver
 * @Description:
 * @Date Created at 15:42 2021/11/16
 * @Modified By:
 */
public enum TableNameEnum {

    UNKNOWN("unknown"),
    USER("USER"),
    DEPARTMENT("department");

    private final String name;

    TableNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
