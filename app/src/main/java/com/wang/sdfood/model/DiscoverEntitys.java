package com.wang.sdfood.model;

import java.util.List;

/**
 * Created by user on 2016/3/8.
 */
public class DiscoverEntitys {

    /**
     * result : ok
     * description : 成功
     * data : [{"id":6,"goodsNo":"CS35EA01","goodsName":"烹饪机器人/自动炒菜机器人/智能厨房电器/云厨房/代替智能燃气灶","briefInfo":"独创\u201d智能眼\u201c技术，准确探知菜肴温度。 超级引擎技术，强劲火力，急速爆炒。 温度精准控制，无油烟。 欧洲进口玻璃面板，耐800℃高温，抗冲击。","goodsImg":"http://www.xdmeishi.com/statics/images/resource/megcook.jpg","price":6800,"actPrice":0,"goodsSpecification":"商品尺寸:750*450*55mm","salesCount":20}]
     * code : 0
     */

    private String result;
    private String description;
    private int code;
    /**
     * id : 6
     * goodsNo : CS35EA01
     * goodsName : 烹饪机器人/自动炒菜机器人/智能厨房电器/云厨房/代替智能燃气灶
     * briefInfo : 独创”智能眼“技术，准确探知菜肴温度。 超级引擎技术，强劲火力，急速爆炒。 温度精准控制，无油烟。 欧洲进口玻璃面板，耐800℃高温，抗冲击。
     * goodsImg : http://www.xdmeishi.com/statics/images/resource/megcook.jpg
     * price : 6800
     * actPrice : 0
     * goodsSpecification : 商品尺寸:750*450*55mm
     * salesCount : 20
     */

    private List<DataEntity> data;

    public void setResult(String result) {
        this.result = result;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private int id;
        private String goodsNo;
        private String goodsName;
        private String briefInfo;
        private String goodsImg;
        private int price;
        private int actPrice;
        private String goodsSpecification;
        private int salesCount;

        public void setId(int id) {
            this.id = id;
        }

        public void setGoodsNo(String goodsNo) {
            this.goodsNo = goodsNo;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public void setBriefInfo(String briefInfo) {
            this.briefInfo = briefInfo;
        }

        public void setGoodsImg(String goodsImg) {
            this.goodsImg = goodsImg;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setActPrice(int actPrice) {
            this.actPrice = actPrice;
        }

        public void setGoodsSpecification(String goodsSpecification) {
            this.goodsSpecification = goodsSpecification;
        }

        public void setSalesCount(int salesCount) {
            this.salesCount = salesCount;
        }

        public int getId() {
            return id;
        }

        public String getGoodsNo() {
            return goodsNo;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public String getBriefInfo() {
            return briefInfo;
        }

        public String getGoodsImg() {
            return goodsImg;
        }

        public int getPrice() {
            return price;
        }

        public int getActPrice() {
            return actPrice;
        }

        public String getGoodsSpecification() {
            return goodsSpecification;
        }

        public int getSalesCount() {
            return salesCount;
        }
    }
}
