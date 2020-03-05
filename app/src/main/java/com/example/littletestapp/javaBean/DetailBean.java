package com.example.littletestapp.javaBean;

import java.util.List;

public class DetailBean {

    /**
     * status : OK
     * result : {"productSysCode":"295334","productName":"本色战袍童装多彩羽绒服","categoryId":359,"galleryList":[{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_00.jpg","imageName":"295334_00.jpg","colorCode":""},{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_30.jpg","imageName":"295334_30.jpg","colorCode":""},{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_31.jpg","imageName":"295334_31.jpg","colorCode":""},{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_32.jpg","imageName":"295334_32.jpg","colorCode":""},{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_33.jpg","imageName":"295334_33.jpg","colorCode":""},{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_34.jpg","imageName":"295334_34.jpg","colorCode":""}],"marketPrice":599,"productUrl":"/sources/images/goods/MB/295334/295334_00.jpg","protectPrice":179.7,"saleAttrList":{"saleAttr1List":[{"imageUrl":"/sources/images/goods/MB/295334/295334_00_00.jpg","saleAttr1Key":"颜色","saleAttr1Value":"亮白色","saleAttr1ValueCode":"00","stockNum":10,"barcodeSysCode":"29533400130"},{"imageUrl":"/sources/images/goods/MB/295334/295334_20_00.jpg","saleAttr1Key":"颜色","saleAttr1Value":"实样黄","saleAttr1ValueCode":"20","stockNum":10,"barcodeSysCode":"29533420130"},{"imageUrl":"/sources/images/goods/MB/295334/295334_30_00.jpg","saleAttr1Key":"颜色","saleAttr1Value":"银色","saleAttr1ValueCode":"30","stockNum":5,"barcodeSysCode":"29533430130"},{"imageUrl":"/sources/images/goods/MB/295334/295334_40_00.jpg","saleAttr1Key":"颜色","saleAttr1Value":"耀眼蓝","saleAttr1ValueCode":"40","stockNum":20,"barcodeSysCode":"29533440130"}],"saleAttr2List":[{"saleAttr2Key":"尺码","saleAttr2ValueCode":"30","saleAttr2Value":"110/56","stockNum":11,"barcodeSysCode":"29533400130"},{"saleAttr2Key":"尺码","saleAttr2ValueCode":"32","saleAttr2Value":"120/60","stockNum":6,"barcodeSysCode":"29533400132"},{"saleAttr2Key":"尺码","saleAttr2ValueCode":"34","saleAttr2Value":"130/64","stockNum":6,"barcodeSysCode":"29533400134"},{"saleAttr2Key":"尺码","saleAttr2ValueCode":"36","saleAttr2Value":"140/68","stockNum":8,"barcodeSysCode":"29533400136"},{"saleAttr2Key":"尺码","saleAttr2ValueCode":"37","saleAttr2Value":"150/72","stockNum":14,"barcodeSysCode":"29533400137"}]},"salePrice":599,"status":1,"stockNum":34991,"isChange":false,"tagPosition":"","tagName":"","firstCategoryName":"外套","commentLevel":0,"skuInfo":[{"saleAttr2ValueCode":"30","stockNum":2,"barcodeSysCode":"29533400130","saleAttr1ValueCode":"00"},{"saleAttr2ValueCode":"32","stockNum":2,"barcodeSysCode":"29533400132","saleAttr1ValueCode":"00"},{"saleAttr2ValueCode":"34","stockNum":2,"barcodeSysCode":"29533400134","saleAttr1ValueCode":"00"},{"saleAttr2ValueCode":"36","stockNum":2,"barcodeSysCode":"29533400136","saleAttr1ValueCode":"00"},{"saleAttr2ValueCode":"37","stockNum":2,"barcodeSysCode":"29533400137","saleAttr1ValueCode":"00"},{"saleAttr2ValueCode":"30","stockNum":5,"barcodeSysCode":"29533420130","saleAttr1ValueCode":"20"},{"saleAttr2ValueCode":"37","stockNum":5,"barcodeSysCode":"29533420137","saleAttr1ValueCode":"20"},{"saleAttr2ValueCode":"36","stockNum":2,"barcodeSysCode":"29533430136","saleAttr1ValueCode":"30"},{"saleAttr2ValueCode":"37","stockNum":3,"barcodeSysCode":"29533430137","saleAttr1ValueCode":"30"},{"saleAttr2ValueCode":"30","stockNum":4,"barcodeSysCode":"29533440130","saleAttr1ValueCode":"40"},{"saleAttr2ValueCode":"32","stockNum":4,"barcodeSysCode":"29533440132","saleAttr1ValueCode":"40"},{"saleAttr2ValueCode":"34","stockNum":4,"barcodeSysCode":"29533440134","saleAttr1ValueCode":"40"},{"saleAttr2ValueCode":"36","stockNum":4,"barcodeSysCode":"29533440136","saleAttr1ValueCode":"40"},{"saleAttr2ValueCode":"37","stockNum":4,"barcodeSysCode":"29533440137","saleAttr1ValueCode":"40"}],"sizePicture":"","isPromotion":"0","categoryNameList":["外套","外套","羽绒服"]}
     * ok : true
     */

    private String status;
    private ResultBean result;
    private boolean ok;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public static class ResultBean {
        /**
         * productSysCode : 295334
         * productName : 本色战袍童装多彩羽绒服
         * categoryId : 359
         * galleryList : [{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_00.jpg","imageName":"295334_00.jpg","colorCode":""},{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_30.jpg","imageName":"295334_30.jpg","colorCode":""},{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_31.jpg","imageName":"295334_31.jpg","colorCode":""},{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_32.jpg","imageName":"295334_32.jpg","colorCode":""},{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_33.jpg","imageName":"295334_33.jpg","colorCode":""},{"sellerCode":"MB","productSysCode":"295334","imageUrl":"/sources/images/goods/MB/295334/295334_34.jpg","imageName":"295334_34.jpg","colorCode":""}]
         * marketPrice : 599.0
         * productUrl : /sources/images/goods/MB/295334/295334_00.jpg
         * protectPrice : 179.7
         * saleAttrList : {"saleAttr1List":[{"imageUrl":"/sources/images/goods/MB/295334/295334_00_00.jpg","saleAttr1Key":"颜色","saleAttr1Value":"亮白色","saleAttr1ValueCode":"00","stockNum":10,"barcodeSysCode":"29533400130"},{"imageUrl":"/sources/images/goods/MB/295334/295334_20_00.jpg","saleAttr1Key":"颜色","saleAttr1Value":"实样黄","saleAttr1ValueCode":"20","stockNum":10,"barcodeSysCode":"29533420130"},{"imageUrl":"/sources/images/goods/MB/295334/295334_30_00.jpg","saleAttr1Key":"颜色","saleAttr1Value":"银色","saleAttr1ValueCode":"30","stockNum":5,"barcodeSysCode":"29533430130"},{"imageUrl":"/sources/images/goods/MB/295334/295334_40_00.jpg","saleAttr1Key":"颜色","saleAttr1Value":"耀眼蓝","saleAttr1ValueCode":"40","stockNum":20,"barcodeSysCode":"29533440130"}],"saleAttr2List":[{"saleAttr2Key":"尺码","saleAttr2ValueCode":"30","saleAttr2Value":"110/56","stockNum":11,"barcodeSysCode":"29533400130"},{"saleAttr2Key":"尺码","saleAttr2ValueCode":"32","saleAttr2Value":"120/60","stockNum":6,"barcodeSysCode":"29533400132"},{"saleAttr2Key":"尺码","saleAttr2ValueCode":"34","saleAttr2Value":"130/64","stockNum":6,"barcodeSysCode":"29533400134"},{"saleAttr2Key":"尺码","saleAttr2ValueCode":"36","saleAttr2Value":"140/68","stockNum":8,"barcodeSysCode":"29533400136"},{"saleAttr2Key":"尺码","saleAttr2ValueCode":"37","saleAttr2Value":"150/72","stockNum":14,"barcodeSysCode":"29533400137"}]}
         * salePrice : 599.0
         * status : 1
         * stockNum : 34991
         * isChange : false
         * tagPosition :
         * tagName :
         * firstCategoryName : 外套
         * commentLevel : 0
         * skuInfo : [{"saleAttr2ValueCode":"30","stockNum":2,"barcodeSysCode":"29533400130","saleAttr1ValueCode":"00"},{"saleAttr2ValueCode":"32","stockNum":2,"barcodeSysCode":"29533400132","saleAttr1ValueCode":"00"},{"saleAttr2ValueCode":"34","stockNum":2,"barcodeSysCode":"29533400134","saleAttr1ValueCode":"00"},{"saleAttr2ValueCode":"36","stockNum":2,"barcodeSysCode":"29533400136","saleAttr1ValueCode":"00"},{"saleAttr2ValueCode":"37","stockNum":2,"barcodeSysCode":"29533400137","saleAttr1ValueCode":"00"},{"saleAttr2ValueCode":"30","stockNum":5,"barcodeSysCode":"29533420130","saleAttr1ValueCode":"20"},{"saleAttr2ValueCode":"37","stockNum":5,"barcodeSysCode":"29533420137","saleAttr1ValueCode":"20"},{"saleAttr2ValueCode":"36","stockNum":2,"barcodeSysCode":"29533430136","saleAttr1ValueCode":"30"},{"saleAttr2ValueCode":"37","stockNum":3,"barcodeSysCode":"29533430137","saleAttr1ValueCode":"30"},{"saleAttr2ValueCode":"30","stockNum":4,"barcodeSysCode":"29533440130","saleAttr1ValueCode":"40"},{"saleAttr2ValueCode":"32","stockNum":4,"barcodeSysCode":"29533440132","saleAttr1ValueCode":"40"},{"saleAttr2ValueCode":"34","stockNum":4,"barcodeSysCode":"29533440134","saleAttr1ValueCode":"40"},{"saleAttr2ValueCode":"36","stockNum":4,"barcodeSysCode":"29533440136","saleAttr1ValueCode":"40"},{"saleAttr2ValueCode":"37","stockNum":4,"barcodeSysCode":"29533440137","saleAttr1ValueCode":"40"}]
         * sizePicture :
         * isPromotion : 0
         * categoryNameList : ["外套","外套","羽绒服"]
         */

        private String productSysCode;
        private String productName;
        private int categoryId;
        private double marketPrice;
        private String productUrl;
        private double protectPrice;
        private SaleAttrListBean saleAttrList;
        private double salePrice;
        private int status;
        private int stockNum;
        private boolean isChange;
        private String tagPosition;
        private String tagName;
        private String firstCategoryName;
        private int commentLevel;
        private String sizePicture;
        private String isPromotion;
        private List<GalleryListBean> galleryList;
        private List<SkuInfoBean> skuInfo;
        private List<String> categoryNameList;

        public String getProductSysCode() {
            return productSysCode;
        }

        public void setProductSysCode(String productSysCode) {
            this.productSysCode = productSysCode;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public double getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(double marketPrice) {
            this.marketPrice = marketPrice;
        }

        public String getProductUrl() {
            return productUrl;
        }

        public void setProductUrl(String productUrl) {
            this.productUrl = productUrl;
        }

        public double getProtectPrice() {
            return protectPrice;
        }

        public void setProtectPrice(double protectPrice) {
            this.protectPrice = protectPrice;
        }

        public SaleAttrListBean getSaleAttrList() {
            return saleAttrList;
        }

        public void setSaleAttrList(SaleAttrListBean saleAttrList) {
            this.saleAttrList = saleAttrList;
        }

        public double getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(double salePrice) {
            this.salePrice = salePrice;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getStockNum() {
            return stockNum;
        }

        public void setStockNum(int stockNum) {
            this.stockNum = stockNum;
        }

        public boolean isIsChange() {
            return isChange;
        }

        public void setIsChange(boolean isChange) {
            this.isChange = isChange;
        }

        public String getTagPosition() {
            return tagPosition;
        }

        public void setTagPosition(String tagPosition) {
            this.tagPosition = tagPosition;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public String getFirstCategoryName() {
            return firstCategoryName;
        }

        public void setFirstCategoryName(String firstCategoryName) {
            this.firstCategoryName = firstCategoryName;
        }

        public int getCommentLevel() {
            return commentLevel;
        }

        public void setCommentLevel(int commentLevel) {
            this.commentLevel = commentLevel;
        }

        public String getSizePicture() {
            return sizePicture;
        }

        public void setSizePicture(String sizePicture) {
            this.sizePicture = sizePicture;
        }

        public String getIsPromotion() {
            return isPromotion;
        }

        public void setIsPromotion(String isPromotion) {
            this.isPromotion = isPromotion;
        }

        public List<GalleryListBean> getGalleryList() {
            return galleryList;
        }

        public void setGalleryList(List<GalleryListBean> galleryList) {
            this.galleryList = galleryList;
        }

        public List<SkuInfoBean> getSkuInfo() {
            return skuInfo;
        }

        public void setSkuInfo(List<SkuInfoBean> skuInfo) {
            this.skuInfo = skuInfo;
        }

        public List<String> getCategoryNameList() {
            return categoryNameList;
        }

        public void setCategoryNameList(List<String> categoryNameList) {
            this.categoryNameList = categoryNameList;
        }

        public static class SaleAttrListBean {
            private List<SaleAttr1ListBean> saleAttr1List;
            private List<SaleAttr2ListBean> saleAttr2List;

            public List<SaleAttr1ListBean> getSaleAttr1List() {
                return saleAttr1List;
            }

            public void setSaleAttr1List(List<SaleAttr1ListBean> saleAttr1List) {
                this.saleAttr1List = saleAttr1List;
            }

            public List<SaleAttr2ListBean> getSaleAttr2List() {
                return saleAttr2List;
            }

            public void setSaleAttr2List(List<SaleAttr2ListBean> saleAttr2List) {
                this.saleAttr2List = saleAttr2List;
            }

            public static class SaleAttr1ListBean {
                /**
                 * imageUrl : /sources/images/goods/MB/295334/295334_00_00.jpg
                 * saleAttr1Key : 颜色
                 * saleAttr1Value : 亮白色
                 * saleAttr1ValueCode : 00
                 * stockNum : 10
                 * barcodeSysCode : 29533400130
                 */

                private String imageUrl;
                private String saleAttr1Key;
                private String saleAttr1Value;
                private String saleAttr1ValueCode;
                private int stockNum;
                private String barcodeSysCode;

                public String getImageUrl() {
                    return imageUrl;
                }

                public void setImageUrl(String imageUrl) {
                    this.imageUrl = imageUrl;
                }

                public String getSaleAttr1Key() {
                    return saleAttr1Key;
                }

                public void setSaleAttr1Key(String saleAttr1Key) {
                    this.saleAttr1Key = saleAttr1Key;
                }

                public String getSaleAttr1Value() {
                    return saleAttr1Value;
                }

                public void setSaleAttr1Value(String saleAttr1Value) {
                    this.saleAttr1Value = saleAttr1Value;
                }

                public String getSaleAttr1ValueCode() {
                    return saleAttr1ValueCode;
                }

                public void setSaleAttr1ValueCode(String saleAttr1ValueCode) {
                    this.saleAttr1ValueCode = saleAttr1ValueCode;
                }

                public int getStockNum() {
                    return stockNum;
                }

                public void setStockNum(int stockNum) {
                    this.stockNum = stockNum;
                }

                public String getBarcodeSysCode() {
                    return barcodeSysCode;
                }

                public void setBarcodeSysCode(String barcodeSysCode) {
                    this.barcodeSysCode = barcodeSysCode;
                }
            }

            public static class SaleAttr2ListBean {
                /**
                 * saleAttr2Key : 尺码
                 * saleAttr2ValueCode : 30
                 * saleAttr2Value : 110/56
                 * stockNum : 11
                 * barcodeSysCode : 29533400130
                 */

                private String saleAttr2Key;
                private String saleAttr2ValueCode;
                private String saleAttr2Value;
                private int stockNum;
                private String barcodeSysCode;

                public String getSaleAttr2Key() {
                    return saleAttr2Key;
                }

                public void setSaleAttr2Key(String saleAttr2Key) {
                    this.saleAttr2Key = saleAttr2Key;
                }

                public String getSaleAttr2ValueCode() {
                    return saleAttr2ValueCode;
                }

                public void setSaleAttr2ValueCode(String saleAttr2ValueCode) {
                    this.saleAttr2ValueCode = saleAttr2ValueCode;
                }

                public String getSaleAttr2Value() {
                    return saleAttr2Value;
                }

                public void setSaleAttr2Value(String saleAttr2Value) {
                    this.saleAttr2Value = saleAttr2Value;
                }

                public int getStockNum() {
                    return stockNum;
                }

                public void setStockNum(int stockNum) {
                    this.stockNum = stockNum;
                }

                public String getBarcodeSysCode() {
                    return barcodeSysCode;
                }

                public void setBarcodeSysCode(String barcodeSysCode) {
                    this.barcodeSysCode = barcodeSysCode;
                }
            }
        }

        public static class GalleryListBean {
            /**
             * sellerCode : MB
             * productSysCode : 295334
             * imageUrl : /sources/images/goods/MB/295334/295334_00.jpg
             * imageName : 295334_00.jpg
             * colorCode :
             */

            private String sellerCode;
            private String productSysCode;
            private String imageUrl;
            private String imageName;
            private String colorCode;

            public String getSellerCode() {
                return sellerCode;
            }

            public void setSellerCode(String sellerCode) {
                this.sellerCode = sellerCode;
            }

            public String getProductSysCode() {
                return productSysCode;
            }

            public void setProductSysCode(String productSysCode) {
                this.productSysCode = productSysCode;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getImageName() {
                return imageName;
            }

            public void setImageName(String imageName) {
                this.imageName = imageName;
            }

            public String getColorCode() {
                return colorCode;
            }

            public void setColorCode(String colorCode) {
                this.colorCode = colorCode;
            }
        }

        public static class SkuInfoBean {
            /**
             * saleAttr2ValueCode : 30
             * stockNum : 2
             * barcodeSysCode : 29533400130
             * saleAttr1ValueCode : 00
             */

            private String saleAttr2ValueCode;
            private int stockNum;
            private String barcodeSysCode;
            private String saleAttr1ValueCode;

            public String getSaleAttr2ValueCode() {
                return saleAttr2ValueCode;
            }

            public void setSaleAttr2ValueCode(String saleAttr2ValueCode) {
                this.saleAttr2ValueCode = saleAttr2ValueCode;
            }

            public int getStockNum() {
                return stockNum;
            }

            public void setStockNum(int stockNum) {
                this.stockNum = stockNum;
            }

            public String getBarcodeSysCode() {
                return barcodeSysCode;
            }

            public void setBarcodeSysCode(String barcodeSysCode) {
                this.barcodeSysCode = barcodeSysCode;
            }

            public String getSaleAttr1ValueCode() {
                return saleAttr1ValueCode;
            }

            public void setSaleAttr1ValueCode(String saleAttr1ValueCode) {
                this.saleAttr1ValueCode = saleAttr1ValueCode;
            }
        }
    }
}
