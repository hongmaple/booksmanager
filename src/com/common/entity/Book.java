package com.common.entity;

/**
* ClassName:Book
* Description:
*/
public class Book {

    /**
    * ID
    */
        private Integer id;
    /**
    * isbn
    */
        private String isbn;
    /**
    * 书名
    */
        private String bookname;
    /**
    * 作者
    */
        private String author;
    /**
    * 出版社
    */
        private String press;
    /**
    * 类型
    */
        private String type;
    /**
    * 价格
    */
        private Double money;
    /**
    * 备注
    */
        private String remark;


        public Integer getId() {
        return id;
        }

        public void setId(Integer id) {
        this.id = id;
        }

        public String getIsbn() {
        return isbn;
        }

        public void setIsbn(String isbn) {
        this.isbn = isbn;
        }

        public String getBookname() {
        return bookname;
        }

        public void setBookname(String bookname) {
        this.bookname = bookname;
        }

        public String getAuthor() {
        return author;
        }

        public void setAuthor(String author) {
        this.author = author;
        }

        public String getPress() {
        return press;
        }

        public void setPress(String press) {
        this.press = press;
        }

        public String getType() {
        return type;
        }

        public void setType(String type) {
        this.type = type;
        }

        public Double getMoney() {
        return money;
        }

        public void setMoney(Double money) {
        this.money = money;
        }

        public String getRemark() {
        return remark;
        }

        public void setRemark(String remark) {
        this.remark = remark;
        }


}