package com.example.administrator.eyepetizer.moduls.find.author.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */

public class AuthorInfo {


    private int count;
    private int total;
    private String nextPageUrl;
    private List<ItemListBean> itemList;

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

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {
        /**
         * type : video
         * data : {"dataType":"VideoBeanForClient","id":16519,"title":"Alex G 翻唱「CAN'T STOP THE FEELING」","description":"Alex G 和 Josh Levi 翻唱 Justing Timberlake 的热单「CAN'T STOP THE FEELING」","provider":{"name":"定制来源","alias":"CustomSrc","icon":""},"category":"音乐","author":{"id":492,"icon":"http://img.kaiyanapp.com/586b5fc918852d4759ed0260d28aa61e.jpeg?imageMogr2/quality/60/format/jpg","name":"Alex G","description":"Alexander Giannascoli (1993年生), 是来自费城的一个多才多艺的女歌手/作曲人。","link":"","latestReleaseTime":1489060826000,"videoNum":7,"adTrack":null,"follow":{"itemType":"author","itemId":492,"followed":false}},"cover":{"feed":"http://img.kaiyanapp.com/3444cbbe0621051a3dc04faf25525ff3.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/3444cbbe0621051a3dc04faf25525ff3.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/a1b5ce76c036347271abc786934f4eed.jpeg?imageMogr2/quality/60/format/jpg","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=default&source=ucloud","duration":242,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=16519","forWeibo":"http://wandou.im/3mb68d"},"releaseTime":1489060826000,"playInfo":[{"height":270,"width":480,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=low&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=low&source=qcloud"}],"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=low&source=ucloud"},{"height":480,"width":854,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=normal&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=normal&source=qcloud"}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=normal&source=ucloud"},{"height":720,"width":1280,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=high&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=high&source=qcloud"}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=high&source=ucloud"}],"consumption":{"collectionCount":31,"shareCount":15,"replyCount":0},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","subtitles":[],"titlePgc":"Alex G 翻唱「CAN'T STOP THE FEELING」","descriptionPgc":"Alex G 和 Josh Levi 翻唱 Justing Timberlake 的热单「CAN'T STOP THE FEELING」","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1489060826000,"promotion":null,"label":null,"descriptionEditor":"","collected":false,"played":false}
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
             * dataType : VideoBeanForClient
             * id : 16519
             * title : Alex G 翻唱「CAN'T STOP THE FEELING」
             * description : Alex G 和 Josh Levi 翻唱 Justing Timberlake 的热单「CAN'T STOP THE FEELING」
             * provider : {"name":"定制来源","alias":"CustomSrc","icon":""}
             * category : 音乐
             * author : {"id":492,"icon":"http://img.kaiyanapp.com/586b5fc918852d4759ed0260d28aa61e.jpeg?imageMogr2/quality/60/format/jpg","name":"Alex G","description":"Alexander Giannascoli (1993年生), 是来自费城的一个多才多艺的女歌手/作曲人。","link":"","latestReleaseTime":1489060826000,"videoNum":7,"adTrack":null,"follow":{"itemType":"author","itemId":492,"followed":false}}
             * cover : {"feed":"http://img.kaiyanapp.com/3444cbbe0621051a3dc04faf25525ff3.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/3444cbbe0621051a3dc04faf25525ff3.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/a1b5ce76c036347271abc786934f4eed.jpeg?imageMogr2/quality/60/format/jpg","sharing":null}
             * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=default&source=ucloud
             * duration : 242
             * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=16519","forWeibo":"http://wandou.im/3mb68d"}
             * releaseTime : 1489060826000
             * playInfo : [{"height":270,"width":480,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=low&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=low&source=qcloud"}],"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=low&source=ucloud"},{"height":480,"width":854,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=normal&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=normal&source=qcloud"}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=normal&source=ucloud"},{"height":720,"width":1280,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=high&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=high&source=qcloud"}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=high&source=ucloud"}]
             * consumption : {"collectionCount":31,"shareCount":15,"replyCount":0}
             * campaign : null
             * waterMarks : null
             * adTrack : null
             * tags : []
             * type : NORMAL
             * subtitles : []
             * titlePgc : Alex G 翻唱「CAN'T STOP THE FEELING」
             * descriptionPgc : Alex G 和 Josh Levi 翻唱 Justing Timberlake 的热单「CAN'T STOP THE FEELING」
             * idx : 0
             * shareAdTrack : null
             * favoriteAdTrack : null
             * webAdTrack : null
             * date : 1489060826000
             * promotion : null
             * label : null
             * descriptionEditor :
             * collected : false
             * played : false
             */

            private String text;
            private HeaderBean header;
            private List<ItemListBeanX> itemList;
            private String dataType;
            private int id;
            private String title;
            private String description;
            private ProviderBean provider;
            private String category;
            private AuthorBean author;
            private CoverBean cover;
            private String playUrl;
            private int duration;
            private WebUrlBean webUrl;
            private long releaseTime;
            private ConsumptionBean consumption;
            private Object campaign;
            private Object waterMarks;
            private Object adTrack;
            private String type;
            private String titlePgc;
            private String descriptionPgc;
            private int idx;
            private Object shareAdTrack;
            private Object favoriteAdTrack;
            private Object webAdTrack;
            private long date;
            private Object promotion;
            private Object label;
            private String descriptionEditor;
            private boolean collected;
            private boolean played;
            private List<PlayInfoBean> playInfo;
            private List<?> tags;
            private List<?> subtitles;


            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public HeaderBean getHeader() {
                return header;
            }

            public void setHeader(HeaderBean header) {
                this.header = header;
            }

            public List<ItemListBeanX> getItemList() {
                return itemList;
            }

            public void setItemList(List<ItemListBeanX> itemList) {
                this.itemList = itemList;
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public ProviderBean getProvider() {
                return provider;
            }

            public void setProvider(ProviderBean provider) {
                this.provider = provider;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public CoverBean getCover() {
                return cover;
            }

            public void setCover(CoverBean cover) {
                this.cover = cover;
            }

            public String getPlayUrl() {
                return playUrl;
            }

            public void setPlayUrl(String playUrl) {
                this.playUrl = playUrl;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public WebUrlBean getWebUrl() {
                return webUrl;
            }

            public void setWebUrl(WebUrlBean webUrl) {
                this.webUrl = webUrl;
            }

            public long getReleaseTime() {
                return releaseTime;
            }

            public void setReleaseTime(long releaseTime) {
                this.releaseTime = releaseTime;
            }

            public ConsumptionBean getConsumption() {
                return consumption;
            }

            public void setConsumption(ConsumptionBean consumption) {
                this.consumption = consumption;
            }

            public Object getCampaign() {
                return campaign;
            }

            public void setCampaign(Object campaign) {
                this.campaign = campaign;
            }

            public Object getWaterMarks() {
                return waterMarks;
            }

            public void setWaterMarks(Object waterMarks) {
                this.waterMarks = waterMarks;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitlePgc() {
                return titlePgc;
            }

            public void setTitlePgc(String titlePgc) {
                this.titlePgc = titlePgc;
            }

            public String getDescriptionPgc() {
                return descriptionPgc;
            }

            public void setDescriptionPgc(String descriptionPgc) {
                this.descriptionPgc = descriptionPgc;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            public Object getShareAdTrack() {
                return shareAdTrack;
            }

            public void setShareAdTrack(Object shareAdTrack) {
                this.shareAdTrack = shareAdTrack;
            }

            public Object getFavoriteAdTrack() {
                return favoriteAdTrack;
            }

            public void setFavoriteAdTrack(Object favoriteAdTrack) {
                this.favoriteAdTrack = favoriteAdTrack;
            }

            public Object getWebAdTrack() {
                return webAdTrack;
            }

            public void setWebAdTrack(Object webAdTrack) {
                this.webAdTrack = webAdTrack;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public Object getPromotion() {
                return promotion;
            }

            public void setPromotion(Object promotion) {
                this.promotion = promotion;
            }

            public Object getLabel() {
                return label;
            }

            public void setLabel(Object label) {
                this.label = label;
            }

            public String getDescriptionEditor() {
                return descriptionEditor;
            }

            public void setDescriptionEditor(String descriptionEditor) {
                this.descriptionEditor = descriptionEditor;
            }

            public boolean isCollected() {
                return collected;
            }

            public void setCollected(boolean collected) {
                this.collected = collected;
            }

            public boolean isPlayed() {
                return played;
            }

            public void setPlayed(boolean played) {
                this.played = played;
            }

            public List<PlayInfoBean> getPlayInfo() {
                return playInfo;
            }

            public void setPlayInfo(List<PlayInfoBean> playInfo) {
                this.playInfo = playInfo;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }

            public List<?> getSubtitles() {
                return subtitles;
            }

            public void setSubtitles(List<?> subtitles) {
                this.subtitles = subtitles;
            }

            public static class ProviderBean {
                /**
                 * name : 定制来源
                 * alias : CustomSrc
                 * icon :
                 */

                private String name;
                private String alias;
                private String icon;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAlias() {
                    return alias;
                }

                public void setAlias(String alias) {
                    this.alias = alias;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }
            }

            public static class AuthorBean {
                /**
                 * id : 492
                 * icon : http://img.kaiyanapp.com/586b5fc918852d4759ed0260d28aa61e.jpeg?imageMogr2/quality/60/format/jpg
                 * name : Alex G
                 * description : Alexander Giannascoli (1993年生), 是来自费城的一个多才多艺的女歌手/作曲人。
                 * link :
                 * latestReleaseTime : 1489060826000
                 * videoNum : 7
                 * adTrack : null
                 * follow : {"itemType":"author","itemId":492,"followed":false}
                 */

                private int id;
                private String icon;
                private String name;
                private String description;
                private String link;
                private long latestReleaseTime;
                private int videoNum;
                private Object adTrack;
                private FollowBean follow;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public long getLatestReleaseTime() {
                    return latestReleaseTime;
                }

                public void setLatestReleaseTime(long latestReleaseTime) {
                    this.latestReleaseTime = latestReleaseTime;
                }

                public int getVideoNum() {
                    return videoNum;
                }

                public void setVideoNum(int videoNum) {
                    this.videoNum = videoNum;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public FollowBean getFollow() {
                    return follow;
                }

                public void setFollow(FollowBean follow) {
                    this.follow = follow;
                }

                public static class FollowBean {
                    /**
                     * itemType : author
                     * itemId : 492
                     * followed : false
                     */

                    private String itemType;
                    private int itemId;
                    private boolean followed;

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public boolean isFollowed() {
                        return followed;
                    }

                    public void setFollowed(boolean followed) {
                        this.followed = followed;
                    }
                }
            }

            public static class CoverBean {
                /**
                 * feed : http://img.kaiyanapp.com/3444cbbe0621051a3dc04faf25525ff3.jpeg?imageMogr2/quality/60/format/jpg
                 * detail : http://img.kaiyanapp.com/3444cbbe0621051a3dc04faf25525ff3.jpeg?imageMogr2/quality/60/format/jpg
                 * blurred : http://img.kaiyanapp.com/a1b5ce76c036347271abc786934f4eed.jpeg?imageMogr2/quality/60/format/jpg
                 * sharing : null
                 */

                private String feed;
                private String detail;
                private String blurred;
                private Object sharing;

                public String getFeed() {
                    return feed;
                }

                public void setFeed(String feed) {
                    this.feed = feed;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getBlurred() {
                    return blurred;
                }

                public void setBlurred(String blurred) {
                    this.blurred = blurred;
                }

                public Object getSharing() {
                    return sharing;
                }

                public void setSharing(Object sharing) {
                    this.sharing = sharing;
                }
            }

            public static class WebUrlBean {
                /**
                 * raw : http://www.eyepetizer.net/detail.html?vid=16519
                 * forWeibo : http://wandou.im/3mb68d
                 */

                private String raw;
                private String forWeibo;

                public String getRaw() {
                    return raw;
                }

                public void setRaw(String raw) {
                    this.raw = raw;
                }

                public String getForWeibo() {
                    return forWeibo;
                }

                public void setForWeibo(String forWeibo) {
                    this.forWeibo = forWeibo;
                }
            }

            public static class ConsumptionBean {
                /**
                 * collectionCount : 31
                 * shareCount : 15
                 * replyCount : 0
                 */

                private int collectionCount;
                private int shareCount;
                private int replyCount;

                public int getCollectionCount() {
                    return collectionCount;
                }

                public void setCollectionCount(int collectionCount) {
                    this.collectionCount = collectionCount;
                }

                public int getShareCount() {
                    return shareCount;
                }

                public void setShareCount(int shareCount) {
                    this.shareCount = shareCount;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }
            }





            public static class PlayInfoBean {
                /**
                 * height : 270
                 * width : 480
                 * urlList : [{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=low&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=low&source=qcloud"}]
                 * name : 流畅
                 * type : low
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=low&source=ucloud
                 */

                private int height;
                private int width;
                private String name;
                private String type;
                private String url;
                private List<UrlListBean> urlList;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public List<UrlListBean> getUrlList() {
                    return urlList;
                }

                public void setUrlList(List<UrlListBean> urlList) {
                    this.urlList = urlList;
                }

                public static class UrlListBean {
                    /**
                     * name : ucloud
                     * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16519&editionType=low&source=ucloud
                     */

                    private String name;
                    private String url;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }


            public static class HeaderBean {
                /**
                 * id : 2
                 * title : 热门排行
                 * font : bold
                 * cover : null
                 * label : null
                 * actionUrl : eyepetizer://ranklist/
                 */

                private int id;
                private String title;
                private String font;
                private Object cover;
                private Object label;
                private String actionUrl;

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




            //xx

            public static class ItemListBeanX {
                /**
                 * type : banner
                 * data : {"dataType":"Banner","id":307,"title":"潜入思想的深海","description":"","image":"http://img.kaiyanapp.com/45ec952ff9e3a8d21dc603df4ad1d874.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E6%BD%9C%E5%85%A5%E6%80%9D%E7%BB%AA%E7%9A%84%E6%B7%B1%E6%B5%B7&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1065%26shareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":null,"card":null,"detail":null}}
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
                     * dataType : Banner
                     * id : 307
                     * title : 潜入思想的深海
                     * description :
                     * image : http://img.kaiyanapp.com/45ec952ff9e3a8d21dc603df4ad1d874.jpeg?imageMogr2/quality/60/format/jpg
                     * actionUrl : eyepetizer://webview/?title=%E6%BD%9C%E5%85%A5%E6%80%9D%E7%BB%AA%E7%9A%84%E6%B7%B1%E6%B5%B7&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1065%26shareable%3Dtrue
                     * adTrack : null
                     * shade : false
                     * label : {"text":null,"card":null,"detail":null}
                     */

                    private String dataType;
                    private int id;
                    private String title;
                    private String description;
                    private String image;
                    private String actionUrl;
                    private Object adTrack;
                    private boolean shade;
                    private LabelBean label;
                    private String text;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
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

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
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

                    public Object getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(Object adTrack) {
                        this.adTrack = adTrack;
                    }

                    public boolean isShade() {
                        return shade;
                    }

                    public void setShade(boolean shade) {
                        this.shade = shade;
                    }

                    public LabelBean getLabel() {
                        return label;
                    }

                    public void setLabel(LabelBean label) {
                        this.label = label;
                    }

                    public static class LabelBean {
                        /**
                         * text : null
                         * card : null
                         * detail : null
                         */

                        private Object text;
                        private Object card;
                        private Object detail;

                        public Object getText() {
                            return text;
                        }

                        public void setText(Object text) {
                            this.text = text;
                        }

                        public Object getCard() {
                            return card;
                        }

                        public void setCard(Object card) {
                            this.card = card;
                        }

                        public Object getDetail() {
                            return detail;
                        }

                        public void setDetail(Object detail) {
                            this.detail = detail;
                        }
                    }
                }
            }

        }
    }
}
