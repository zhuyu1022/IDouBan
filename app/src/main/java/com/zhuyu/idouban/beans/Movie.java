package com.zhuyu.idouban.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Name: Movie
 * Author: zhu_yu
 * Email:
 * Comment: //TODO
 * Date: 2018-10-08 14:52
 */
public class Movie implements Serializable{


        /**
         * rating : {"max":10,"average":8.1,"stars":"40","min":0}
         * genres : ["动作","犯罪"]
         * title : 无双
         * casts : [{"alt":"https://movie.douban.com/celebrity/1044899/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p205.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p205.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p205.webp"},"name":"周润发","id":"1044899"},{"alt":"https://movie.douban.com/celebrity/1041390/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p49475.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p49475.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p49475.webp"},"name":"郭富城","id":"1041390"},{"alt":"https://movie.douban.com/celebrity/1016668/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p146.webp","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p146.webp","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p146.webp"},"name":"张静初","id":"1016668"}]
         * collect_count : 182700
         * original_title : 無雙
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1014716/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3555.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3555.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3555.webp"},"name":"庄文强","id":"1014716"}]
         * year : 2018
         * images : {"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2535096871.webp","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2535096871.webp","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2535096871.webp"}
         * alt : https://movie.douban.com/subject/26425063/
         * id : 26425063
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean implements  Serializable {
            /**
             * max : 10
             * average : 8.1
             * stars : 40
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean  implements  Serializable{
            /**
             * small : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2535096871.webp
             * large : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2535096871.webp
             * medium : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2535096871.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsBean  implements  Serializable{
            /**
             * alt : https://movie.douban.com/celebrity/1044899/
             * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p205.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p205.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p205.webp"}
             * name : 周润发
             * id : 1044899
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean  implements  Serializable{
                /**
                 * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p205.webp
                 * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p205.webp
                 * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p205.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public static class DirectorsBean  implements  Serializable{
            /**
             * alt : https://movie.douban.com/celebrity/1014716/
             * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3555.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3555.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3555.webp"}
             * name : 庄文强
             * id : 1014716
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBeanX  implements  Serializable{
                /**
                 * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3555.webp
                 * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3555.webp
                 * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3555.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

}
