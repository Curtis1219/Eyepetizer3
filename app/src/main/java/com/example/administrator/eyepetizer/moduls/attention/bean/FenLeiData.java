package com.example.administrator.eyepetizer.moduls.attention.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class FenLeiData {

    /**

     * nextPageUrl : http://baobab.kaiyanapp.com/api/v4/discovery/category?start=4&num=4
     */

    private int count;
    private int total;
    private String nextPageUrl;
    private List<ItemListBeanX> itemList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public List<ItemListBeanX> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBeanX> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBeanX {
        /**
         * type : squareCardCollection
         * data : {"dataType":"ItemCollection","header":{"id":1,"title":"热门分类","font":"bold","cover":null,"label":null,"actionUrl":"eyepetizer://categories/all"},"itemList":[{"type":"squareCard","data":{"dataType":"SquareCard","id":24,"title":"#时尚","image":"http://img.kaiyanapp.com/22192a40de238fe853b992ed57f1f098.jpeg","actionUrl":"eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":18,"title":"#运动","image":"http://img.kaiyanapp.com/c746d56db089909b1cdd933fa7c98ef8.jpeg","actionUrl":"eyepetizer://category/18/?title=%E8%BF%90%E5%8A%A8","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":8,"title":"#预告","image":"http://img.kaiyanapp.com/003829087e85ce7310b2210d9575ce67.jpeg","actionUrl":"eyepetizer://category/8/?title=%E9%A2%84%E5%91%8A","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":4,"title":"#开胃","image":"http://img.kaiyanapp.com/5817f1bfdce61130204a24268160b619.jpeg","actionUrl":"eyepetizer://category/4/?title=%E5%BC%80%E8%83%83","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":36,"title":"#生活","image":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","actionUrl":"eyepetizer://category/36/?title=%E7%94%9F%E6%B4%BB","shade":true,"adTrack":null},"tag":null},{"type":"actionCard","data":{"dataType":"ActionCard","id":0,"text":"查看全部","actionUrl":"eyepetizer://categories/all","adTrack":null},"tag":null}],"count":6,"adTrack":null}
         * tag : null
         */

        private String type;
        private DataBeanX data;
        private Object tag;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBeanX getData() {
            return data;
        }

        public void setData(DataBeanX data) {
            this.data = data;
        }

        public Object getTag() {
            return tag;
        }

        public void setTag(Object tag) {
            this.tag = tag;
        }

        public static class DataBeanX {
            /**
             * dataType : ItemCollection
             * header : {"id":1,"title":"热门分类","font":"bold","cover":null,"label":null,"actionUrl":"eyepetizer://categories/all"}
             * itemList : [{"type":"squareCard","data":{"dataType":"SquareCard","id":24,"title":"#时尚","image":"http://img.kaiyanapp.com/22192a40de238fe853b992ed57f1f098.jpeg","actionUrl":"eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":18,"title":"#运动","image":"http://img.kaiyanapp.com/c746d56db089909b1cdd933fa7c98ef8.jpeg","actionUrl":"eyepetizer://category/18/?title=%E8%BF%90%E5%8A%A8","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":8,"title":"#预告","image":"http://img.kaiyanapp.com/003829087e85ce7310b2210d9575ce67.jpeg","actionUrl":"eyepetizer://category/8/?title=%E9%A2%84%E5%91%8A","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":4,"title":"#开胃","image":"http://img.kaiyanapp.com/5817f1bfdce61130204a24268160b619.jpeg","actionUrl":"eyepetizer://category/4/?title=%E5%BC%80%E8%83%83","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":36,"title":"#生活","image":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","actionUrl":"eyepetizer://category/36/?title=%E7%94%9F%E6%B4%BB","shade":true,"adTrack":null},"tag":null},{"type":"actionCard","data":{"dataType":"ActionCard","id":0,"text":"查看全部","actionUrl":"eyepetizer://categories/all","adTrack":null},"tag":null}]
             * count : 6
             * adTrack : null
             */

            private String dataType;
            private HeaderBean header;
            private int count;
            private Object adTrack;
            private List<ItemListBean> itemList;

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public HeaderBean getHeader() {
                return header;
            }

            public void setHeader(HeaderBean header) {
                this.header = header;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public List<ItemListBean> getItemList() {
                return itemList;
            }

            public void setItemList(List<ItemListBean> itemList) {
                this.itemList = itemList;
            }

            public static class HeaderBean {
                /**
                 * id : 1
                 * title : 热门分类
                 * font : bold
                 * cover : null
                 * label : null
                 * actionUrl : eyepetizer://categories/all
                 */

                private int id;
                private String title;
                private String subTitle;
                private String duration;
                private String font;
                private Object cover;
                private Object label;
                private String actionUrl;

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public String getSubTitle() {
                    return subTitle;
                }

                public void setSubTitle(String subTitle) {
                    this.subTitle = subTitle;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getFont() {
                    return font;
                }

                public void setFont(String font) {
                    this.font = font;
                }

                public Object getCover() {
                    return cover;
                }

                public void setCover(Object cover) {
                    this.cover = cover;
                }

                public Object getLabel() {
                    return label;
                }

                public void setLabel(Object label) {
                    this.label = label;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }
            }

            public static class ItemListBean {
                /**
                 * type : squareCard
                 * data : {"dataType":"SquareCard","id":24,"title":"#时尚","image":"http://img.kaiyanapp.com/22192a40de238fe853b992ed57f1f098.jpeg","actionUrl":"eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A","shade":true,"adTrack":null}
                 * tag : null
                 */

                private String type;
                private DataBean data;
                private Object tag;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public DataBean getData() {
                    return data;
                }

                public void setData(DataBean data) {
                    this.data = data;
                }

                public Object getTag() {
                    return tag;
                }

                public void setTag(Object tag) {
                    this.tag = tag;
                }

                public static class DataBean {
                    /**
                     * dataType : SquareCard
                     * id : 24
                     * title : #时尚
                     * image : http://img.kaiyanapp.com/22192a40de238fe853b992ed57f1f098.jpeg
                     * actionUrl : eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A
                     * shade : true
                     * adTrack : null
                     */

                    private String dataType;
                    private int id;
                    private String title;
                    private String image;
                    private String actionUrl;
                    private boolean shade;
                    private Object adTrack;
                    private  Cover cover;
                    private String category;
                    private int duration;

                    public int getDuration() {
                        return duration;
                    }

                    public void setDuration(int duration) {
                        this.duration = duration;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public Cover getCover() {
                        return cover;
                    }

                    public void setCover(Cover cover) {
                        this.cover = cover;
                    }

                    public String getDataType() {
                        return dataType;
                    }

                    public void setDataType(String dataType) {
                        this.dataType = dataType;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public String getActionUrl() {
                        return actionUrl;
                    }

                    public void setActionUrl(String actionUrl) {
                        this.actionUrl = actionUrl;
                    }

                    public boolean isShade() {
                        return shade;
                    }

                    public void setShade(boolean shade) {
                        this.shade = shade;
                    }

                    public Object getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(Object adTrack) {
                        this.adTrack = adTrack;
                    }
                    public static class Cover{
                        private String feed;

                        public String getFeed() {
                            return feed;
                        }

                        public void setFeed(String feed) {
                            this.feed = feed;
                        }
                    }
                }
            }
        }
    }
}
