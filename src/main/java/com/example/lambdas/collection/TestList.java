package com.example.lambdas.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述:
 * 测试集合
 *
 * @author zed
 * @since 2019-11-27 15:03
 */
public class TestList {
    public static void main(String[] args) {

        List<Vo> list = new ArrayList<>();
        list.add(new Vo("1","1"));
        list.add(new Vo("2","2"));
        list.add(new Vo("1","1"));
        list.add(new Vo("2","2"));
        Map<String, List<Vo>> map = list.stream()
                .collect(Collectors.groupingBy(vo -> vo.getCompanyId()+"_" +vo.getId()));
        System.out.println(map.toString());
    }
    static class Vo{
        private String id;
        private String companyId;

        public Vo(String id, String companyId) {
            this.id = id;
            this.companyId = companyId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        @Override
        public String toString() {
            return "Vo{" +
                    "id='" + id + '\'' +
                    ", companyId='" + companyId + '\'' +
                    '}';
        }
    }
}
