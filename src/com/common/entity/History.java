package com.common.entity;

/**
* ClassName:History
* Description:
*/
public class History {

    /**
    * ID
    */
        private Integer id;
    /**
    * 借书人
    */
        private String username;
    /**
    * 书名
    */
        private String bookname;
    /**
    * 借书时间
    */
        private String lendtime;
    /**
    * 归还时间
    */
        private String backtime;
    /**
    * 备注
    */
        private String remark;
    /**
    * 状态
    */
        private String status;


        public Integer getId() {
        return id;
        }

        public void setId(Integer id) {
        this.id = id;
        }

        public String getUsername() {
        return username;
        }

        public void setUsername(String username) {
        this.username = username;
        }

        public String getBookname() {
        return bookname;
        }

        public void setBookname(String bookname) {
        this.bookname = bookname;
        }

        public String getLendtime() {
        return lendtime;
        }

        public void setLendtime(String lendtime) {
        this.lendtime = lendtime;
        }

        public String getBacktime() {
        return backtime;
        }

        public void setBacktime(String backtime) {
        this.backtime = backtime;
        }

        public String getRemark() {
        return remark;
        }

        public void setRemark(String remark) {
        this.remark = remark;
        }

        public String getStatus() {
        return status;
        }

        public void setStatus(String status) {
        this.status = status;
        }


}