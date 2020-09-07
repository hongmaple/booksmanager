package com.common.entity;

/**
* ClassName:Users
* Description:
*/
public class Users {

    /**
    * ID
    */
        private Integer id;
    /**
    * 姓名
    */
        private String name;
    /**
    * 密码
    */
        private String password;
    /**
    * 性别
    */
        private String gender;
    /**
    * 电话号码
    */
        private String phonenumber;
    /**
    * 地址
    */
        private String address;
    /**
    * 类型
    */
        private String type;


        public Integer getId() {
        return id;
        }

        public void setId(Integer id) {
        this.id = id;
        }

        public String getName() {
        return name;
        }

        public void setName(String name) {
        this.name = name;
        }

        public String getPassword() {
        return password;
        }

        public void setPassword(String password) {
        this.password = password;
        }

        public String getGender() {
        return gender;
        }

        public void setGender(String gender) {
        this.gender = gender;
        }

        public String getPhonenumber() {
        return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        }

        public String getAddress() {
        return address;
        }

        public void setAddress(String address) {
        this.address = address;
        }

        public String getType() {
        return type;
        }

        public void setType(String type) {
        this.type = type;
        }


}