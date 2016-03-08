package com.wang.sdfood.model;

import java.util.List;

/**
 * Created by Administrator on 2016/3/8.
 */
public class FoodDetailEntity {

    /**
     * result : ok
     * description : 成功
     * data : {"id":1734,"shareId":"1000З1734","workCount":0,"works":[],"name":"山药乌鸡汤","lastModifyDate":"2015-11-20 17:00:59 ","uploadDate":"2015-08-26 15:43:14 ","commentCount":12,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826033915859.png","referrer":{"id":"21","idstr":"","nickname":"qinzhizhang","profileImageUrl":"http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/21/180x180.jpg"},"description":"乌鸡是滋养肝肾、养血益精、健脾固冲的良药,乌鸡汤里加了山药健脾益气,更可以提高机体的免疫力.1菜品特色 食用乌鸡可以提高生理机能、延缓衰老、强筋健骨.对防治骨质疏松、佝偻病、妇女缺铁性贫血症等有明显功效.《本草纲目》认为乌骨鸡有补虚劳羸弱,制消渴...","taste":"咸鲜","cookingWay":"煮","kitchenware":"Megcook智能灶,汤锅","difficulty":"简单","times":"半小时","ingredients":[{"name":"乌骨鸡","isMain":true,"unit":"500g"},{"name":"山药","isMain":true,"unit":"500g"},{"name":"葱","isMain":false,"unit":"20g"},{"name":"盐 ","isMain":false,"unit":"20g"},{"name":"料酒 ","isMain":false,"unit":"20g"},{"name":"水","isMain":false,"unit":"1500g"},{"name":"姜","isMain":false,"unit":"20g"}],"makingSteps":[{"stepNumber":1,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826033932517.png","description":"乌骨鸡洗净切小块,山药洗净去皮切滚刀块泡水备用","temp":0,"times":0,"pause":false},{"stepNumber":2,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826033940197.jpg","description":"锅内放水乌骨鸡煮后捞出洗净备用","temp":140,"times":240,"pause":false},{"stepNumber":3,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826033950459.png","description":"锅内放水加乌骨鸡姜片葱结煮开后放入料酒 ","temp":180,"times":180,"pause":false},{"stepNumber":4,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826034949801.png","description":"加盖焖煮","temp":100,"times":1200,"pause":false},{"stepNumber":5,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826034007461.jpg","description":"放入山药煮","temp":180,"times":100,"pause":false},{"stepNumber":6,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826034030899.png","description":"煮15分后出锅","temp":100,"times":900,"pause":false}],"warmTip":"","comments":[{"id":"1654","user":{"id":"154","nickname":"Johnson","profileImageUrl":"http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/154/180x180-524.jpg"},"content":"诱人","date":"2016-01-08 16:08:24","referName":null,"referContent":null,"replyComment":null,"isLike":false,"likeCount":0},{"id":"1420","user":{"id":"175","nickname":"小杨","profileImageUrl":"http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/175/180x180-287.jpg"},"content":"不错","date":"2015-12-23 01:16:31","referName":null,"referContent":null,"replyComment":null,"isLike":false,"likeCount":0},{"id":"1073","user":{"id":"154","nickname":"Johnson","profileImageUrl":"http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/154/180x180-524.jpg"},"content":"很好","date":"2015-11-30 16:16:02","referName":null,"referContent":null,"replyComment":null,"isLike":false,"likeCount":0}],"hitsCount":213,"likeCount":22,"collectCount":16,"isCollect":false,"isLike":false,"isConcern":false,"recommend":1}
     * code : 0
     */

    private String result;
    private String description;
    /**
     * id : 1734
     * shareId : 1000З1734
     * workCount : 0
     * works : []
     * name : 山药乌鸡汤
     * lastModifyDate : 2015-11-20 17:00:59 
     * uploadDate : 2015-08-26 15:43:14 
     * commentCount : 12
     * imageUrl : http://www.xdmeishi.com/uploadfile/2015/0826/20150826033915859.png
     * referrer : {"id":"21","idstr":"","nickname":"qinzhizhang","profileImageUrl":"http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/21/180x180.jpg"}
     * description : 乌鸡是滋养肝肾、养血益精、健脾固冲的良药,乌鸡汤里加了山药健脾益气,更可以提高机体的免疫力.1菜品特色 食用乌鸡可以提高生理机能、延缓衰老、强筋健骨.对防治骨质疏松、佝偻病、妇女缺铁性贫血症等有明显功效.《本草纲目》认为乌骨鸡有补虚劳羸弱,制消渴...
     * taste : 咸鲜
     * cookingWay : 煮
     * kitchenware : Megcook智能灶,汤锅
     * difficulty : 简单
     * times : 半小时
     * ingredients : [{"name":"乌骨鸡","isMain":true,"unit":"500g"},{"name":"山药","isMain":true,"unit":"500g"},{"name":"葱","isMain":false,"unit":"20g"},{"name":"盐 ","isMain":false,"unit":"20g"},{"name":"料酒 ","isMain":false,"unit":"20g"},{"name":"水","isMain":false,"unit":"1500g"},{"name":"姜","isMain":false,"unit":"20g"}]
     * makingSteps : [{"stepNumber":1,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826033932517.png","description":"乌骨鸡洗净切小块,山药洗净去皮切滚刀块泡水备用","temp":0,"times":0,"pause":false},{"stepNumber":2,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826033940197.jpg","description":"锅内放水乌骨鸡煮后捞出洗净备用","temp":140,"times":240,"pause":false},{"stepNumber":3,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826033950459.png","description":"锅内放水加乌骨鸡姜片葱结煮开后放入料酒 ","temp":180,"times":180,"pause":false},{"stepNumber":4,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826034949801.png","description":"加盖焖煮","temp":100,"times":1200,"pause":false},{"stepNumber":5,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826034007461.jpg","description":"放入山药煮","temp":180,"times":100,"pause":false},{"stepNumber":6,"imageUrl":"http://www.xdmeishi.com/uploadfile/2015/0826/20150826034030899.png","description":"煮15分后出锅","temp":100,"times":900,"pause":false}]
     * warmTip :
     * comments : [{"id":"1654","user":{"id":"154","nickname":"Johnson","profileImageUrl":"http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/154/180x180-524.jpg"},"content":"诱人","date":"2016-01-08 16:08:24","referName":null,"referContent":null,"replyComment":null,"isLike":false,"likeCount":0},{"id":"1420","user":{"id":"175","nickname":"小杨","profileImageUrl":"http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/175/180x180-287.jpg"},"content":"不错","date":"2015-12-23 01:16:31","referName":null,"referContent":null,"replyComment":null,"isLike":false,"likeCount":0},{"id":"1073","user":{"id":"154","nickname":"Johnson","profileImageUrl":"http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/154/180x180-524.jpg"},"content":"很好","date":"2015-11-30 16:16:02","referName":null,"referContent":null,"replyComment":null,"isLike":false,"likeCount":0}]
     * hitsCount : 213
     * likeCount : 22
     * collectCount : 16
     * isCollect : false
     * isLike : false
     * isConcern : false
     * recommend : 1
     */

    private DataEntity data;
    private int code;

    public void setResult(String result) {
        this.result = result;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }

    public DataEntity getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public static class DataEntity {
        private int id;
        private String shareId;
        private int workCount;
        private String name;
        private String lastModifyDate;
        private String uploadDate;
        private int commentCount;
        private String imageUrl;
        /**
         * id : 21
         * idstr :
         * nickname : qinzhizhang
         * profileImageUrl : http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/21/180x180.jpg
         */

        private ReferrerEntity referrer;
        private String description;
        private String taste;
        private String cookingWay;
        private String kitchenware;
        private String difficulty;
        private String times;
        private String warmTip;
        private int hitsCount;
        private int likeCount;
        private int collectCount;
        private boolean isCollect;
        private boolean isLike;
        private boolean isConcern;
        private int recommend;
        private List<?> works;
        /**
         * name : 乌骨鸡
         * isMain : true
         * unit : 500g
         */

        private List<IngredientsEntity> ingredients;
        /**
         * stepNumber : 1
         * imageUrl : http://www.xdmeishi.com/uploadfile/2015/0826/20150826033932517.png
         * description : 乌骨鸡洗净切小块,山药洗净去皮切滚刀块泡水备用
         * temp : 0
         * times : 0
         * pause : false
         */

        private List<MakingStepsEntity> makingSteps;
        /**
         * id : 1654
         * user : {"id":"154","nickname":"Johnson","profileImageUrl":"http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/154/180x180-524.jpg"}
         * content : 诱人
         * date : 2016-01-08 16:08:24
         * referName : null
         * referContent : null
         * replyComment : null
         * isLike : false
         * likeCount : 0
         */

        private List<CommentsEntity> comments;

        public void setId(int id) {
            this.id = id;
        }

        public void setShareId(String shareId) {
            this.shareId = shareId;
        }

        public void setWorkCount(int workCount) {
            this.workCount = workCount;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLastModifyDate(String lastModifyDate) {
            this.lastModifyDate = lastModifyDate;
        }

        public void setUploadDate(String uploadDate) {
            this.uploadDate = uploadDate;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public void setReferrer(ReferrerEntity referrer) {
            this.referrer = referrer;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setTaste(String taste) {
            this.taste = taste;
        }

        public void setCookingWay(String cookingWay) {
            this.cookingWay = cookingWay;
        }

        public void setKitchenware(String kitchenware) {
            this.kitchenware = kitchenware;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }

        public void setTimes(String times) {
            this.times = times;
        }

        public void setWarmTip(String warmTip) {
            this.warmTip = warmTip;
        }

        public void setHitsCount(int hitsCount) {
            this.hitsCount = hitsCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public void setCollectCount(int collectCount) {
            this.collectCount = collectCount;
        }

        public void setIsCollect(boolean isCollect) {
            this.isCollect = isCollect;
        }

        public void setIsLike(boolean isLike) {
            this.isLike = isLike;
        }

        public void setIsConcern(boolean isConcern) {
            this.isConcern = isConcern;
        }

        public void setRecommend(int recommend) {
            this.recommend = recommend;
        }

        public void setWorks(List<?> works) {
            this.works = works;
        }

        public void setIngredients(List<IngredientsEntity> ingredients) {
            this.ingredients = ingredients;
        }

        public void setMakingSteps(List<MakingStepsEntity> makingSteps) {
            this.makingSteps = makingSteps;
        }

        public void setComments(List<CommentsEntity> comments) {
            this.comments = comments;
        }

        public int getId() {
            return id;
        }

        public String getShareId() {
            return shareId;
        }

        public int getWorkCount() {
            return workCount;
        }

        public String getName() {
            return name;
        }

        public String getLastModifyDate() {
            return lastModifyDate;
        }

        public String getUploadDate() {
            return uploadDate;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public ReferrerEntity getReferrer() {
            return referrer;
        }

        public String getDescription() {
            return description;
        }

        public String getTaste() {
            return taste;
        }

        public String getCookingWay() {
            return cookingWay;
        }

        public String getKitchenware() {
            return kitchenware;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public String getTimes() {
            return times;
        }

        public String getWarmTip() {
            return warmTip;
        }

        public int getHitsCount() {
            return hitsCount;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public int getCollectCount() {
            return collectCount;
        }

        public boolean isIsCollect() {
            return isCollect;
        }

        public boolean isIsLike() {
            return isLike;
        }

        public boolean isIsConcern() {
            return isConcern;
        }

        public int getRecommend() {
            return recommend;
        }

        public List<?> getWorks() {
            return works;
        }

        public List<IngredientsEntity> getIngredients() {
            return ingredients;
        }

        public List<MakingStepsEntity> getMakingSteps() {
            return makingSteps;
        }

        public List<CommentsEntity> getComments() {
            return comments;
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

        public static class IngredientsEntity {
            private String name;
            private boolean isMain;
            private String unit;

            public void setName(String name) {
                this.name = name;
            }

            public void setIsMain(boolean isMain) {
                this.isMain = isMain;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getName() {
                return name;
            }

            public boolean isIsMain() {
                return isMain;
            }

            public String getUnit() {
                return unit;
            }
        }

        public static class MakingStepsEntity {
            private int stepNumber;
            private String imageUrl;
            private String description;
            private int temp;
            private int times;
            private boolean pause;

            public void setStepNumber(int stepNumber) {
                this.stepNumber = stepNumber;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setTemp(int temp) {
                this.temp = temp;
            }

            public void setTimes(int times) {
                this.times = times;
            }

            public void setPause(boolean pause) {
                this.pause = pause;
            }

            public int getStepNumber() {
                return stepNumber;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public String getDescription() {
                return description;
            }

            public int getTemp() {
                return temp;
            }

            public int getTimes() {
                return times;
            }

            public boolean isPause() {
                return pause;
            }
        }

        public static class CommentsEntity {
            private String id;
            /**
             * id : 154
             * nickname : Johnson
             * profileImageUrl : http://www.xdmeishi.com/phpsso_server/uploadfile/avatar/1/1/154/180x180-524.jpg
             */

            private UserEntity user;
            private String content;
            private String date;
            private Object referName;
            private Object referContent;
            private Object replyComment;
            private boolean isLike;
            private int likeCount;

            public void setId(String id) {
                this.id = id;
            }

            public void setUser(UserEntity user) {
                this.user = user;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setReferName(Object referName) {
                this.referName = referName;
            }

            public void setReferContent(Object referContent) {
                this.referContent = referContent;
            }

            public void setReplyComment(Object replyComment) {
                this.replyComment = replyComment;
            }

            public void setIsLike(boolean isLike) {
                this.isLike = isLike;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public String getId() {
                return id;
            }

            public UserEntity getUser() {
                return user;
            }

            public String getContent() {
                return content;
            }

            public String getDate() {
                return date;
            }

            public Object getReferName() {
                return referName;
            }

            public Object getReferContent() {
                return referContent;
            }

            public Object getReplyComment() {
                return replyComment;
            }

            public boolean isIsLike() {
                return isLike;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public static class UserEntity {
                private String id;
                private String nickname;
                private String profileImageUrl;

                public void setId(String id) {
                    this.id = id;
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

                public String getNickname() {
                    return nickname;
                }

                public String getProfileImageUrl() {
                    return profileImageUrl;
                }
            }
        }
    }
}
