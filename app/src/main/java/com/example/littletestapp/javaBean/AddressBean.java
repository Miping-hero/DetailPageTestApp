package com.example.littletestapp.javaBean;

import java.util.List;

public class AddressBean {

    /**
     * status : OK
     * result : [{"id":196,"consignee":"leaf","country":1,"countryName":"中国","province":2,"provinceName":"北京","city":36,"cityName":"北京市","district":425,"districtName":"东城区","address":"100号","mobile":"18612312322","isdefault":true},{"id":198,"consignee":"aaa","country":1,"countryName":"中国","province":10,"provinceName":"上海","city":108,"cityName":"上海市","district":1219,"districtName":"黄浦区","address":"aaa号","mobile":"18612312312","isdefault":false}]
     * ok : true
     */

    private String status;
    private boolean ok;
    private List<ResultBean> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 196
         * consignee : leaf
         * country : 1
         * countryName : 中国
         * province : 2
         * provinceName : 北京
         * city : 36
         * cityName : 北京市
         * district : 425
         * districtName : 东城区
         * address : 100号
         * mobile : 18612312322
         * isdefault : true
         */

        private int id;
        private String consignee;
        private int country;
        private String countryName;
        private int province;
        private String provinceName;
        private int city;
        private String cityName;
        private int district;
        private String districtName;
        private String address;
        private String mobile;
        private boolean isdefault;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public int getCountry() {
            return country;
        }

        public void setCountry(int country) {
            this.country = country;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public int getDistrict() {
            return district;
        }

        public void setDistrict(int district) {
            this.district = district;
        }

        public String getDistrictName() {
            return districtName;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public boolean isIsdefault() {
            return isdefault;
        }

        public void setIsdefault(boolean isdefault) {
            this.isdefault = isdefault;
        }
    }
}
