package com.belong.service.gen.domain;

/**

* @Description:    列的属性
* @Author:         fengyu
* @CreateDate:     2019/11/27 16:37
* @UpdateUser:     fengyu
* @UpdateDate:     2019/11/27 16:37
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ColumnDO {
    // 列名
    private String columnName;
    // 列名类型
    private String dataType;
    // 列名备注
    private String comments;

    // 属性名称(第一个字母大写)，如：user_name => UserName
    private String attrName;
    // 属性名称(第一个字母小写)，如：user_name => userName
    private String attrname;
    // 属性类型
    private String attrType;
    // auto_increment
    private String extra;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAttrname() {
        return attrname;
    }

    public void setAttrname(String attrname) {
        this.attrname = attrname;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "ColumnDO{" + "columnName='" + columnName + '\'' + ", dataType='" + dataType + '\'' + ", comments='"
                + comments + '\'' + ", attrName='" + attrName + '\'' + ", attrname='" + attrname + '\'' + ", attrType='"
                + attrType + '\'' + ", extra='" + extra + '\'' + '}';
    }
}
