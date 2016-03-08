package com.wang.sdfood.model;

import java.util.List;

/**
 * Created by Administrator on 2016/3/8.
 */
public class CaiXiEntity {

    /**
     * result : ok
     * description : 成功
     * data : [{"id":"212","name":"拔丝苹果","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020639331.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"苹果、鸡蛋、面粉、生粉(少许）、绵白糖","collectCount":"12","commentCount":"5","lastModifyDate":"2015-12-15 16:03:56 ","uploadDate":"2014-12-02 14:06:38 ","hitscount":"597","recommend":"1"},{"id":"1506","name":"酱爆尤鱼","imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0604/20150604033503777.png","referrer":{"id":"21","idstr":"","nickname":"qinzhizhang","profileImageUrl":null},"ingredients":"鱿鱼、郫县豆瓣、海鲜酱、姜末、蒜末、朝天椒、盐、鸡精、料酒、水淀粉","collectCount":"9","commentCount":"3","lastModifyDate":"2015-06-19 16:11:20 ","uploadDate":"2015-06-04 16:03:17 ","hitscount":"99","recommend":"1"},{"id":"202","name":"山东素包子","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020621767.jpg","referrer":{"id":"23","idstr":"","nickname":"zhangsan","profileImageUrl":null},"ingredients":"北豆腐、胡萝卜、泡发黑木耳、泡发海米、泡发冬菇、鸡蛋、粉条、蚝油、生抽、盐、鸡精、葱姜水、食用油","collectCount":"5","commentCount":"2","lastModifyDate":"2015-12-16 16:06:47 ","uploadDate":"2014-12-02 14:06:20 ","hitscount":"459","recommend":"1"},{"id":"183","name":"芫爆肚丝","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020605557.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"猪肚、香菜、葱、姜、料酒、八角、胡椒粉、盐、醋","collectCount":"4","commentCount":"3","lastModifyDate":"2015-12-18 15:32:22 ","uploadDate":"2014-12-02 14:06:04 ","hitscount":"442","recommend":"1"},{"id":"1451","name":"煎酿茄子","imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0526/20150526012457617.png","referrer":{"id":"21","idstr":"","nickname":"qinzhizhang","profileImageUrl":null},"ingredients":"肉酱、茄子、油、生粉、盐、糖、黄酒、葱、姜、鸡精、生抽、水","collectCount":"4","commentCount":null,"lastModifyDate":"2015-05-26 14:02:23 ","uploadDate":"2015-05-26 14:02:23 ","hitscount":"52","recommend":"1"},{"id":"190","name":"麻汁豆角","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020610637.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"豇豆（长豆角）、麻汁、凉拌醋、生抽、蒜末、盐、鸡精","collectCount":"3","commentCount":"1","lastModifyDate":"2015-12-18 14:46:32 ","uploadDate":"2014-12-02 14:06:09 ","hitscount":"527","recommend":"1"},{"id":"176","name":"拔丝鸡蛋","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020559907.jpg","referrer":{"id":"22","idstr":"","nickname":"iceraintxd","profileImageUrl":""},"ingredients":"鸡蛋、熟白芝麻、水淀粉、面粉、糖","collectCount":"3","commentCount":"1","lastModifyDate":"2015-12-18 15:55:08 ","uploadDate":"2014-12-02 14:05:58 ","hitscount":"484","recommend":"1"},{"id":"234","name":"蜜汁山药","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020701999.jpg","referrer":{"id":"22","idstr":"","nickname":"iceraintxd","profileImageUrl":""},"ingredients":"山药、蜂蜜、胡萝卜","collectCount":"2","commentCount":"1","lastModifyDate":"2015-12-10 15:39:30 ","uploadDate":"2014-12-02 14:06:59 ","hitscount":"512","recommend":"1"},{"id":"194","name":"葱油拌金针菇","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020615596.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"金针菇、胡萝卜、黄瓜、小葱、醋、生抽、盐、蜂蜜、熟芝麻","collectCount":"2","commentCount":null,"lastModifyDate":"2015-12-17 14:37:16 ","uploadDate":"2014-12-02 14:06:14 ","hitscount":"488","recommend":"1"},{"id":"211","name":"酥肉","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020638718.jpg","referrer":{"id":"29","idstr":"0495E8D3255D30886AB3C9DDD1536F1B","nickname":"sandy","profileImageUrl":"180x180-285.jpg"},"ingredients":"五花肉、鸡蛋、生粉（或者豌豆粉，红署粉）、花椒粉、盐、鸡精、胡椒粉","collectCount":"2","commentCount":null,"lastModifyDate":"2015-12-15 16:05:48 ","uploadDate":"2014-12-02 14:06:38 ","hitscount":"481","recommend":"1"},{"id":"197","name":"糖醋鱼块","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020617278.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"草鱼肉、葱姜、蒜、番茄酱、醋、糖、干淀粉、水、料酒、盐、面粉","collectCount":"2","commentCount":null,"lastModifyDate":"2015-12-17 14:30:41 ","uploadDate":"2014-12-02 14:06:17 ","hitscount":"436","recommend":"1"},{"id":"232","name":"炸春卷","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020658238.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"普通面粉、盐、油、鸡蛋、木耳、虾皮、粉丝","collectCount":"2","commentCount":null,"lastModifyDate":"2015-12-10 15:49:01 ","uploadDate":"2014-12-02 14:06:57 ","hitscount":"353","recommend":"1"},{"id":"140","name":"炸菠菜脯","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020519170.jpg","referrer":{"id":"55","idstr":"","nickname":"老盛","profileImageUrl":"180x180-758.jpg"},"ingredients":"菠菜心、海米、猪肥彪、油豆皮、冬笋、冬菇、鸡蛋清、面粉、生粉、料酒、葱姜水","collectCount":"2","commentCount":"1","lastModifyDate":"2015-12-24 15:13:24 ","uploadDate":"2014-12-02 14:05:18 ","hitscount":"314","recommend":"1"},{"id":"180","name":"鲅鱼水饺","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020602955.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"鲅鱼、猪肥膘、韭菜、水、面粉、盐、葱姜末","collectCount":"1","commentCount":null,"lastModifyDate":"2015-12-18 15:40:04 ","uploadDate":"2014-12-02 14:06:01 ","hitscount":"566","recommend":"1"},{"id":"193","name":"酥海带","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020614602.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"泡发海带、猪后腿肉、豆腐干、泡发黄豆、酱油、香醋、白糖、葱段、姜片、料酒、盐","collectCount":"1","commentCount":null,"lastModifyDate":"2015-12-17 14:40:51 ","uploadDate":"2014-12-02 14:06:14 ","hitscount":"533","recommend":"1"},{"id":"174","name":"香酥炸肉","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020558533.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"猪瘦肉、鸡蛋、面粉、淀粉、盐、五香粉、胡椒粉、酱油、料酒","collectCount":"1","commentCount":null,"lastModifyDate":"2015-12-18 16:00:26 ","uploadDate":"2014-12-02 14:05:57 ","hitscount":"520","recommend":"1"},{"id":"238","name":"一品豆腐","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020704957.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"豆腐、鸡脯肉（去皮去筋）、虾仁（去除沙线）、鸡蛋清、配菜","collectCount":"1","commentCount":null,"lastModifyDate":"2015-12-10 14:49:23 ","uploadDate":"2014-12-02 14:07:02 ","hitscount":"518","recommend":"1"},{"id":"152","name":"泰酱木瓜煮酥肉","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020533765.jpg","referrer":{"id":"29","idstr":"0495E8D3255D30886AB3C9DDD1536F1B","nickname":"sandy","profileImageUrl":"180x180-285.jpg"},"ingredients":"五花肉、木瓜 半、洋葱、尖椒、牛油","collectCount":"1","commentCount":null,"lastModifyDate":"2015-12-24 13:34:53 ","uploadDate":"2014-12-02 14:05:32 ","hitscount":"512","recommend":"1"},{"id":"146","name":"白菜心拌海蜇","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020525161.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"海蜇、白菜心、胡萝卜、盐、醋、鸡精、香油","collectCount":"1","commentCount":null,"lastModifyDate":"2015-12-24 14:57:39 ","uploadDate":"2014-12-02 14:05:24 ","hitscount":"486","recommend":"1"},{"id":"213","name":"糖醋鲤鱼","imageUrl":"http://www.xdmeishi.com/uploadfile/2014/1202/20141202020639207.jpg","referrer":{"id":"6","idstr":"","nickname":"universe","profileImageUrl":""},"ingredients":"鲤鱼、白糖、酱油、料酒、葱、姜、蒜、醋、盐、胡椒粉、湿淀粉、水、花生油","collectCount":"1","commentCount":"1","lastModifyDate":"2015-12-15 16:02:20 ","uploadDate":"2014-12-02 14:06:39 ","hitscount":"466","recommend":"1"}]
     * code : 0
     */

    private String result;
    private String description;
    private int code;
    /**
     * id : 212
     * name : 拔丝苹果
     * imageUrl : http://www.xdmeishi.com/uploadfile/2014/1202/20141202020639331.jpg
     * referrer : {"id":"6","idstr":"","nickname":"universe","profileImageUrl":""}
     * ingredients : 苹果、鸡蛋、面粉、生粉(少许）、绵白糖
     * collectCount : 12
     * commentCount : 5
     * lastModifyDate : 2015-12-15 16:03:56 
     * uploadDate : 2014-12-02 14:06:38 
     * hitscount : 597
     * recommend : 1
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
        private String id;
        private String name;
        private String imageUrl;
        /**
         * id : 6
         * idstr :
         * nickname : universe
         * profileImageUrl :
         */

        private ReferrerEntity referrer;
        private String ingredients;
        private String collectCount;
        private String commentCount;
        private String lastModifyDate;
        private String uploadDate;
        private String hitscount;
        private String recommend;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public void setReferrer(ReferrerEntity referrer) {
            this.referrer = referrer;
        }

        public void setIngredients(String ingredients) {
            this.ingredients = ingredients;
        }

        public void setCollectCount(String collectCount) {
            this.collectCount = collectCount;
        }

        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }

        public void setLastModifyDate(String lastModifyDate) {
            this.lastModifyDate = lastModifyDate;
        }

        public void setUploadDate(String uploadDate) {
            this.uploadDate = uploadDate;
        }

        public void setHitscount(String hitscount) {
            this.hitscount = hitscount;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public ReferrerEntity getReferrer() {
            return referrer;
        }

        public String getIngredients() {
            return ingredients;
        }

        public String getCollectCount() {
            return collectCount;
        }

        public String getCommentCount() {
            return commentCount;
        }

        public String getLastModifyDate() {
            return lastModifyDate;
        }

        public String getUploadDate() {
            return uploadDate;
        }

        public String getHitscount() {
            return hitscount;
        }

        public String getRecommend() {
            return recommend;
        }

        public static class ReferrerEntity {
            private String id;
            private String idstr;
            private String nickname;
            private String profileImageUrl;

            public void setId(String id) {
                this.id = id;
            }

            public void setIdstr(String idstr) {
                this.idstr = idstr;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public void setProfileImageUrl(String profileImageUrl) {
                this.profileImageUrl = profileImageUrl;
            }

            public String getId() {
                return id;
            }

            public String getIdstr() {
                return idstr;
            }

            public String getNickname() {
                return nickname;
            }

            public String getProfileImageUrl() {
                return profileImageUrl;
            }
        }
    }
}
